package com.ztc.two.layout;

import java.awt.*;

public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里是一个BorderLayout");

        //frame设置Border布局管理器
//        frame.setLayout(new BorderLayout(30, 10));
        //指定地区添加组件
//        frame.add(new Button("东侧按钮"),BorderLayout.EAST);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);
//        frame.add(new Button("西侧按钮"),BorderLayout.WEST);
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
//        frame.add(new Button("中心按钮"),BorderLayout.CENTER);
        Panel panel = new Panel();
        panel.add(new Button("中间按钮"));
        panel.add(new TextField("测试文本框"));
        frame.add(panel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
