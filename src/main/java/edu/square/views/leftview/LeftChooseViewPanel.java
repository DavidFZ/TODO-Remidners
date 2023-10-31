package edu.square.views.leftview;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeftChooseViewPanel extends JPanel {
    JPanel leftChoosePanel = new JPanel();
    LeftChooseViewPanel(int width,int height){
        int border = (int)(0.03*width);
        leftChoosePanel.setPreferredSize(new Dimension(width,height));
        leftChoosePanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JPanel view1Panel = new ViewChoosePanel(width,(int)(0.25*(height)),"View1","REMINDER").jp;
        JPanel view2Panel = new ViewChoosePanel(width,(int)(0.25*(height)),"View2","CALENDAR").jp;
        JPanel view3Panel = new ViewChoosePanel(width,(int)(0.25*(height)),"View3","FOUR_QUARTERS").jp;
        JPanel view4Panel = new ViewChoosePanel(width,(int)(0.25*(height)),"View4","CLOCK").jp;
        leftChoosePanel.add(view1Panel);
        leftChoosePanel.add(view2Panel);
        leftChoosePanel.add(view3Panel);
        leftChoosePanel.add(view4Panel);
        leftChoosePanel.setBackground(Color.GRAY);
//        view1Panel.setBackground(Color.RED);
//        view2Panel.setBackground(Color.RED);
//        view3Panel.setBackground(Color.RED);
//        view4Panel.setBackground(Color.RED);

        view1Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view1Panel.setBackground(Color.RED);
                view2Panel.setBackground(Color.WHITE);
                view3Panel.setBackground(Color.WHITE);
                view4Panel.setBackground(Color.WHITE);
                System.out.println("Click");
            }
        });

        view2Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view2Panel.setBackground(Color.RED);
                view1Panel.setBackground(Color.WHITE);
                view3Panel.setBackground(Color.WHITE);
                view4Panel.setBackground(Color.WHITE);
                System.out.println("Click");
            }
        });
//
        view3Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view3Panel.setBackground(Color.RED);
                view2Panel.setBackground(Color.WHITE);

                view4Panel.setBackground(Color.WHITE);
                view1Panel.setBackground(Color.WHITE);
                System.out.println("Click");
            }
        });

        view4Panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                view4Panel.setBackground(Color.RED);
                view2Panel.setBackground(Color.WHITE);
                view3Panel.setBackground(Color.WHITE);
                view1Panel.setBackground(Color.WHITE);
                System.out.println("Click");
            }
        });

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300,1000);
        JPanel jp = new LeftChooseViewPanel(300,1000).leftChoosePanel;
        jf.add(jp);
        jf.setVisible(true);
    }
}

