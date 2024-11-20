package com.ztc.two.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @ClassName DialogDemo1
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/20 16:37
 */
public class DialogDemo1 {
    private Frame frame = new Frame("这里测试dialog");
    Dialog modelDialog = new Dialog(frame, "打开模式对话框", true);
    Dialog notModelDialog = new Dialog(frame, "打开非模式对话框", true);

    public void init(){
        Box vBox = Box.createVerticalBox();
        Button modelButton = new Button("打开模式对话框");
        Button notModelButton = new Button("打开非模式对话框");
        setListener(modelButton);
        setListener(notModelButton);
        vBox.add(modelButton);
        vBox.add(notModelButton);


        frame.add(vBox);
        frame.pack();
        frame.setVisible(true);
    }

    private void setListener(Button button){
        button.addActionListener(event ->{
            String command = event.getActionCommand();
            switch (command){
                case "打开模式对话框":
                    modelDialog.setVisible(true);
                    break;
                case "打开非模式对话框":
                    notModelDialog.setVisible(true);
                    break;
            }
        });
    }

    public static void main(String[] args) {
        DialogDemo1 demo1 = new DialogDemo1();
        demo1.init();
    }
}
