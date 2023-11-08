package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.entity.Reminder;
import edu.square.model.MModel;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.widget.ReminderModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.GroupedListComponentView;

import javax.swing.*;
import java.util.List;

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
    }

    public void updateList(List<Reminder> list) {
        //update model
        updateListByModel(list);
        //update view

    }

    public void updateListByModel(List<Reminder> list) {
        //update model
        ((GroupedListComponentModel) mModel).setList(list);
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


}
