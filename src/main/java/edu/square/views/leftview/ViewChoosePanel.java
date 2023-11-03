package edu.square.views.leftview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class ViewChoosePanel {
    JPanel jp = new JPanel();
    JLabel titleLabel = new JLabel();
    ViewChoosePanel(int width,int height,String s1,String s2){
        jp.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        jp.setPreferredSize(new Dimension(width,height));
        JPanel midPanel = new JPanel();
        JPanel highPanel = new JPanel();
        titleLabel = new JLabel(s1);
        titleLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.1*width)));
        JLabel nameLabel = new JLabel(s2);
        nameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.1*width)));
        midPanel.setPreferredSize(new Dimension(width-(int)(0.02*width),(int)(0.6*height)));
        highPanel.setPreferredSize(new Dimension(width-(int)(0.02*width),(int)(0.4*height)));
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(width-(int)(0.02*width),(int)(0.16*height)));
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        midPanel.add(titlePanel);
        midPanel.add(nameLabel);
        jp.add(highPanel);
        jp.add(midPanel);
        jp.setVisible(true);
    }
}