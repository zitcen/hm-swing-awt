package com.ztc.two.drawn;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName SimpleDrawDemo
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/22 14:27
 */
public class HandDrawDemo {

    //定义画图区的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //定义变量，保存上一次鼠标拖动时，并设置鼠标的初始坐标
    private int preX = -1;
    private int preY = -1;

    //定义一个右键菜单，用于设置画笔的颜色
    PopupMenu colorMenu = new PopupMenu();
    MenuItem readMenu = new MenuItem("红色");
    MenuItem greenMenu = new MenuItem("绿色");
    MenuItem blueMenu = new MenuItem("蓝色");
    MenuItem blackMenu = new MenuItem("黑色");

    //定义一个BufferedImage对象
    private BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    //获取BufferedImage对象关联的画笔
    private Graphics graphics = image.getGraphics();
    //定义窗口对象
    private Frame frame = new Frame("简单手绘程序");

    //定义画布对象
    private Canvas drawArea = new Canvas() {
        @Override
        public void paint(Graphics g) {
            //把位图image绘制到0,0坐标点
            g.drawImage(image, 0, 0, null);
        }
    };

    //定义一个Color对象，用来保存用户设置的画笔颜色
    private Color forceColor = Color.BLACK;

    private void init() {
        //定义菜单栏的监听器
        MenuListener menuListener = new MenuListener();
        //为菜单栏添加点击事件
        readMenu.addActionListener(menuListener);
        blueMenu.addActionListener(menuListener);
        greenMenu.addActionListener(menuListener);
        blackMenu.addActionListener(menuListener);
        //将菜单添加到右键菜单栏里面
        colorMenu.add(readMenu);
        colorMenu.add(blueMenu);
        colorMenu.add(greenMenu);
        colorMenu.add(blackMenu);
        //将右键菜单栏添加到画布中
        drawArea.add(colorMenu);

        //将image背景图片设置成白色
        graphics.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

        //设置绘图区域drawArea的大小
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_WIDTH));

        //绘图区域drawArea设置鼠标移动监听器
        MouseMotionListener mouseMotionListener = new MouseMotionListener();
        drawArea.addMouseMotionListener(mouseMotionListener);

        //设置鼠标右键事件
        MouseListener mouseListener = new MouseListener();
        drawArea.addMouseListener(mouseListener);

        //将画布添加到窗口中
        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new HandDrawDemo().init();
    }

    private class MouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            //如果上次鼠标的坐标在绘图区域，才开始绘图
            if (preX > 0 && preY > 0) {
                graphics.setColor(forceColor);
                graphics.drawLine(preX, preY, e.getX(), e.getY());
            }
            System.out.println("横坐标：" + preX);
            System.out.println("竖坐标：" + preY);
            System.out.println(forceColor.toString());
            //更新preX和preY
            preX = e.getX();
            preY = e.getY();

            System.out.println("绘画");
            //重新绘制drawArea组件
            drawArea.repaint();
        }
    }

    private class MouseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            boolean popupTrigger = e.isPopupTrigger();
            if (popupTrigger) {
                //把colorMenu显示到drawArea画图区域，并跟随鼠标显示
                colorMenu.show(drawArea, e.getX(), e.getY());
            }
            //当鼠标松开时，把preX和preY重置为-1
            preX = -1;
            preY = -1;
        }
    }

    //菜单栏的监听器
    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "红色":
                    forceColor = Color.RED;
                    break;
                case "蓝色":
                    forceColor = Color.BLUE;
                    break;
                case "绿色":
                    forceColor = Color.GREEN;
                    break;
                case "黑色":
                    forceColor = Color.BLACK;
                    break;
            }
        }
    }
}
