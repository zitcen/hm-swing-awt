package com.ztc.two.drawn;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.awt.event.*;


/**
 * @ClassName PinBall
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/22 15:39
 */
public class PinBall {
    private Frame frame = new Frame("彈球游戲");
    //聲明一個桌面畫布
    private BallCanvas ballCanvas = new BallCanvas();

    //設置毬的大小
    private final int BALL_SIZE = 16;

    //設置球拍的大小
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //設置桌面畫布的大小
    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;

    //設置毬的運行速度，水平和垂直
    private int ySpeed = 10;
    private int xSpeed = 5;

    //設置小球的初始坐標
    private int ballX = 120;
    private int ballY = 20;

    //設置球拍的初始坐標
    private int rackeX = 120;
    private final int RACKET_Y = 340;//Y坐標不會發生變化

    //定時器
    private Timer timer;

    //定義游戲結束標志
    private boolean isLose = false;


    private void init(){
        //設置桌面畫布的大小，並設置到窗口中
        ballCanvas.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        frame.add(ballCanvas);

        //窗口和畫布都添加上鍵盤監聽事件
        frame.addKeyListener(new MyKeyListener());
        ballCanvas.addKeyListener(new MyKeyListener());

        timer = new Timer(100,new MyTimerListener());
        timer.start();

        //設置窗口的最佳大小，并設置可見
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        PinBall ball = new PinBall();
        ball.init();
    }

    //畫布的使用
    public class BallCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if(isLose){
                g.setColor(Color.BLUE);
                g.setFont(new Font("Times",Font.BOLD,30));
                g.drawString("游戲結束！",50,200);
            }else{
                g.setColor(Color.red);
                g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);
                //设置颜色并绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(rackeX,RACKET_Y,RACKET_WIDTH,RACKET_HEIGHT);
            }
        }
    }

    //自定義時間監聽器，根據時間的變化來修改小球的位置
     class MyTimerListener implements ActionListener {

         @Override
         public void actionPerformed(ActionEvent event) {

             //小球碰到左右边框
             if(ballX <= 0 || ballX>=TABLE_WIDTH-BALL_SIZE){
                 xSpeed = -xSpeed;
             }

             //小球的高度超出了球拍的位置，且横向不在球拍范围内，则游戏结束
             if(ballY > RACKET_Y && !(ballX > rackeX && ballX < rackeX + RACKET_WIDTH)){
                 //結束定時器
                 timer.stop();
                 //設置游戲結束標志為true
                 isLose = true;
                 //重绘界面
                 ballCanvas.repaint();
             }

             //如果小球横向在球拍范围内，且到达球拍位置或者到达顶端位置，则小球反弹
             if(ballY <= 0 || (ballY >= RACKET_Y-BALL_SIZE && ballX >= rackeX && ballX <= rackeX + RACKET_WIDTH)){
                ySpeed = -ySpeed;
             }

             //更新小球的坐标
             ballX = ballX + xSpeed;
             ballY = ballY + ySpeed;

             //重绘桌面
             ballCanvas.repaint();

         }
     }

    //自定義鍵盤監聽器，
    class MyKeyListener extends KeyAdapter {

        //監聽鍵盤 <-  和  -> 這兩個按鍵的作用
        @Override
        public void keyPressed(KeyEvent event) {
            int keyCode = event.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                //如果沒有到左邊界，就一直向左移動
                if(rackeX > 0){
                    rackeX -= 10;
                }
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                //如果沒有到右邊界，就一直向右移動
                if(rackeX < TABLE_WIDTH-RACKET_WIDTH){
                    rackeX += 10;
                }
            }

        }

    }
}
