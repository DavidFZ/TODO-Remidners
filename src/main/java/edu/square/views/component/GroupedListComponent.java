package edu.square.views.component;

import edu.square.entity.Reminder;
import edu.square.model.ReminderModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.widget.ReminderListWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GroupedListComponent {
    private final JFrame parentFrame;
    //中间容器
    @Getter
    private final ReminderListWidget reminderListWidget;
    private final double scaling = 0.4;
    //font定义
    Font font1;
    Font font2;
    Font font3;
    @Getter
    JButton addButton;
    //root Frame
    @Getter
    private JPanel mainPanel;
    @Getter
    private JLabel titleLabel;
    @Getter
    private JFrame printFrame;
    @Getter
    private JButton confirmButton;


    public GroupedListComponent(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        font1 = FontUtil.getBoldFont(parentFrame.getSize(), 0.05);
        font2 = FontUtil.getBoldFont(parentFrame.getSize(), 0.03);
        font3 = FontUtil.getBoldFont(parentFrame.getSize(), 0.008);

        init();

        reminderListWidget = new ReminderListWidget(parentFrame);
        mainPanel.add(reminderListWidget.getScrollPane());


        mainPanel.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(0.8d, "GroupedListComponentTest");
        GroupedListComponent groupedListComponent = new GroupedListComponent(jFrame);
        jFrame.add(groupedListComponent.getMainPanel());
        jFrame.setVisible(true);

    }

    //TODO: encapsulate this method as a widget
    public void init() {
        mainPanel = new JPanel();
        confirmButton = new JButton("confirm");
        // Instantiate a button in advance
        // Void null pointer exception when add reminder insert confirm listener


        //对齐方式
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setPreferredSize(new Dimension((int) (scaling * parentFrame.getWidth()), parentFrame.getHeight()));

        //titlePanel
        {
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            titlePanel.setPreferredSize(new Dimension((int) (scaling * parentFrame.getWidth()), (int) (0.12 * parentFrame.getHeight())));
//            titlePanel.setBackground(Color.black);
            mainPanel.add(titlePanel);
            //titlePanel_title
            JPanel titlePanel_title = new JPanel();
            titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
            titlePanel_title.setPreferredSize(new Dimension((int) (scaling * 0.48 * parentFrame.getWidth()), (int) (0.11 * parentFrame.getHeight())));
            titlePanel_title.setBackground(Color.blue);
            titlePanel.add(titlePanel_title);

            titleLabel = new JLabel("All");
            titleLabel.setFont(font1);
            titlePanel_title.add(titleLabel);

            //titlePanel_button
            JPanel titlePanel_button = new JPanel();
            titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
            titlePanel_button.setPreferredSize(new Dimension((int) (scaling * 0.48 * parentFrame.getWidth()), (int) (0.11 * parentFrame.getHeight())));
            titlePanel_button.setBackground(Color.yellow);
            titlePanel.add(titlePanel_button);

            addButton = new JButton("+");
            addButton.setFont(font2);
            addButton.setBackground(Color.white);
            addButton.setPreferredSize(new Dimension((int) (0.05 * parentFrame.getWidth()), (int) (0.05 * parentFrame.getWidth())));
            addButton.setVisible(true);
            titlePanel_button.add(addButton);


            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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
                    {
                        confirmPanel = new JPanel(new BorderLayout());
                        confirmPanel.setBounds(50, 100, 200, 200);
                        confirmButton.setSize(100, 100);
                    }
                    //while input Enter will be same as click confirm button


                    confirmPanel.add(confirmButton, BorderLayout.SOUTH);
                    //two frames will not close together
                    printFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                    //对窗口的打开和关闭操作添加触发事件
                    printFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowOpened(WindowEvent e) {
                            addButton.setEnabled(false);
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            addButton.setEnabled(true);

                        }
                    });
                    printFrame.add(inputPanel);
                    printFrame.add(confirmPanel);

                    //The influence of click button
                    confirmButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String item = itemName.getText();
                            if (item.length() > 0 && item.length() <= 50) {

                                addItem(ReminderModel.insertReminder(item));
//                                pulsButton.setEnabled(true);
                                printFrame.dispose();
                            } else if (item.length() >= 50) {
//                                JOptionPane.showMessageDialog(null, "输入字段过长（输入长度限制50字）", "警告", JOptionPane.WARNING_MESSAGE);
                                String newItem = item.substring(0, 49);
                                addItem(ReminderModel.insertReminder(newItem));
                            }

//                            addButton.setEnabled(true);
                        }
                    });

                    //release Enter
                    //TODO: recover this function by implement a new listener
//                    itemName.addKeyListener(new KeyAdapter() {
//                        @Override
//                        public void keyTyped(KeyEvent e) {
//                            super.keyTyped(e);
//                            if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//                                String item = itemName.getText();
//                                if (item != null) {
//                                    //TODO: use some less invasive way to do this
//                                    addItem(ReminderModel.insertReminder(item));
//                                }
//                                printFrame.dispose();
//                            }
//                            addButton.setEnabled(true);
//                        }
//
//                    });

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

    public void addItem(Reminder reminder) {
        reminderListWidget.addNewReminderViewIntoReminderListView(reminder);

        mainPanel.validate();
        mainPanel.repaint();

        mainPanel.setVisible(true);
    }

    public void addItem(List reminders) {
        reminderListWidget.addNewReminderViewsIntoReminderListView((java.util.List<Reminder>) reminders);

        mainPanel.validate();
        mainPanel.repaint();

        mainPanel.setVisible(true);
    }

    public void addReminderInsertConfirmListener(ActionListener reminderInsertConfirmListener) {
        assert confirmButton != null;
        confirmButton.addActionListener(reminderInsertConfirmListener);
    }
}
