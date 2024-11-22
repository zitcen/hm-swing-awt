package com.ztc.two.drawn.simpledraw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @ClassName SimpleDraw
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/22 14:29
 */
public class SimpleDraw {

    private Frame frame = new Frame("這裏測試繪圖");
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";

    //矩形
    private Button drawRectBtn = new Button("绘制矩形");
    //橢圓形
    private Button drawOvalBtn = new Button("绘制椭圆");

    //用来保存当前用户需要绘制什么样的图形
    private String shape="";

    //設置畫布
    private MyCanvas drawArea = new MyCanvas();

    public void init(){
        //按鈕加上事件
        drawRectBtn.addActionListener(new ButtonListener());
        drawOvalBtn.addActionListener(new ButtonListener());

        //設置組件用於裝按鈕
        Panel panel = new Panel();
        panel.add(drawOvalBtn);
        panel.add(drawRectBtn);

        //设置画布的大小
        drawArea.setPreferredSize(new Dimension(300,200));

        frame.add(drawArea);
        frame.add(panel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleDraw().init();

    }

    //按鈕的公共事件
    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String actionCommand = event.getActionCommand();
            switch (actionCommand){
                case "绘制矩形":
                    shape = RECT_SHAPE;
                    drawArea.repaint();
                    break;
                case "绘制椭圆":
                    shape = OVAL_SHAPE;
                    drawArea.repaint();
                    break;
            }
        }
    }

    //畫布的使用
    public class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            Random r = new Random();
            if (shape.equals(RECT_SHAPE)) {
                //绘制矩形
                g.setColor(Color.BLACK);
                g.drawRect(r.nextInt(200),r.nextInt(100),40,60);
            }
            if (shape.equals(OVAL_SHAPE)) {
                //绘制椭圆
                g.setColor(Color.RED);
                g.drawOval(r.nextInt(200),r.nextInt(100),60,40);
            }
        }
    }
}
