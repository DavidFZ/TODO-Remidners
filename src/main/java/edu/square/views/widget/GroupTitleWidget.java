package edu.square.views.widget;

import edu.square.model.ReminderModel;
import edu.square.utils.UIUtils.ComponentResizeUtil;
import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.utils.UIUtils.JPanelUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static edu.square.model.ReminderPanelModel.font1;
import static edu.square.model.ReminderPanelModel.font2;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;
import static edu.square.utils.UIUtils.JPanelUtil.*;

public class GroupTitleWidget {
    private static final double scaling = 0.4;
    @Getter
    private JPanel mainPanel;
    @Getter
    private JLabel titleLabel;
    @Getter
    private JButton addButton;
    @Getter
    private JFrame printFrame;

    public GroupTitleWidget(JFrame parentFrame) {
        mainPanel = new JPanel();

        //对齐方式
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(new Dimension((int) (scaling * parentFrame.getWidth()), parentFrame.getHeight()));

        //titlePanel
        {
            JPanel titlePanel = getFlowJpanel(FlowLayout.CENTER, resizeDimensionWidthAndHeight(parentFrame.getSize(), scaling, 0.12));
            mainPanel.add(titlePanel);

            //titlePanelTitle
//            JPanel titlePanelTitle = getFlowLeftJpanel();
            JPanel titlePanelTitle = getFlowJpanel(FlowLayout.LEFT, resizeDimensionWidthAndHeight(parentFrame.getSize(), scaling * 0.48, 0.11));
            titlePanelTitle.setBackground(Color.blue);
            titlePanel.add(titlePanelTitle);

            titleLabel = new JLabel("All");
            titleLabel.setFont(font1);
            titlePanelTitle.add(titleLabel);

            //titlePanelButton
            JPanel titlePanelButton = getFlowJpanel(FlowLayout.RIGHT,resizeDimensionWidthAndHeight(parentFrame.getSize(), scaling * 0.48, 0.11));
            titlePanelButton.setBackground(Color.yellow);
            titlePanel.add(titlePanelButton);

            addButton = new JButton("+");
            addButton.setFont(font2);
            addButton.setBackground(Color.white);
            addButton.setPreferredSize(new Dimension((int) (0.05 * parentFrame.getWidth()), (int) (0.05 * parentFrame.getWidth())));
            addButton.setVisible(true);
            titlePanelButton.add(addButton);


            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addButton.setEnabled(false);
                    //输入的窗口
                    printFrame = JFrameFactory.buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowHeight((int) (0.3 * parentFrame.getHeight())).setWindowWidth((int) (0.3 * parentFrame.getWidth())).setTitle("Please add item").build());
                    printFrame.setAlwaysOnTop(true);

                    //item + text field
                    JPanel inputPanel;
                    JLabel inputLabel;
                    JTextField itemName;
                    {
                        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        Font font2 = new Font("宋体", Font.BOLD, (int) (0.01 * parentFrame.getWidth()));
                        inputLabel = new JLabel("Item:");
                        inputPanel.setBounds((int) (0.1 * printFrame.getHeight()), (int) (0.2 * printFrame.getHeight()), (int) (0.8 * printFrame.getWidth()), (int) (0.2 * printFrame.getWidth()));
                        inputLabel.setFont(font2);
                        inputPanel.add(inputLabel);
                        itemName = new JTextField(40);
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

                    //while input Enter will be same as click confirm button


                    confirmPanel.add(confirmButton, BorderLayout.SOUTH);
                    //two frames will not close together
                    printFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    printFrame.add(inputPanel);
                    printFrame.add(confirmPanel);


                    //release Enter

                    //if components are visible
                    itemName.setVisible(true);
                    confirmPanel.setVisible(true);
                    inputLabel.setVisible(true);
                    inputPanel.setVisible(true);
                    confirmButton.setVisible(true);
                    printFrame.setVisible(true);

                }
            });
        }
    }
}
