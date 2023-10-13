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
    private JScrollPane scrollPane;
    @Getter
    private JPanel innerPanel;


    public ReminderListView(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        reminders = FrameTodayController.queryAllEntities();
        reminderViews = new ArrayList<>();
        scrollPane = new JScrollPane();
        innerPanel = new JPanel();
        for (Reminder r : reminders) {
            ReminderView reminderView = new ReminderView(r);
            reminderViews.add(reminderView);
            innerPanel.add(reminderView.getInnerPanel());
            scrollPane.add(reminderView.getInnerPanel());
        }
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
            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
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
