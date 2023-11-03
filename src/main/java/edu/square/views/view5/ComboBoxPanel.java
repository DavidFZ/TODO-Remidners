package edu.square.views.view5;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingDeque;

public class ComboBoxPanel extends JPanel {
    JPanel jp = new JPanel();
    ComboBoxPanel(int width,int height,String s,String[] sa){
        jp.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        jp.setPreferredSize(new Dimension(width,height));
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension((int)(0.4*width),(int)(0.9*height)));
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setPreferredSize(new Dimension((int)(0.6*width),(int)(0.9*height)));
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel(s);
        title.setFont(new Font("宋体",1,(int)(0.1*width)));
        titlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        titlePanel.add(title);
//        titlePanel.setBackground(Color.BLUE);
        JComboBox comboBox = new JComboBox<>();
        for(String item : sa){
            comboBox.addItem(item);
        }
        comboBox.setFont(new Font("宋体",1,(int)(0.06*width)));
        comboBoxPanel.add(comboBox);
        titlePanel.add(title);
        jp.add(titlePanel);
        jp.add(comboBoxPanel);
//        jp.setBackground(Color.BLUE);
        jp.setVisible(true);
    }

    public static void main(String[] args) {
        String[] s = {"1","2"};
        JFrame jf = new JFrame();
        jf.setSize(500,200);
        JPanel jp = new ComboBoxPanel(500,200,"wo",s).jp;
        jf.add(jp);
        jf.setVisible(true);
    }
}
