package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.widget.ReminderModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.GroupedListComponentView;
import edu.square.views.widget.ReminderListWidgetView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static edu.square.model.view1.widget.ReminderModel.updateReminderDoneStatus;

public class GroupedListComponentController extends MController {
    public GroupedListComponentController(MComponent mComponentView, MModel mModel) {
        super(mComponentView, mModel);
    }

    @Override
    public void initialize() {
        //Model Layer
        //default show all list
        ((GroupedListComponentModel) mModel).setList(ReminderModel.queryAllEntities(false));
        List<Reminder> list = ((GroupedListComponentModel) mModel).getList();

        //View Layer
        ((GroupedListComponentView) mComponentView).addRemindersIntoList(list);

        //Controller Layer
        bindListenerOnAddButton((GroupedListComponentView) mComponentView);
        bindListenerOnConfirmButton((GroupedListComponentView) mComponentView);
        bindListenerOnDoneStatusButton((GroupedListComponentView) mComponentView);
    }

    public void updateListModelAndView(List<Reminder> list) {
        //update model
        updateModel(list);
        //update view
        updateListView(list);
    }

    private void updateListView(List<Reminder> list) {
        ((GroupedListComponentView) mComponentView).clearReminderList();
        ((GroupedListComponentView) mComponentView).addRemindersIntoList(list);
        bindListenerOnAddButton((GroupedListComponentView) mComponentView);
    }

    public void updateListViewByModel() {
        updateListView(((GroupedListComponentModel) mModel).getList());
    }

    public void updateModel(List<Reminder> list) {
        //update model
        ((GroupedListComponentModel) mModel).setList(list);
    }

    private void bindListenerOnDoneStatusButton(GroupedListComponentView groupedListComponentView) {
        List<ReminderListWidgetView.ReminderView> list = groupedListComponentView.getReminderViews();
        for (ReminderListWidgetView.ReminderView reminderView : list) {
            reminderView.addActionListenerOnDoneStatusButton(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //update model
                    Reminder reminder = reminderView.getReminder();
                    boolean doneStatus = reminderView.getReminderViewDoneStatus();
                    updateReminderDoneStatus(reminder, doneStatus);
                }
            });
        }
    }

    private void bindListenerOnAddButton(GroupedListComponentView groupedListComponentView) {
        groupedListComponentView.setAddButtonListener(e -> {
            groupedListComponentView.setSubFrameVisibility(true);
//            groupedListComponentView.setAddButtonEnable(false);
        });
    }

    private void bindListenerOnConfirmButton(GroupedListComponentView groupedListComponentView) {
        groupedListComponentView.setConfirmButtonListener(e -> {
            /* Model Layer */

            //get data from sub frame
            String content = groupedListComponentView.getReminderContent();
            if (content == null || content.equals("")) {
                JOptionPane.showMessageDialog(null, "Please input content");
                return;
            }
            Reminder reminder = new Reminder(content);
            //update model
            ((GroupedListComponentModel) mModel).addReminder(reminder);

            /* View Layer */
            //clean text field
            groupedListComponentView.cleanSubFrameTextFiled();
            //close sub frame
            groupedListComponentView.setSubFrameVisibility(false);
            //update list
            groupedListComponentView.addReminderIntoList(reminder);
            //enable add button
            groupedListComponentView.setAddButtonEnable(true);
        });
    }

    public void setGroupedTitle(String title) {
        ((GroupedListComponentView) mComponentView).setGroupedTitle(title);
    }

    /**
     * Batch add mouse outside(Component) listener on Done Status Button
     *
     * @param actionListener listener
     */
    public void addListenerOnDoneStatusButtons(ActionListener actionListener) {
        //component outer listener
        GroupedListComponentView groupedListComponentView = (GroupedListComponentView) mComponentView;
        List<ReminderListWidgetView.ReminderView> list = groupedListComponentView.getReminderViews();
        for (ReminderListWidgetView.ReminderView reminderView : list) {
            //add external listener
            reminderView.addActionListenerOnDoneStatusButton(actionListener);
        }
        //component inner listener
        bindListenerOnDoneStatusButton((GroupedListComponentView) mComponentView);
    }
}
