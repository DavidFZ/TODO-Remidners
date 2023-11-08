package edu.square.views.view1.component;

import edu.square.entity.Reminder;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.widget.GroupedTitleWidgetView;
import edu.square.views.widget.ReminderListWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class GroupedListComponentView extends MComponent {
    Font font1;
    Font font2;
    Font font3;
    @Getter
    JButton addButton;
    private GroupedTitleWidgetView groupedTitleWidgetView;
    private ReminderListWidgetView reminderListWidgetView;
    @Getter
    private JFrame subFrame;
    @Getter
    private JButton confirmButton;


    public GroupedListComponentView(Dimension rootFrameDimension, MyView myView) {
        super(myView, rootFrameDimension);
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                GroupedListComponentView groupedListComponentView = new GroupedListComponentView(jFrame.getSize(), myView);
            }
        };
    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, 0.4);
    }

    @Override
    protected void initializeMainPanel() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        mainPanel = getFlowJpanel(flowLayout, selfDimension);
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(parentDimension, 0.05);
        font2 = FontUtil.getBoldFont(parentDimension, 0.03);
        font3 = FontUtil.getBoldFont(parentDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        //GROUP TITLE
        groupedTitleWidgetView = new GroupedTitleWidgetView(parentDimension, resizeDimensionHeightScale(selfDimension, 0.1));
        mainPanel.add(groupedTitleWidgetView.getMainPanel());
        //reference sub components
        addButton = groupedTitleWidgetView.getAddButton();

        //GROUP LABEL
        reminderListWidgetView = new ReminderListWidgetView(parentDimension, parentDimension);
        mainPanel.add(reminderListWidgetView.getScrollPane());
    }

    @Override
    protected void initializeView() {

    }

    public void setGroupedTitle(String title) {
        groupedTitleWidgetView.setTitleLabel(title);
    }

    public void clearReminderList() {
        reminderListWidgetView.clearReminderListView();
    }

    public void addReminderIntoList(Reminder reminder) {
        reminderListWidgetView.addNewReminderViewIntoReminderListView(reminder);
    }

    public void addRemindersIntoList(List reminders) {
        assert reminders != null;
        reminderListWidgetView.addNewReminderViewsIntoReminderListView((java.util.List<Reminder>) reminders);
    }

    public void removeReminderFromList(Reminder reminder) {
        reminderListWidgetView.removeReminderViewFromReminderListView(reminder);
    }

    public void setAddButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public static class SubFrame extends JFrame {
        public SubFrame() {
            super();
            this.setSize(300, 200);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setVisible(true);
        }
    }
}
