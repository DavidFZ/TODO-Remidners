package edu.square.views.widget;

import edu.square.entity.Reminder;
import edu.square.model.ReminderModel;
import edu.square.utils.UIUtils.FontUtil;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class ReminderListWidgetView extends MWidget {
    //keep parentFrame var for future implementation resolution scaling
    private final Dimension parentDimension;
    @Getter
    private final List<ReminderView> reminderViews;
    private final List<Reminder> reminders;
    //以第一次载入的窗口为准
    private final double frameWidthInit;
    private final double frameHeightInit;
    private final double scaling = 0.4;
    int reminderNum;
    @Getter
    private JScrollPane scrollPane;
    @Setter
    private ActionListener completeActionListener;
    Font font;

    public ReminderListWidgetView(Dimension parentDimension, Dimension selfDimension) {
        super(parentDimension, selfDimension);

        this.parentDimension = parentDimension;
        //TODO:给我去掉这个牛皮藓
        this.selfDimension = new Dimension(resizeDimensionWidthAndHeight(selfDimension, 0.93, 0.06));

        frameHeightInit = parentDimension.getHeight();
        frameWidthInit = scaling * parentDimension.getWidth();

        reminders = ReminderModel.queryAllEntities();
        reminderNum = reminders.size();
        reminderViews = new ArrayList<>();


        int w = (int) (frameWidthInit);
        int h = (int) (0.8 * parentDimension.getHeight());
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setPreferredSize(new Dimension(w, h));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);

        //循环遍历添加数据库内容
        for (Reminder r : reminders) {
            ReminderView reminderView = new ReminderView(r);
            reminderViews.add(reminderView);
            mainPanel.add(reminderView.getInnerPanel());
        }
    }

    public void addNewReminderViewIntoReminderListView(Reminder reminder) {
        reminderNum++;
        reminders.add(reminder);
        ReminderView reminderView = new ReminderView(reminder);
        reminderViews.add(reminderView);

        mainPanel.add(reminderView.getInnerPanel());
        // add complete button listener
        if (completeActionListener != null)
            reminderView.getRadioButton().addActionListener(completeActionListener);
        if (reminderNum > 13) {
            mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(), (int) (mainPanel.getHeight() + frameHeightInit * 0.06)));
        }

        //TODO:实现自动滚动到底部
    }

    public void addNewReminderViewsIntoReminderListView(List<Reminder> reminders) {
        reminderNum += reminders.size();

        for (Reminder reminder : reminders) {
            ReminderView reminderView = new ReminderView(reminder);
            mainPanel.add(reminderView.getInnerPanel());
            // add complete button listener
            if (completeActionListener != null)
                reminderView.getRadioButton().addActionListener(completeActionListener);
        }
//        if (reminderNum > 13) {
//            jPanelManager.setPreferredSize(new Dimension(jPanelManager.getWidth(), (int) (jPanelManager.getHeight() + frameHeightInit * 0.06) * reminders.size()));
//        }
        repaint();
    }

    public void clearReminderListViewWithoutRepaint() {
        mainPanel.removeAll();
        mainPanel.setPreferredSize(selfDimension);
        reminderNum = 0;
        reminders.clear();
        reminderViews.clear();
    }

    public void clearReminderListView() {
        clearReminderListViewWithoutRepaint();
        mainPanel.repaint();
    }

    public void repaint() {
        mainPanel.repaint();
    }

    @Override
    protected void setMainPanelFlowLayout(FlowLayout flowLayout) {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(new Dimension((int) (frameWidthInit * 0.95), (int) ((frameHeightInit * 0.06) * reminderNum)));
        mainPanel.setBackground(Color.red);
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(parentDimension, 0.03);
    }

    @Override
    protected void initializeJComponents() {

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
            //TODO: abstract an interface for font resize from parentFrame
            label.setFont(font);
            radioButton = new JRadioButton();
            //bind view
            initView();
        }

        private void initView() {
            //innerPanel View
            innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            innerPanel.setPreferredSize(new Dimension((int) (0.85 * frameWidthInit), (int) (0.06 * frameHeightInit)));//13个
            innerPanel.setBorder(new LineBorder(Color.PINK));
            innerPanel.setBackground(Color.yellow);


            //reload done status from db
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
