package com.ztc.baseCom;

import javax.swing.*;
import java.awt.*;

public class BaseComponentDemo {
    //显示的基本窗口
    Frame frame = new Frame("这里测试基本组件");

    //多行文本域
    TextArea ta = new TextArea(5,20);

    //下拉选择框
    Choice colorChooser = new Choice();

    //单选框的单选组
    CheckboxGroup cbg = new CheckboxGroup();
    //单选框的具体信息
    Checkbox manBox = new Checkbox("男",cbg,true);
    Checkbox femaleBox = new Checkbox("女",cbg,false);

    //复选框
    Checkbox isMarried = new Checkbox("是否已婚？");

    //文本框
    TextField tf = new TextField(50);

    //按钮
    Button button = new Button("确认");

    //列表框
    List colorList = new List(6,true);

    public void init(){
        //往下拉选择框中添加内容
        colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");

        //往列表选择框中添加内容
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");
        Box tBox = Box.createHorizontalBox();
        //水平BOX放
//        Panel panel = new Panel(new BorderLayout());
//        panel.add(ta,BorderLayout.NORTH);
//        Box panelBox = Box.createHorizontalBox();
//        panelBox.add(colorChooser);
//        panelBox.add(manBox);
//        panelBox.add(femaleBox);
//        panelBox.add(isMarried);
//        panel.add(panelBox);
//        tBox.add(panel);
        Box lBox = Box.createVerticalBox();
        lBox.add(ta);
        Box lbBox = Box.createHorizontalBox();
        lbBox.add(colorChooser);
        lbBox.add(manBox);
        lbBox.add(femaleBox);
        lbBox.add(isMarried);
        lBox.add(lbBox);
        tBox.add(lBox);


        tBox.add(colorList);
        frame.add(tBox);
        Box bBox = Box.createHorizontalBox();
        bBox.add(tf);
        bBox.add(Box.createHorizontalGlue());
        bBox.add(button);
        frame.add(bBox,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BaseComponentDemo bcd = new BaseComponentDemo();
        bcd.init();
    }
}
