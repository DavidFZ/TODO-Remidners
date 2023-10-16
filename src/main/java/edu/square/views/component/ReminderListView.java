package edu.square.views.component;

import edu.square.entity.Reminder;
import edu.square.model.ReminderModel;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.model.ReminderModel.updateReminderEntityDoneStatus;
import static edu.square.utils.UIUtils.FontUtil.getBoldFont;

public class ReminderListView {
    //keep parentFrame var for future implementation resolution scaling
    private final JFrame parentFrame;
    private final List<ReminderView> reminderViews;
    private final List<Reminder> reminders;

    //get initial parent frame size
    private final double initialFrameLength;
    private final double initialFrameHeight;

    @Getter
    JPanel jPanelManager;
    @Getter
    private JScrollPane scrollPane;

    public ReminderListView(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        initialFrameHeight = parentFrame.getHeight();
        initialFrameLength = parentFrame.getWidth();

        reminders = ReminderModel.queryAllEntities();
        int reminderNum = reminders.size();
        reminderViews = new ArrayList<>();

        jPanelManager = new JPanel();
        jPanelManager.setPreferredSize(new Dimension((int) (parentFrame.getWidth() * 0.93), (int) ((initialFrameHeight * 0.076) * reminderNum)));
        jPanelManager.setBackground(Color.red);
        jPanelManager.setLayout(new FlowLayout(FlowLayout.CENTER));

        int w = (int) (parentFrame.getWidth() * 0.95);
        int h = (int) (parentFrame.getHeight() * 0.75);
        scrollPane = new JScrollPane(jPanelManager);
        scrollPane.setPreferredSize(new Dimension(w, h));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);

        for (Reminder r : reminders) {
            ReminderView reminderView = new ReminderView(r);
            reminderViews.add(reminderView);
            jPanelManager.add(reminderView.getInnerPanel());
        }
    }

    public void addNewReminderViewIntoReminderListView(Reminder reminder) {
        ReminderView reminderView = new ReminderView(reminder);
        jPanelManager.add(reminderView.getInnerPanel());
        jPanelManager.setPreferredSize(new Dimension(jPanelManager.getWidth(), (int) (jPanelManager.getHeight() + initialFrameHeight * 0.078)));
//        Todo 实现自动滚动到底部
//        JScrollBar jscrollBar = scrollPane.getVerticalScrollBar();
//        jscrollBar.setValue(jPanelManager.getHeight()*2);

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
            //TODO: abstract an interface for font resize from parentFrame
            label.setFont(getBoldFont((int) (0.03 * initialFrameLength)));

            radioButton = new JRadioButton();

            //innerPanel View
            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            innerPanel.setPreferredSize(new Dimension((int) (0.85 * initialFrameLength), (int) (0.07 * initialFrameHeight)));
            innerPanel.setBorder(new LineBorder(Color.PINK));
            innerPanel.setBackground(Color.yellow);


            //reload done status from db
            setReminderViewDoneStatus(reminder.getDoneTime() != null);

            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setReminderViewDoneStatus(radioButton.isSelected());    //update view
                    updateReminderEntityDoneStatus(reminder, radioButton.isSelected());     //update database
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
