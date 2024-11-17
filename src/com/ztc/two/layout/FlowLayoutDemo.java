package com.ztc.two.layout;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试FlowLayout");

        //修改Frame的默认布局方式
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,40,20));

        //添加按钮 Button组件
        for (int i = 0; i < 100; i++) {
            if(i < 10){
                frame.add(new Button("按钮0" + i));
            }else{
                frame.add(new Button("按钮" + i));
            }

        }

        frame.pack();

        frame.setVisible(true);
    }
}
