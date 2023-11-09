package edu.square.views.view1.component;

import edu.square.entity.Reminder;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.subframe.AddReminderConfirmFrame;
import edu.square.views.view1.widget.GroupedTitleWidgetView;
import edu.square.views.widget.ReminderListWidgetView;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class GroupedListComponentView extends MComponent {
    Font font1;
    Font font2;
    Font font3;
    private GroupedTitleWidgetView groupedTitleWidgetView;
    private ReminderListWidgetView reminderListWidgetView;
    private final AddReminderConfirmFrame addReminderConfirmFrame;


    public GroupedListComponentView(Dimension rootFrameDimension, MyView myView) {
        super(myView, rootFrameDimension);
        //init sub frame
        addReminderConfirmFrame = new AddReminderConfirmFrame(resizeDimensionWidthAndHeight(selfDimension, 0.6, 0.4));
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
        font2 = FontUtil.getBoldFont(parentDimension, FontUtil.FONT_SIZE_1);    //0.03
        font3 = FontUtil.getBoldFont(parentDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        //GROUP TITLE
        groupedTitleWidgetView = new GroupedTitleWidgetView(parentDimension, resizeDimensionHeightScale(selfDimension, 0.1));
        mainPanel.add(groupedTitleWidgetView.getMainPanel());

        //GROUP LABEL
        reminderListWidgetView = new ReminderListWidgetView(parentDimension, resizeDimensionHeightScale(selfDimension, 0.9));
        mainPanel.add(reminderListWidgetView.getScrollPane());
    }

    @Override
    protected void initializeView() {

    }

    public void setGroupedTitle(String title) {
        groupedTitleWidgetView.setTitleLabel(title);
    }

    public void cleanSubFrameTextFiled() {
        addReminderConfirmFrame.cleanTextField();
    }

    public void clearReminderList() {
        reminderListWidgetView.clearReminderListView();
    }

    public void addReminderIntoList(Reminder reminder) {
        reminderListWidgetView.addNewReminderViewIntoReminderListView(reminder);
    }

    public void addRemindersIntoList(java.util.List<Reminder> reminders) {
        assert reminders != null;
        reminderListWidgetView.addNewReminderViewsIntoReminderListView(reminders);
    }

    public void removeReminderFromList(Reminder reminder) {
        reminderListWidgetView.removeReminderViewFromReminderListView(reminder);
    }

    public void setAddButtonListener(ActionListener actionListener) {
        groupedTitleWidgetView.setAddButtonListener(actionListener);
    }

    public void setSubFrameVisibility(boolean visibility) {
        addReminderConfirmFrame.setVisibility(visibility);
    }

    public void setConfirmButtonListener(ActionListener actionListener) {
        addReminderConfirmFrame.setConfirmButtonListener(actionListener);
    }

    public String getReminderContent() {
        return addReminderConfirmFrame.getItemName();
    }

    public void setAddButtonEnable(boolean enable) {
        groupedTitleWidgetView.setAddButtonEnable(enable);
    }

    public List<ReminderListWidgetView.ReminderView> getReminderViews() {
        return reminderListWidgetView.getReminderViews();
    }
}
