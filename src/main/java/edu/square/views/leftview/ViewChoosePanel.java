package edu.square.views.leftview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ViewChoosePanel {
    JPanel jp = new JPanel();
    JLabel titleLabel = new JLabel();
    ViewChoosePanel(int width,int height,String s){
        jp.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        jp.setPreferredSize(new Dimension(width,height));
        JPanel midPanel = new JPanel();
        JPanel highPanel = new JPanel();
        titleLabel = new JLabel(s);
        titleLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.1*width)));
        midPanel.setPreferredSize(new Dimension(width-(int)(0.02*width),(int)(0.56*height)));
        highPanel.setPreferredSize(new Dimension(width-(int)(0.02*width),(int)(0.45*height)));

        midPanel.add(titleLabel);
        jp.add(highPanel);
        jp.add(midPanel);
        jp.setVisible(true);
    }
}