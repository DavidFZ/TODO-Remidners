package edu.square.views;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test extends JFrame {
    public Test() {
       JFrame f = new JFrame();
       f.setSize(1000,1000);
       JPanel p = new JPanel();
       p.setPreferredSize(new Dimension(600,600));
       p.setBackground(Color.BLUE);
       JPanel p2 = new JPanel();
       p2.setBackground(Color.GREEN);
       p2.setPreferredSize(new Dimension(200,200));
       JButton jb = new JButton();
       jb.setPreferredSize(new Dimension(100,100));
       jb.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               p.removeAll();
           }
       });
       p.add(jb);
       f.add(p);

       f.setVisible(true);
    }
    public static void main(String[] args) {
        new Test();
    }
}
