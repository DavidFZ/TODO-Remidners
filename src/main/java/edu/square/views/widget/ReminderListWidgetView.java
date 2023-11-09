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
    private final Dimension defaultcontainerPanelDimension;
    private final Dimension reminderViewDimension;
    Font font;
    private JPanel containerPanel;
    private int reminderNum;
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

        //init dimensions
        assert containerPanel.getSize() != null;
        defaultcontainerPanelDimension = containerPanel.getSize();
        reminderViewDimension = resizeDimensionWidthAndHeight(defaultcontainerPanelDimension, 0.35, 0.06);

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

        containerPanel.add(reminderView.getInnerPanel());

        modifyContainerPanelSize();
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
        }
        modifyContainerPanelSize();
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

        containerPanel.setPreferredSize(new Dimension(defaultcontainerPanelDimension.width,(int) (0.06 * rootFrameDimension.getHeight()*reminderNum)));
        containerPanel.updateUI();
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

        containerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        containerPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.85));
        containerPanel.setBackground(Color.green);

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
        private final JRadioButton radioButton;
        @Getter
        @Setter
        private Reminder reminder;
        @Getter
        private JPanel innerPanel;

        protected ReminderView(Reminder r) {
            reminder = r;

            innerPanel = new JPanel();
            label = new JLabel(reminder.getContent());
            radioButton = new JRadioButton();

            label.setFont(font);

            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            innerPanel.setPreferredSize(new Dimension((int) (0.35 * rootFrameDimension.getWidth()), (int) (0.06 * rootFrameDimension.getHeight())));
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

        public boolean getReminderViewDoneStatus() {
            return radioButton.isSelected();
        }

        public void setReminderViewDoneStatus(boolean isDone) {
            radioButton.setSelected(isDone);
            if (isDone) {
                radioButton.setSelected(true);
                label.setForeground(Color.GRAY);
            } else {
                radioButton.setSelected(false);
                label.setForeground(Color.BLACK);
            }
        }

        public void addActionListenerOnDoneStatusButton(ActionListener actionListener) {
            radioButton.addActionListener(actionListener);
        }
    }
}
