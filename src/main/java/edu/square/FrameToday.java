package edu.square;

import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
                    //输入的窗口
                    Frame printFrame = JFrameFactory.buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowHeight((int) (0.3 * frame.getHeight())).setWindowWidth((int) (0.3 * frame.getWidth())).setTitle("Please add item").build());

                    //item + text field
                    JPanel inputPanel;
                    JLabel inputLable;
                    JTextField itemName;
                    {
                        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        Font font2 = new Font("宋体", Font.BOLD, (int) (0.01 * frame.getWidth()));
                        inputLable = new JLabel("Item:");
                        inputPanel.setBounds((int) (0.1 * printFrame.getHeight()), (int) (0.2 * printFrame.getHeight()), (int) (0.8 * printFrame.getWidth()), (int) (0.2 * printFrame.getWidth()));
                        inputLable.setFont(font2);
                        inputPanel.add(inputLable);
                        itemName = new JTextField(10);
                        inputPanel.add(itemName);

                    }


                    //Button
                    JPanel confirmPanel;
                    JButton confirmButton;

                    {
                        confirmPanel = new JPanel(new BorderLayout());
                        confirmPanel.setBounds(50, 100, 200, 200);
                        confirmButton = new JButton("confirm");
                        confirmButton.setSize(100, 100);

                    }
                    confirmPanel.add(confirmButton, BorderLayout.SOUTH);
                    printFrame.add(inputPanel);
                    printFrame.add(confirmPanel);
                    //The influence of click button

                    confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String item = itemName.getText();
                            System.out.println(item);
                            if (item != null) {
                                addItem(item);
                                System.out.println(item);
                            }
                            printFrame.dispose();


                        }
                    });
                    //if components are visible
                    itemName.setVisible(true);
                    confirmPanel.setVisible(true);
                    inputLable.setVisible(true);
                    inputPanel.setVisible(true);
                    confirmButton.setVisible(true);
                    printFrame.setVisible(true);
                }
            });
        }
        frame.setVisible(true);
        frame.setResizable(true);

    }

    public void addItem(String s) {
//        Todo 添加无刷新
//        frame.setVisible(false);
        JPanel newJPanel = new JPanel();
        newJPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        newJPanel.setPreferredSize(new Dimension((int) (0.9 * frame.getWidth()), (int) (0.08 * frame.getHeight())));
        newJPanel.setBackground(Color.green);


        JPanel newJPanelInner = new JPanel();
        newJPanelInner.setLayout(new FlowLayout(FlowLayout.LEFT));
        newJPanelInner.setPreferredSize(new Dimension((int) (0.85 * frame.getWidth()), (int) (0.07 * frame.getHeight())));
        newJPanelInner.setBorder(new LineBorder(Color.PINK));
        newJPanelInner.setBackground(Color.yellow);


        JRadioButton radioButton = new JRadioButton();


        JLabel label = new JLabel(s);
        label.setFont(font2);

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



        newJPanelInner.add(radioButton);
        newJPanelInner.add(label);
        newJPanel.add(newJPanelInner);
        frame.add(newJPanel);
        newJPanel.setVisible(true);
        newJPanelInner.setVisible(true);
        //将内容存储
        plans.add(s);

        frame.setVisible(true);

    }


}