package com.ztc.two.drawn.gomoku;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName Gobang
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/26 14:20
 */
public class Gobang {
    private Frame frame = new Frame("五子棋游戏");

    //绘制棋盘
    private BufferedImage table;
    //绘制棋子
    private BufferedImage black;
    private BufferedImage white;

    //鼠标移动的时候，其中的棋子选择框
    private BufferedImage selected;

    //定义棋盘的宽高
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;
    //定义棋盘中，每行和每列可下子的数目
    private final int BOARD_SIZE = 15;

    //定义棋子的大小
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;

    //定义棋盘的偏移值
    //定义棋盘有效区域与背景图坐标之间的偏移值，x坐标右移5个像素，y坐标下移6个像素
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;
    /**
     * 定义一个二维数组充当棋盘上每个位置处的棋子；
     * 该数组的索引与该棋子在棋盘上的坐标需要有一个对应关系：
     * 例如： 索引[2][3]处的棋子，对一个的真实绘制坐标应该是：
     * xpos = 2*RATE+X_OFFSET=75;
     * ypos = 3*RATE+Y_OFFSET=111;
     */
    //如果存储0，代表没有棋子，如果存储1，代表黑棋，如果存储2，代表白棋
    private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    //定义变量，记录当前选中的坐标点对应的boad数组中对应的棋子索引；
    private int selectX = -1;
    private int selectY = -1;

    //棋盘组件，用于存放棋盘和棋子的图片
    private ChessBoard chessBoard = new ChessBoard();

    //获取棋盘组件的画笔
    Graphics g = chessBoard.getGraphics();


    //定义Panel,放置点击按钮
    Panel p = new Panel();
    private Button whiteBtn = new Button("白棋");
    private Button blackBtn = new Button("黑棋");
    private Button clearBtn = new Button("删除");

    //定义一个变量，记录当前用户选择下的是白棋还是黑棋还是清除，清除：0，黑棋：1，白棋：2；
    private int chessCategory = 1;


    private void init() throws IOException {

        buttonAddListener(whiteBtn);
        buttonAddListener(blackBtn);
        buttonAddListener(clearBtn);
        p.add(whiteBtn);
        p.add(blackBtn);
        p.add(clearBtn);
        //把Panel放入到frame底部
        frame.add(p, BorderLayout.SOUTH);

        //初始化黑棋，白棋，棋盘,选中框
        table = ImageIO.read(new File("readmeImage/board.jpg"));
        black = ImageIO.read(new File("readmeImage/black.gif"));
        white = ImageIO.read(new File("readmeImage/white.gif"));
        selected = ImageIO.read(new File("readmeImage/selected.gif"));

        //初始化board数组，默认情况下，所有位置处都没有棋子
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = 0;
            }
        }

        //设置chessBoard的最佳大小
        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));

        //为画布添加鼠标移动事件
        chessBoard.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //将鼠标的坐标，转换成棋子的索引
                selectX = (e.getX() - X_OFFSET) / RATE;
                selectY = (e.getY() - Y_OFFSET) / RATE;
                chessBoard.repaint();
            }
        });

        //为画布添加点击事件
        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //将用户鼠标的坐标，转换成棋子的坐标
//                int xPos = (e.getX() - X_OFFSET) / RATE;
//                int yPos = (e.getY() - Y_OFFSET) / RATE;
                int xPos = e.getX()  / RATE;
                int yPos = e.getY()  / RATE;

                board[xPos][yPos] = chessCategory;
            }

            @Override
            public void mouseExited(MouseEvent e) {

                selectX = -1;
                selectY = -1;
                chessBoard.repaint();
            }
        });

        //把chessBoard添加到Frame中
        frame.add(chessBoard);


        //设置窗口的关闭按钮
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    private void buttonAddListener(Button button) {
        button.addActionListener(event -> {
            String command = event.getActionCommand();
            switch (command) {
                case "黑棋":
                    chessCategory = 1;
                    updateBtnColor(Color.LIGHT_GRAY,Color.GREEN,Color.LIGHT_GRAY);
                    break;
                case "白棋":
                    chessCategory = 2;
                    updateBtnColor(Color.GREEN,Color.LIGHT_GRAY,Color.LIGHT_GRAY);
                    break;
                case "删除":
                    chessCategory = 0;
                    updateBtnColor(Color.LIGHT_GRAY,Color.LIGHT_GRAY,Color.GREEN);
                    break;
            }
        });
    }


    //定义五子棋游戏棋盘对应的Canvas组件
    private class ChessBoard extends Panel {
        @Override
        public void paint(Graphics g) {
            g.drawImage(table, 0, 0, null);
            //绘制选中点的红框
            if (selectX>=0 && selectY>=0){
                g.drawImage(selected,selectX*RATE+X_OFFSET,selectY*RATE+Y_OFFSET,null);
//                g.drawImage(selected,selectX*RATE,selectY*RATE,null);
            }
            //绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    //绘制黑旗
                    if (board[i][j]==1){
                        g.drawImage(black,i*RATE+X_OFFSET,j*RATE+Y_OFFSET,null);
//                        g.drawImage(black,i*RATE,j*RATE,null);
                    }

                    //绘制白棋
                    if (board[i][j]==2){
                        g.drawImage(white,i*RATE+X_OFFSET,j*RATE+Y_OFFSET,null);
//                        g.drawImage(white,i*RATE,j*RATE,null);
                    }
                }
            }

        }
    }

    public void updateBtnColor(Color whiteBtnColor,Color blackBtnColor,Color clearBtnColor){
        whiteBtn.setBackground(whiteBtnColor);
        blackBtn.setBackground(blackBtnColor);
        clearBtn.setBackground(clearBtnColor);
    }

    public static void main(String[] args) {
        try {
            new Gobang().init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
