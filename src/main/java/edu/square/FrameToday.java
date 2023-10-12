package edu.square;

import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameToday {
    JFrame frame;
    //font定义

    //维护一个容器用于记录用户输入的条目
    ArrayList<String> plans = new ArrayList<>();
    Font font1;
    Font font2;

    Font font3;


    public FrameToday() {
        init();

    }

    public void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        frame = JFrameFactory.getDefaultJFrame("Schedule");
        //定义字体
        font1 = new Font("宋体", Font.BOLD, (int) (0.05 * frame.getWidth()));
        font2 = new Font("宋体", Font.BOLD, (int) (0.03 * frame.getWidth()));
        font3 = new Font("宋体", Font.BOLD, (int) (0.008 * frame.getWidth()));

        //对其方式
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        //titlePanel
        {

            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            titlePanel.setPreferredSize(new Dimension(frame.getWidth(), (int) (0.12 * frame.getHeight())));
//            titlePanel.setBackground(Color.black);
            frame.add(titlePanel);

            //titlePanel_title
            JPanel titlePanel_title = new JPanel();
            titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
            titlePanel_title.setPreferredSize(new Dimension((int) (0.48 * frame.getWidth()), (int) (0.11 * frame.getHeight())));
//            titlePanel_title.setBackground(Color.blue);
            titlePanel.add(titlePanel_title);

            JLabel titleLabel = new JLabel("Today");
            titleLabel.setFont(font1);
            titlePanel_title.add(titleLabel);

            //titlePanel_button
            JPanel titlePanel_button = new JPanel();
            titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
            titlePanel_button.setPreferredSize(new Dimension((int) (0.48 * frame.getWidth()), (int) (0.11 * frame.getHeight())));
//            titlePanel_button.setBackground(Color.yellow);
            titlePanel.add(titlePanel_button);

            JButton pulsButton = new JButton("+");
            pulsButton.setFont(font2);
            pulsButton.setBackground(Color.white);
            pulsButton.setPreferredSize(new Dimension((int) (0.05 * frame.getWidth()), (int) (0.05 * frame.getWidth())));
            pulsButton.setVisible(true);
            titlePanel_button.add(pulsButton);
            pulsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });


        }
        frame.setVisible(true);
        frame.setResizable(true);

    }


    public void addItem(String s) {
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        newJPanel.setPreferredSize(new Dimension(frame.getWidth(), (int) (0.08 * frame.getHeight())));
//        newJPanel.setBackground(Color.green);
        frame.add(newJPanel);

        JPanel newJPanelInner = new JPanel();
        newJPanelInner.setLayout(new FlowLayout(FlowLayout.LEFT));
        newJPanelInner.setPreferredSize(new Dimension((int) (0.85 * frame.getWidth()), (int) (0.07 * frame.getHeight())));
//        newJPanelInner.setBackground(Color.yellow);
        newJPanel.add(newJPanelInner);


        JRadioButton radioButton = new JRadioButton();
        newJPanelInner.add(radioButton);

        JLabel label = new JLabel(s);
        label.setFont(font2);

        newJPanelInner.add(label);


        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    label.setForeground(Color.GRAY);
                } else {
                    label.setForeground(Color.black);
                }

            }
        });

        //将内容存储
        plans.add(s);
    }


}
