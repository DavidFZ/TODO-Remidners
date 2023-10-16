package edu.square.views;

import edu.square.controller.FrameTodayController;
import edu.square.entity.Reminder;
import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.utils.UIUtils.KeyManager;
import edu.square.views.component.ReminderListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameToday {
    //font定义
    Font font1;
    Font font2;
    Font font3;
    //root Frame
    private JFrame mainFrame;
    //中间容器
    private ReminderListView reminderListView;


    public FrameToday() {
        init();

        reminderListView = new ReminderListView(mainFrame);
        JScrollPane jScrollPane = reminderListView.getScrollPane();
        mainFrame.add(jScrollPane);

//        jScrollPane.validate();
//        jScrollPane.repaint();
        mainFrame.setVisible(true);
        mainFrame.setResizable(true);
    }

    public void init() {
        mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        //定义字体
        font1 = new Font("宋体", Font.BOLD, (int) (0.05 * mainFrame.getWidth()));
        font2 = new Font("宋体", Font.BOLD, (int) (0.03 * mainFrame.getWidth()));
        font3 = new Font("宋体", Font.BOLD, (int) (0.008 * mainFrame.getWidth()));

        //对齐方式
        mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        //titlePanel
        {
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            titlePanel.setPreferredSize(new Dimension(mainFrame.getWidth(), (int) (0.12 * mainFrame.getHeight())));
//            titlePanel.setBackground(Color.black);
            mainFrame.add(titlePanel);
            //titlePanel_title
            JPanel titlePanel_title = new JPanel();
            titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
            titlePanel_title.setPreferredSize(new Dimension((int) (0.48 * mainFrame.getWidth()), (int) (0.11 * mainFrame.getHeight())));
            titlePanel_title.setBackground(Color.blue);
            titlePanel.add(titlePanel_title);

            JLabel titleLabel = new JLabel("Today");
            titleLabel.setFont(font1);
            titlePanel_title.add(titleLabel);

            //titlePanel_button
            JPanel titlePanel_button = new JPanel();
            titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
            titlePanel_button.setPreferredSize(new Dimension((int) (0.48 * mainFrame.getWidth()), (int) (0.11 * mainFrame.getHeight())));
            titlePanel_button.setBackground(Color.yellow);
            titlePanel.add(titlePanel_button);

            JButton pulsButton = new JButton("+");
            pulsButton.setFont(font2);
            pulsButton.setBackground(Color.white);
            pulsButton.setPreferredSize(new Dimension((int) (0.05 * mainFrame.getWidth()), (int) (0.05 * mainFrame.getWidth())));
            pulsButton.setVisible(true);
            titlePanel_button.add(pulsButton);


            pulsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //输入的窗口
                    JFrame printFrame = JFrameFactory.buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowHeight((int) (0.3 * mainFrame.getHeight())).setWindowWidth((int) (0.3 * mainFrame.getWidth())).setTitle("Please add item").build());

                    //item + text field
                    JPanel inputPanel;
                    JLabel inputLable;
                    JTextField itemName;
                    {
                        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        Font font2 = new Font("宋体", Font.BOLD, (int) (0.01 * mainFrame.getWidth()));
                        inputLable = new JLabel("Item:");
                        inputPanel.setBounds((int) (0.1 * printFrame.getHeight()), (int) (0.2 * printFrame.getHeight()), (int) (0.8 * printFrame.getWidth()), (int) (0.2 * printFrame.getWidth()));
                        inputLable.setFont(font2);
                        inputPanel.add(inputLable);
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

                    //The influence of click button
                    confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String item = itemName.getText();
                            if (item.length() > 0 && item.length() <= 40) {
                                //TODO: use some less invasive way to do this
                                addItem(FrameTodayController.insertReminderEntity(item));
                            }
                            else if (item.length() >= 40) {
                                String newItem = item.substring(0,39);
                                addItem(FrameTodayController.insertReminderEntity(newItem));
                            }
                            printFrame.dispose();


                        }
                    });

                    //release Enter
                    itemName.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            super.keyTyped(e);
                            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                                String item = itemName.getText();
                                if (item != null) {
                                    //TODO: use some less invasive way to do this
                                    addItem(FrameTodayController.insertReminderEntity(item));
                                }
                                printFrame.dispose();
                            }
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
    }

    public void addItem(Reminder reminder) {
//        ReminderPanelModel reminderPanelModel = new ReminderPanelModel(reminder, mainFrame);
//        mainFrame.add(reminderPanelModel);

        reminderListView.addNewReminderViewIntoReminderListView(reminder);




        mainFrame.validate();
        mainFrame.repaint();

        mainFrame.setVisible(true);
    }
}
