package com.ztc.two.drawn;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName ReadAndSaveImage
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/26 9:06
 */
public class ReadAndSaveImage {

    //添加窗口
    Frame frame = new Frame("测试JFileChooser");

    //添加菜單選項
    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("文件");
    MenuItem openFile = new MenuItem("打開");
    MenuItem saveFile = new MenuItem("另存爲");

    //創建文件對象
    private BufferedImage image;

    //創建文件的畫布
    private Canvas imageComponent = new MyCanvas();


    private void init(){

        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        menuBar.add(fileMenu);
        frame.setMenuBar(menuBar);
        frame.add(imageComponent);

        openFile.addActionListener(event ->{
            FileDialog oDialog = new FileDialog(frame);
            oDialog.setVisible(true);
            String directory = oDialog.getDirectory();
            String file = oDialog.getFile();

            try {
                image = ImageIO.read(new File(directory,file));
                imageComponent.repaint();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        saveFile.addActionListener(event ->{
            FileDialog sDialog = new FileDialog(frame,"保存圖片",FileDialog.SAVE);
            sDialog.setVisible(true);
            String directory = sDialog.getDirectory();
            String file = sDialog.getFile();

            try {
                ImageIO.write(image,"png",new File(directory,file));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setBounds(300,200,800,600);
//        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ReadAndSaveImage().init();
    }



    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            if (image!=null){
                g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
            }
        }
    }
}
