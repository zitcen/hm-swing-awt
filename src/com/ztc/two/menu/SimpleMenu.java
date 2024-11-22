package com.ztc.two.menu;

import java.awt.*;

/**
 * @ClassName SimpleMenu
 * @Description TODO
 * @Author ztc
 * @Date 2024/11/21 17:28
 */
public class SimpleMenu {
    private Frame frame = new Frame("這裏測試菜單相關組件");

    MenuBar menuBar = new MenuBar();
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("編輯");

    //文件菜單
    MenuItem addFileItem =  new MenuItem("新增");
    MenuItem editFileItem =  new MenuItem("修改");
    MenuItem delFileItem =  new MenuItem("刪除");
    MenuItem exitItem = new MenuItem("退出");

    //編輯菜單
    private CheckboxMenuItem autoWrap = new CheckboxMenuItem("自動換行");
    MenuItem copyEditItem =  new MenuItem("複製");
    MenuItem pasteEditItem =  new MenuItem("粘貼");
    Menu formatMenu = new Menu("格式");

    MenuItem annotationEditItem =  new MenuItem("注釋");
    MenuItem delAnnotationEditItem =  new MenuItem("取消注釋");

    TextArea ta = new TextArea(6,40);

    private void init(){

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        exitItem.addActionListener( event ->{
            String command = event.getActionCommand();
            ta.append("单击“"+command+"”菜单\n");
            if (command.equals("退出")){
                System.exit(0);
            }
        });

        fileMenu.add(addFileItem);
        fileMenu.add(editFileItem);
        fileMenu.add(delFileItem);
        fileMenu.add(exitItem);
        editMenu.add(autoWrap);
        editMenu.add(copyEditItem);
        editMenu.add(pasteEditItem);
        editMenu.add(formatMenu);
        annotationEditItem.addActionListener( event ->{
            String command = event.getActionCommand();
            ta.append("单击“"+command+"”菜单\n");
            if (command.equals("退出")){
                System.exit(0);
            }
        });
        formatMenu.add(annotationEditItem);
        formatMenu.add(delAnnotationEditItem);

        frame.add(ta);
        frame.setMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SimpleMenu simpleMenu = new SimpleMenu();
        simpleMenu.init();
    }
}
