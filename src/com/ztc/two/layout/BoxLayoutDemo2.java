package com.ztc.two.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout2");

        Panel topPanel = new Panel();
        BoxLayout boxLayout = new BoxLayout(topPanel, BoxLayout.X_AXIS);
        topPanel.add(new Button("水平按钮1!"));
        topPanel.add(new Button("水平按钮2!"));
        topPanel.setLayout(boxLayout);
        frame.add(topPanel,BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        BoxLayout buttonLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
        buttonPanel.add(new Button("垂直按钮1!"));
        buttonPanel.add(new Button("垂直按钮2!"));
        buttonPanel.setLayout(buttonLayout);
        frame.add(buttonPanel,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
