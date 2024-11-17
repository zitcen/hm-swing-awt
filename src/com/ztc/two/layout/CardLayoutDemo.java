package com.ztc.two.layout;

import java.awt.*;
import java.awt.event.ActionListener;

public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("卡片布局管理器");

        //1、创建一个Panel容器
        Panel cardPanel = new Panel();

        //2、创建一个CardLayout对象，放到上一个容器中
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        //3、向Panel容器中放入多个组件
        String[] names = {"第一张", "第二张", "第三张", "第四张", "第五张"};
        for (int i = 0; i < names.length; i++) {
            cardPanel.add(names[i], new Button(names[i]));
        }

        //4、把panel放到窗口frame中
        frame.add(cardPanel, BorderLayout.CENTER);

        //5、创建另外一个panel，用于存放多个按钮组件
        Panel buttonPanel = new Panel();
        //6、创建五个按钮
        Button button1 = new Button("第一张");
        Button button2 = new Button("最后一张");
        Button button3 = new Button("上一张");
        Button button4 = new Button("下一张");
        Button button5 = new Button("第三张");

        //7、创建一个事件监听器，监听按钮的点击动作
        ActionListener listener = event -> {
            String command = event.getActionCommand();
            switch (command) {
                case "第一张":
                    cardLayout.first(cardPanel);
                    break;
                case "最后一张":
                    cardLayout.last(cardPanel);
                    break;
                case "上一张":
                    cardLayout.previous(cardPanel);
                    break;
                case "下一张":
                    cardLayout.next(cardPanel);
                    break;
                case "第三张":
                    cardLayout.show(cardPanel, "第三张");
                    break;
            }
        };

        //8、把当前这个时间监听器和多个按钮放到一起
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        button5.addActionListener(listener);

        //9、把按钮添加到第二个容器panel中
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        //10、把第二个容器放到窗体frame中
        frame.add(buttonPanel,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
