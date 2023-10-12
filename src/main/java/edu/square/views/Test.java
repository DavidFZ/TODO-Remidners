package edu.square.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Test extends JFrame {
    public Test() {
        setTitle("Java 第二个 GUI 程序");    //设置显示窗口标题
        setBounds(100,100,400,341);    //设置窗口显示位置及尺寸
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    //设置窗口是否可见
        getContentPane().setLayout(null);//设置空布局，组件想怎么放怎么放

        JPanel panel = new JPanel();//第一个JPanel
        panel.setBorder(new LineBorder(Color.CYAN));
        panel.setBounds(10, 10, 364, 98);
        panel.add(new Label("first"));//将标签放入面板中
        getContentPane().add(panel);//将panel放入jframe界面

        JPanel panel_1 = new JPanel();//第二个JPanel

        panel_1.setBounds(10, 141, 364, 128);
        panel_1.add(new Label("second"));//这是第二个面板
        getContentPane().add(panel_1);//将panel放入jframe界面
    }
    public static void main(String[] args) {
        new Test();
    }
}
