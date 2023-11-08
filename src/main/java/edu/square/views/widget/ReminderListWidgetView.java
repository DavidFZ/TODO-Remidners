package edu.square.views.widget;

import edu.square.entity.Reminder;
import edu.square.model.view1.widget.ReminderModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MWidgetTestHelper;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.square.utils.UIUtils.ComponentResizeUtil.*;

public class ReminderListWidgetView extends MWidget {
    private final Map<Reminder, ReminderView> reminderViewMap;
    Font font;
    private JPanel containerPanel;
    private int reminderNum;
    private Dimension containerPanelDimension;
    private Dimension reminderViewDimension;
    //keep parentFrame var for future implementation resolution scaling
    @Getter
    private List<ReminderView> reminderViews;
    private List<Reminder> reminders;
    @Getter
    private JScrollPane scrollPane;
    @Setter
    private ActionListener completeActionListener;

    public ReminderListWidgetView(Dimension rootFrameDimension, Dimension selfDimension) {
        //main将被加入到scrollPane中
        super(rootFrameDimension, selfDimension);
        //init data structures
        reminderViewMap = new HashMap<>();
        reminders = new ArrayList<>();
        reminderNum = 0;
        reminderViews = new ArrayList<>();


    }

    public static void main(String[] args) {
        MWidgetTestHelper mWidgetTestHelper = new MWidgetTestHelper() {
            @Override
            public void initializeMWidget() {
                ReminderListWidgetView reminderListWidgetView = new ReminderListWidgetView(jFrame.getSize(), jFrame.getSize());
                jFrame.add(reminderListWidgetView.getScrollPane());

                //test add
                reminderListWidgetView.reminders = ReminderModel.queryAllEntities();
                reminderListWidgetView.reminderNum = reminderListWidgetView.reminders.size();
                reminderListWidgetView.reminderViews = new ArrayList<>();

                for (Reminder r : reminderListWidgetView.reminders) {
                    ReminderView reminderView = reminderListWidgetView.createNewReminderView(r);
                    reminderListWidgetView.reminderViews.add(reminderView);
                }

                reminderListWidgetView.addNewReminderViewsIntoReminderListView(reminderListWidgetView.reminders);

            }
        };
    }

    public void addNewReminderViewIntoReminderListView(Reminder reminder) {
        reminderNum++;
        reminders.add(reminder);
        ReminderView reminderView = new ReminderView(reminder);
        reminderViews.add(reminderView);
        reminderViewMap.put(reminder, reminderView);

        //TODO 无法显示？
        containerPanel.add(reminderView.getInnerPanel());
        // add complete button listener
        if (completeActionListener != null)
            reminderView.getRadioButton().addActionListener(completeActionListener);

        modifyContainerPanelSize();
        containerPanel.validate();
        containerPanel.repaint();
        scrollPane.validate();
        scrollPane.repaint();
        mainPanel.validate();
        mainPanel.repaint();


        //TODO:实现自动滚动到底部
    }

    public void addNewReminderViewsIntoReminderListView(List<Reminder> reminders) {
        reminderNum += reminders.size();
        this.reminders.addAll(reminders);
        for (Reminder reminder : reminders) {
            ReminderView reminderView = new ReminderView(reminder);
            reminderViews.add(reminderView);
            reminderViewMap.put(reminder, reminderView);

            containerPanel.add(reminderView.getInnerPanel());
            // add complete button listener
            if (completeActionListener != null) {
                reminderView.getRadioButton().addActionListener(completeActionListener);
            }
        }

//        modifyContainerPanelSize();
        containerPanel.repaint();
        mainPanel.repaint();
    }

    public void removeReminderViewFromReminderListView(Reminder reminder) {
        reminderNum--;
        ReminderView reminderView = reminderViewMap.get(reminder);

        reminderViewMap.remove(reminder);
        reminders.remove(reminder);
        reminderViews.remove(reminderView);

        //实现自动缩小scrollPane
        modifyContainerPanelSize();
        containerPanel.repaint();


        repaint();
    }

    public void clearReminderListViewWithoutRepaint() {
        containerPanel.removeAll();
        containerPanel.setPreferredSize(selfDimension);
        reminderNum = 0;
        reminders.clear();
        reminderViews.clear();
        reminderViewMap.clear();

        //TODO:实现自动缩小scrollPane
        modifyContainerPanelSize();
        containerPanel.repaint();

    }

    public void modifyContainerPanelSize() {
        if (reminderNum > 13)
            containerPanel.setPreferredSize(addDimensionHeight(containerPanelDimension, (int) (reminderViewDimension.getHeight() * (reminderNum - 3))));
        else
            containerPanel.setPreferredSize(containerPanelDimension);
    }

    public void clearReminderListView() {
        clearReminderListViewWithoutRepaint();
        containerPanel.repaint();
    }

    public void repaint() {
        containerPanel.repaint();
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        containerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        containerPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.9));
        containerPanel.setBackground(Color.green);

        containerPanelDimension = containerPanel.getPreferredSize();
        reminderViewDimension = resizeDimensionWidthAndHeight(rootFrameDimension, 0.35, 0.06);

        scrollPane = new JScrollPane(containerPanel);
        scrollPane.setPreferredSize(resizeDimensionHeightScale(selfDimension, 0.9));//防止scrollPane过长
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setBackground(Color.blue);

        mainPanel.add(scrollPane);

    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(rootFrameDimension, 0.03);
    }

    @Override
    protected void initializeJComponents() {
    }

    private ReminderView createNewReminderView(Reminder reminder) {
        return new ReminderView(reminder);
    }


    public class ReminderView {
        private final JLabel label;
        @Getter
        @Setter
        private Reminder reminder;
        @Getter
        private JRadioButton radioButton;
        @Getter
        private JPanel innerPanel;

        protected ReminderView(Reminder r) {
            reminder = r;

            innerPanel = new JPanel();
            label = new JLabel(reminder.getContent());
            radioButton = new JRadioButton();

            label.setFont(font);

            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            innerPanel.setPreferredSize(rootFrameDimension);
            innerPanel.setBackground(Color.yellow);
            innerPanel.setBorder(new LineBorder(Color.PINK));

            setReminderViewDoneStatus(reminder.getDoneTime() != null);

            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setReminderViewDoneStatus(radioButton.isSelected());    //update view
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
