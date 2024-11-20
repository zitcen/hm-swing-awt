package com.ztc.two.event.containerlistener;

import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName ContainerListenerDemo
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/20 17:21
 */
public class ContainerListenerDemo {

    public static void main(String[] args) {
        Frame frame = new Frame("這裏測試監聽");
        Choice choice = new Choice();
        choice.add("柳岩");
        choice.add("蒼井空");
        choice.add("高圓圓");
        TextField tf = new TextField(30);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("添加新組件："+ child.getName());
            }
        });

        tf.addTextListener(e -> {
            System.out.println("當前内容：" + tf.getText());
        });

        choice.addItemListener( e->{
            System.out.println("當前選擇項：" + choice.getSelectedItem());
        });

        frame.add(choice,BorderLayout.WEST);
        frame.add(tf,BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
