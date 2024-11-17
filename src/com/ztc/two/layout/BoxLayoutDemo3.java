package com.ztc.two.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout2");
        //水平容器
        Box boxHoriz = Box.createHorizontalBox();
        boxHoriz.add(new Button("水平按钮1"));
        boxHoriz.add(new Button("水平按钮2"));

        //垂直容器
        Box boxVert = Box.createVerticalBox();
        boxVert.add(new Button("垂直按钮1"));
        boxVert.add(new Button("垂直按钮2"));

        frame.add(boxHoriz,BorderLayout.NORTH);
        frame.add(boxVert);
        frame.pack();
        frame.setVisible(true);
    }
}
