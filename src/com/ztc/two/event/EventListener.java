package com.ztc.two.event;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @ClassName EventListener
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/21 14:58
 */
public class EventListener {
    public static void main(String[] args) {
        Frame frame = new Frame("這裏測試事件處理");

        TextField tf = new TextField(30);
        frame.add(tf);
        Button button = new Button("確定");
        button.addActionListener( e -> {
            tf.setText("hello world!");
        });
        frame.add(button,BorderLayout.SOUTH);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
