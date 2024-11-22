package com.ztc.two.menu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @ClassName PopupMenuDemo
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/22 10:12
 */
public class PopupMenuDemo {
    private Frame frame = new Frame("這裏測試PopupMenu");
    private PopupMenu popupMenu = new PopupMenu();
    private MenuItem commandMenuItem = new MenuItem("注釋");
    private MenuItem delCommandMenuItem = new MenuItem("取消注釋");
    private MenuItem copyMenuItem = new MenuItem("複製");
    private MenuItem saveMenuItem = new MenuItem("保存");

    private TextArea ta = new TextArea("我愛你中國", 6, 40);
    //创建一个Panel
    private Panel panel = new Panel();

    public void init() {
        popupMenu.add(commandMenuItem);
        popupMenu.add(delCommandMenuItem);
        popupMenu.add(copyMenuItem);
        popupMenu.add(saveMenuItem);

        //设置panel大小
        panel.setPreferredSize(new Dimension(300,100));
        panel.add(popupMenu);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger) {
                    popupMenu.show(panel, panel.getX(), panel.getY());
                }
            }
        });


        frame.add(ta);
        frame.add(panel,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PopupMenuDemo().init();
    }
}
