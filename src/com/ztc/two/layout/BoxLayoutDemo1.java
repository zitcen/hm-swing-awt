package com.ztc.two.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout");

//        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        frame.add(new Button("按钮1!"));
        frame.add(new Button("按钮2!"));
        frame.setLayout(boxLayout);

        frame.pack();
        frame.setVisible(true);
    }
}
