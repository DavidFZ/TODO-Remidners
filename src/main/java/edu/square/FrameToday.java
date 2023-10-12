package edu.square;

import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameToday {
    JPanel pulsPanel;
    //font定义
    Font font1;


    public FrameToday() {
        init();
    }

    public void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        JFrame frame = JFrameFactory.getDefaultJFrame("Schedule");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        Font font1 = new Font("宋体", Font.BOLD, (int) (0.05 * frame.getWidth()));
        Font font2 = new Font("宋体", Font.BOLD, (int) (0.03 * frame.getWidth()));
        //titlePanel
        {

            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            titlePanel.setPreferredSize(new Dimension(frame.getWidth(), (int) (0.12 * frame.getHeight())));
            titlePanel.setBackground(Color.black);
            frame.add(titlePanel);

            //titlePanel_title
            JPanel titlePanel_title = new JPanel();
            titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
            titlePanel_title.setPreferredSize(new Dimension((int) (0.45 * frame.getWidth()), (int) (0.11 * frame.getHeight())));
            titlePanel_title.setBackground(Color.blue);
            titlePanel.add(titlePanel_title);

            JLabel titleLabel = new JLabel("Today");
            titleLabel.setFont(font1);
            titlePanel_title.add(titleLabel);

            //titlePanel_button
            JPanel titlePanel_button = new JPanel();
            titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
            titlePanel_button.setPreferredSize(new Dimension((int) (0.45 * frame.getWidth()), (int) (0.11 * frame.getHeight())));
            titlePanel_button.setBackground(Color.yellow);
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


}
