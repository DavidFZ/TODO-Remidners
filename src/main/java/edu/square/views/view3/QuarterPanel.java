package edu.square.views.view3;
import javax.swing.*;
import java.awt.*;

public class QuarterPanel extends JPanel {
    JPanel namePanel = new JPanel();
    JLabel nameLabel = new JLabel();
    JPanel listPanel = new JPanel();
    int height,width;
    QuarterPanel(String s,int width, int height){
        this.height = height;
        this.width = width;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(width,height));
        nameLabel.setText(s);
        nameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
        namePanel.setPreferredSize(new Dimension(width,(int)(0.2*height)));
        namePanel.add(nameLabel);
        namePanel.setBackground(Color.WHITE);
        listPanel.setPreferredSize(new Dimension(width,(int)(0.7*height)));
        listPanel.setBackground(Color.WHITE);
        this.add(namePanel);
        this.add(listPanel);
        this.setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPanel jp = new QuarterPanel("important",400,400);
        jf.add(jp);
        jf.setVisible(true);
    }
}