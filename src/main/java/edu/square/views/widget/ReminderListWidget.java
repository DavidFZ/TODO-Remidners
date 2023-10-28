package edu.square.views.widget;

import edu.square.entity.Reminder;
import edu.square.model.ReminderModel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.model.ReminderModel.updateReminderEntityDoneStatus;

public class ReminderListWidget {
    //keep parentFrame var for future implementation resolution scaling
    private final JFrame parentFrame;
    @Getter
    private final List<ReminderView> reminderViews;
    private final List<Reminder> reminders;
    //以第一次载入的窗口为准
    private final double frameWidthInit;
    private final double frameHeightInit;
    private final double scaling = 0.4;
    @Getter
    JPanel jPanelManager;
    int reminderNum;
    @Getter
    private JScrollPane scrollPane;
    @Setter
    private ActionListener completeActionListener;

    public ReminderListWidget(JFrame parentFrame) {
        this.parentFrame = parentFrame;

        frameHeightInit = parentFrame.getHeight();
        frameWidthInit = scaling * parentFrame.getWidth();

        reminders = ReminderModel.queryAllEntities();
        reminderNum = reminders.size();
        reminderViews = new ArrayList<>();

        jPanelManager = new JPanel();
        jPanelManager.setPreferredSize(new Dimension((int) (frameWidthInit * 0.93), (int) ((frameHeightInit * 0.074) * reminderNum)));
        jPanelManager.setBackground(Color.red);
        jPanelManager.setLayout(new FlowLayout(FlowLayout.CENTER));

        int w = (int) (frameWidthInit);
        int h = (int) (0.8 * parentFrame.getHeight());
        scrollPane = new JScrollPane(jPanelManager);
        scrollPane.setPreferredSize(new Dimension(w, h));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);

        //TODO 实现自动滚动到底部


        for (Reminder r : reminders) {
            ReminderView reminderView = new ReminderView(r);
            reminderViews.add(reminderView);
            jPanelManager.add(reminderView.getInnerPanel());
        }
    }

    public void addNewReminderViewIntoReminderListView(Reminder reminder) {
        reminderNum++;
        ReminderView reminderView = new ReminderView(reminder);
        jPanelManager.add(reminderView.getInnerPanel());
        // add complete button listener
        if (completeActionListener != null)
            reminderView.getRadioButton().addActionListener(completeActionListener);
        if (reminderNum > 10) {
            jPanelManager.setPreferredSize(new Dimension(jPanelManager.getWidth(), (int) (jPanelManager.getHeight() + frameHeightInit * 0.072)));
        }

        //TODO:实现自动滚动到底部
    }

    public void addNewReminderViewsIntoReminderListView(List<Reminder> reminders) {
        reminderNum += reminders.size();

        for (Reminder reminder : reminders) {
            ReminderView reminderView = new ReminderView(reminder);
            jPanelManager.add(reminderView.getInnerPanel());
            // add complete button listener
            if (completeActionListener != null)
                reminderView.getRadioButton().addActionListener(completeActionListener);
        }
        if (reminderNum > 10) {
            jPanelManager.setPreferredSize(new Dimension(jPanelManager.getWidth(), (int) (jPanelManager.getHeight() + frameHeightInit * 0.072) * reminders.size()));
        }
        repaint();
    }

    public void clearReminderListViewWithoutRepaint() {
        jPanelManager.removeAll();
        jPanelManager.setPreferredSize(new Dimension((int) (frameWidthInit * 0.93), (int) ((frameHeightInit * 0.074) * reminderNum)));
        reminderNum = 0;
        reminders.clear();
        reminderViews.clear();
    }

    public void clearReminderListView() {
        clearReminderListViewWithoutRepaint();
        jPanelManager.repaint();
    }

    public void repaint() {
        jPanelManager.repaint();
    }

    public void addClickListeners(ActionListener actionListener) {
        assert actionListener != null;
        for (ReminderView reminderView : reminderViews) {
            reminderView.radioButton.addActionListener(actionListener);
        }
    }

    public class ReminderView {
        private final JLabel label;
        @Getter
        private Reminder reminder;
        @Getter
        private JRadioButton radioButton;
        @Getter
        private JPanel innerPanel;

        protected ReminderView(Reminder r) {
            reminder = r;
            innerPanel = new JPanel();
            label = new JLabel(reminder.getContent());
            //TODO: abstract an interface for font resize from parentFrame
            label.setFont(new Font("宋体", Font.BOLD, (int) (0.03 * parentFrame.getWidth())));
            radioButton = new JRadioButton();
            //bind view
            initView();
        }

        private void initView() {
            //innerPanel View
            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            innerPanel.setPreferredSize(new Dimension((int) (0.85 * frameWidthInit), (int) (0.0675 * frameHeightInit)));
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

        private void addClickListener(ActionListener actionListener) {
            radioButton.addActionListener(actionListener);
        }
    }


}
