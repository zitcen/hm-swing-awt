package com.ztc.one.container;

import java.awt.*;

public class WindowDemo {
    public static void main(String[] args) {
        //创建一个窗口对象

        Frame frame = new Frame("这是第一个窗口");

        //设置窗口大小和位置

        frame.setLocation(100,100);
        frame.setSize(400,300);

        //设置窗口可见

        frame.setVisible(true);
    }
}
