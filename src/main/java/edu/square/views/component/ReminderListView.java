package edu.square.views.component;

import edu.square.controller.FrameTodayController;
import edu.square.entity.Reminder;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.controller.FrameTodayController.updateReminderEntityDoneStatus;

public class ReminderListView {
    private final JFrame parentFrame;
    private final List<ReminderView> reminderViews;
    private final List<Reminder> reminders;
    @Getter
    JPanel jPanelManager;
    @Getter
    private JScrollPane scrollPane;

    public ReminderListView(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        reminders = FrameTodayController.queryAllEntities();
        reminderViews = new ArrayList<>();

        jPanelManager = new JPanel();
        jPanelManager.setPreferredSize(new Dimension((int) (parentFrame.getWidth() * 0.93), (int) (parentFrame.getHeight() * 0.08)));//innerpanel宽度为0.07
        jPanelManager.setBackground(Color.red);
        jPanelManager.setLayout(new FlowLayout(FlowLayout.CENTER));

        int w = (int) (parentFrame.getWidth() * 0.95);
        int h = (int) (parentFrame.getHeight() * 0.75);
        scrollPane = new JScrollPane(jPanelManager);
        scrollPane.setPreferredSize(new Dimension(w, h));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        for (Reminder r : reminders) {
            ReminderView reminderView = new ReminderView(r);
            reminderViews.add(reminderView);
            jPanelManager.add(reminderView.getInnerPanel());
        }
    }

    public void addNewReminderViewIntoReminderListView(Reminder reminder) {
        ReminderView reminderView = new ReminderView(reminder);
        jPanelManager.add(reminderView.getInnerPanel());
    }

    public class ReminderView {
        @Getter
        private Reminder reminder;
        private JLabel label;
        @Getter
        private JRadioButton radioButton;
        @Getter
        private JPanel innerPanel;

        protected ReminderView(Reminder r) {
            reminder = r;
            innerPanel = new JPanel();
            label = new JLabel(reminder.getContent());
            radioButton = new JRadioButton();
            //bind view
            initView();
        }

        private void initView() {
            //innerPanel View
            innerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            innerPanel.setPreferredSize(new Dimension((int) (0.85 * parentFrame.getWidth()), (int) (0.07 * parentFrame.getHeight())));
            innerPanel.setBorder(new LineBorder(Color.PINK));
            innerPanel.setBackground(Color.yellow);

            //label.setFont(font2);

            //reload done status from db
            setReminderViewDoneStatus(reminder.getDoneTime() != null);

            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setReminderViewDoneStatus(radioButton.isSelected());
                    updateReminderEntityDoneStatus(reminder, radioButton.isSelected());
                }
            });

            innerPanel.add(radioButton);
            innerPanel.add(label);
            innerPanel.setVisible(true);

        }

        private void setReminderViewDoneStatus(boolean isDone) {
            radioButton.setSelected(isDone);
            if (isDone) {
                radioButton.setSelected(true);
                label.setForeground(Color.GRAY);
            } else {
                radioButton.setSelected(false);
                label.setForeground(Color.BLACK);
            }
        }
    }


}
