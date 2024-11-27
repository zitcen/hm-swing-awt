package com.swing;

import javax.swing.*;

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

    private void init(){
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
