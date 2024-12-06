package com.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName SwingComponentDemo
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/27 15:44
 */
public class SwingComponentDemo {

    //建立窗口
    private JFrame jf = new JFrame("测试Swing的基础组件");

    //组成菜单栏
    private JMenuBar jmb = new JMenuBar();
    private JMenu fileMenu = new JMenu("文件");
    private JMenu editMenu = new JMenu("编辑");
    private JMenuItem saveFileMenu = new JMenuItem("保存");
    private JMenuItem openFileMenu = new JMenuItem("打开");
    private JMenuItem delFileMenu = new JMenuItem("删除");
    private JMenuItem autoMenu = new JMenuItem("自动换行");
    private JMenuItem copyMenu = new JMenuItem("复制");
    private JMenuItem pasteMenu = new JMenuItem("粘贴");
    private JMenu encodeMenu = new JMenu("格式");
    private JMenuItem annotationMenu = new JMenuItem("注释");
    private JMenuItem delAnnotationMenu = new JMenuItem("取消注释");
    //添加具体内容
    //定义上部分的案例
    //定义一个8行20列的多行文本域
    JTextArea ta = new JTextArea(8,20);
    //添加下拉框
    //定义一个数组存储颜色
    String[] colors = { "红色", "绿色 " , "蓝色 " };
    JComboBox<String> colorChooser = new JComboBox<String>(colors);
    //添加单选框
    JRadioButton female = new JRadioButton("女");
    JRadioButton male = new JRadioButton("男");
    //单选框组
    ButtonGroup bg = new ButtonGroup();
    //复选框
    JCheckBox married = new JCheckBox("是否已婚");
    //添加list
    JList colorList = new JList(colors);

    //底部按钮和文本框
    JTextField name = new JTextField(40);
//    Icon okIcon = new ImageIcon(ImagePathUtil.getRealPath("2\\ok.png"));
    JButton ok = new JButton("确定");

    //

    private void init(){

        Box leftBox = Box.createVerticalBox();
        JPanel boxPanel = new JPanel();
        boxPanel.add(colorChooser);
        bg.add(male);
        bg.add(female);
        boxPanel.add(male);
        boxPanel.add(female);
        boxPanel.add(married);
        leftBox.add(ta);
        leftBox.add(boxPanel);
//        jf.add(leftBox);


        Box topBox = Box.createHorizontalBox();
        topBox.add(leftBox);
        topBox.add(Box.createHorizontalGlue());
        topBox.add(colorList);
        jf.add(topBox);


        //创建文本框和按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(name);
        buttonPanel.add(ok);
        jf.add(buttonPanel,BorderLayout.SOUTH);

        //添加菜单组件
        jf.setJMenuBar(jmb);
        encodeMenu.add(annotationMenu);
        encodeMenu.add(delAnnotationMenu);
        editMenu.add(autoMenu);
        editMenu.add(copyMenu);
        editMenu.add(pasteMenu);
        editMenu.add(encodeMenu);
        fileMenu.add(saveFileMenu);
        fileMenu.add(openFileMenu);
        fileMenu.add(delFileMenu);
        jmb.add(fileMenu);
        jmb.add(editMenu);

        // 设置关闭窗口时推出程序
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置jFrame最佳大小并可见
        jf.pack();
        jf.setVisible(true);


    }



    public static void main(String[] args) {
        new SwingComponentDemo().init();
    }
}
