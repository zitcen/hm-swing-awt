package com.ztc.one.container;

import java.awt.*;

public class ScrollPanelDemo {
    public static void main(String[] args) {

        //创建一个窗口，用于存放Panel,panel不能单独存在
        Frame frame = new Frame("这里演示ScrollPanel容器");

        //创建一个panel，用于存放文本狂和按钮
        ScrollPane panel = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //创建一个文本框和按钮，并存放到panel中
        panel.add(new TextField("这里是文本域测试"));
        panel.add(new Button("这是一个测试按钮"));

        //把panel存放到window中
        frame.add(panel);

        //设置window的大小和位置
        frame.setBounds(100,200,500,300);

        //设置window的可见性
        frame.setVisible(true);
    }
}
