package edu.square;

import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            titlePanel.setBounds((int)(0.03*frame.getWidth()),(int)(0.05*frame.getHeight()),(int)(0.18*frame.getWidth()),(int)(0.18*frame.getHeight()));
            titleLabel.setFont(fontToday);
            titleLabel.setSize(titlePanel.getWidth(),titlePanel.getHeight());
            titlePanel.add(titleLabel);



        }
        //添加按键的panel-plusPanel
        JPanel pulsPanel;
        JButton pulsButton;
        {
            pulsPanel = new JPanel();
            pulsPanel.setBounds((int)(0.01*frame.getWidth()),(int)(0.20*frame.getHeight()),(int)(0.08*frame.getWidth()),(int)(0.08*frame.getHeight()));
            pulsButton = new JButton("+");
            pulsButton.setPreferredSize(new Dimension((int)(0.1*titlePanel.getWidth()),(int)(0.1*titlePanel.getWidth())));
            pulsButton.setVisible(true);
            pulsPanel.setVisible(true);
            pulsPanel.add(pulsButton);

        }
        frame.add(titlePanel);
        frame.add(pulsPanel);
        frame.setVisible(true);
        frame.setResizable(true);
//        JPanel listPanel = new JPanel();
//        Label label = new Label("TODO LIST");
//        listPanel.add(label);
//        listPanel.setVisible(true);
//        frame.add(listPanel);





        //点击加号

        pulsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //输入的窗口
                Frame printFrame = JFrameFactory.getDefaultJFrame("Please add item");
                printFrame.setBounds((int)(3*frame.getX()),(int)(3*frame.getY()),(int)(0.3*frame.getWidth()),(int)(0.3*frame.getHeight()));

                //item + text field
                JPanel inputPanel;
                JLabel inputLable;
                JTextField itemName;
                {
                    inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    Font font2 = new Font("宋体",Font.BOLD,(int)(0.01*frame.getWidth()));
                    inputLable = new JLabel("Item:");
                    inputPanel.setBounds((int)(0.1*printFrame.getHeight()),(int)(0.2*printFrame.getHeight()),(int)(0.8*printFrame.getWidth()),(int)(0.2*printFrame.getWidth()));
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
                    confirmPanel.setBounds(50,100,200,200);
                    confirmButton = new JButton("confirm");
                    confirmButton.setSize(100,100);

                }
                confirmPanel.add(confirmButton,BorderLayout.SOUTH);
                printFrame.add(inputPanel);
                printFrame.add(confirmPanel);



                //The influence of click button

                confirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

//                        additem(s);
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




//        frame.setSize((int)(0.75 * toolkit.getScreenSize().width),(int)(0.75 * toolkit.getScreenSize().height));



//        JPanel panel = new JPanel(new BorderLayout());
//

//
//        JPanel todoPanel = new JPanel();
//        todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));
//
//        panel.add(listPanel, BorderLayout.WEST);
//        panel.add(todoPanel, BorderLayout.CENTER);
        //可视
//        label.setVisible(true);

//        panel.setVisible(true);
//
//        frame.add(panel);

    }
}