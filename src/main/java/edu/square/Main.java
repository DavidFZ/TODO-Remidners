package edu.square;

import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame frame = JFrameFactory.getDefaultJFrame("Schedule");
        //Today 大小标题
        Font fontToday = new Font("宋体",Font.BOLD,(int)(0.05*frame.getWidth()));



        //标题的panel-titlePanel
        JPanel titlePanel;
        {
            //Today label
            titlePanel= new JPanel();
            JLabel titleLabel = new JLabel("Today");
            titleLabel.setBackground(Color.BLACK);
//            titlePanel.setBackground(Color.BLUE);
            titlePanel.setBounds((int)(0.03*frame.getWidth()),(int)(0.05*frame.getHeight()),(int)(0.18*frame.getWidth()),(int)(0.18*frame.getHeight()));

            titleLabel.setFont(fontToday);
            titleLabel.setSize(titlePanel.getWidth(),titlePanel.getHeight());
            titlePanel.add(titleLabel);



        }
        //添加按键的panel-plusPanel
        JPanel pulsPanel;
        {
            pulsPanel = new JPanel();
            pulsPanel.setBounds((int)(0.01*frame.getWidth()),(int)(0.20*frame.getHeight()),(int)(0.08*frame.getWidth()),(int)(0.08*frame.getHeight()));
            JButton pulsButton = new JButton("+");
            pulsButton.setPreferredSize(new Dimension((int)(0.1*titlePanel.getWidth()),(int)(0.1*titlePanel.getWidth())));
            pulsButton.setVisible(true);
            pulsPanel.setVisible(true);
            pulsPanel.add(pulsButton);

        }



        frame.add(titlePanel);

//        frame.setSize((int)(0.75 * toolkit.getScreenSize().width),(int)(0.75 * toolkit.getScreenSize().height));



//        JPanel panel = new JPanel(new BorderLayout());
//
        JPanel listPanel = new JPanel();
        Label label = new Label("TODO LIST");
        listPanel.add(label);
//
//        JPanel todoPanel = new JPanel();
//        todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));
//
//        panel.add(listPanel, BorderLayout.WEST);
//        panel.add(todoPanel, BorderLayout.CENTER);
        //可视
//        label.setVisible(true);
        listPanel.setVisible(true);
//        panel.setVisible(true);
//
//        frame.add(panel);
        frame.add(pulsPanel);
        frame.add(listPanel);
        frame.setVisible(true);
        frame.setResizable(true);
    }
}