package com.ztc.two.layout;

import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");


        Panel panel1 = new Panel();
        panel1.add(new TextField(30));

        frame.add(panel1,BorderLayout.NORTH);


        GridLayout gridLayout = new GridLayout(3, 5, 4, 4);
        Panel panel2 = new Panel(gridLayout);

        for (int i = 0; i < gridLayout.getColumns()*gridLayout.getColumns(); i++) {
            if(i < 10){
                panel2.add(new Button("" + i));
            }else if(i == 10){
                panel2.add(new Button("+" ));
            }else if(i == 11){
                panel2.add(new Button("-" ));
            }else if(i == 12){
                panel2.add(new Button("*" ));
            }else if(i == 13){
                panel2.add(new Button("/" ));
            }else if(i == 14){
                panel2.add(new Button("." ));
            }
        }

        frame.add(panel2,BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
