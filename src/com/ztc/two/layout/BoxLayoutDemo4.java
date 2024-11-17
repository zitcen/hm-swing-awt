package com.ztc.two.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo4 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout2");

        Box hBox = Box.createHorizontalBox();
        hBox.add(new Button("水平按钮1"));
        hBox.add(Box.createHorizontalGlue());
        hBox.add(new Button("水平按钮2"));
        hBox.add(Box.createHorizontalStrut(5));
        hBox.add(new Button("水平按钮3"));

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("垂直按钮1"));
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("垂直按钮2"));
        vBox.add(Box.createVerticalStrut(5));
        vBox.add(new Button("垂直按钮3"));

        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);

        frame.pack();
        frame.setVisible(true);
    }
}
