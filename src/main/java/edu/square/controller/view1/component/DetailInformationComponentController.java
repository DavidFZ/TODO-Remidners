package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.component.DetailInformationModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.DetailInformationComponentView;
import edu.square.views.view1.component.TimeSelectorComponentView;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DetailInformationComponentController extends MController {
    private final DetailInformationComponentView detailInformationComponentView;
    private final DetailInformationModel detailInformationModel;

    public DetailInformationComponentController(MComponent mComponent, MModel mModel) {
        super(mComponent, mModel);

        detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        detailInformationModel = (DetailInformationModel) mModel;
    }

    @Override
    public void initialize() {
        //controller layer
        bindButton();
    }

    private void bindButton() {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        DetailInformationModel detailInformationModel = (DetailInformationModel) mModel;

        //back button
        detailInformationComponentView.getBackButton().addActionListener(e -> {
            detailInformationComponentView.setVisibility(false);
        });

        //delete button
//        initialize in ListController
//        bindListenerOnDeleteButton();

        //reset button
//        same as delete button

        //update button
//        same as delete button
    }

    /**
     * Call this method when reminder entity out of this component is updated
     *
     * @param reminder updated reminder entity
     */
    public void reminderUpdate(Reminder reminder) {
        //model layer
        detailInformationModel.updateReminder(reminder);
        //view layer
        detailInformationComponentView.setContentTextField(detailInformationModel.getReminder().getContent());
        detailInformationComponentView.setNoteTextField(detailInformationModel.getReminder().getNote());
    }

    public void updateViewByModel() {
        reminderUpdate(detailInformationModel.getReminder());
    }

    public void setVisible(Reminder reminder) {
        //model layer
        detailInformationModel.updateReminder(reminder);

        //view layer
        detailInformationComponentView.updateReminderDetail(detailInformationModel.getReminder());
        detailInformationComponentView.setVisibility(true);
    }

    public void setVisibleByModel() {
        setVisible(detailInformationModel.getReminder());

        TimeSelectorComponentView timeSelectorComponentView = detailInformationComponentView.timeSelectorComponentView;
        timeSelectorComponentView.setSelectedItem(detailInformationModel.getReminder());
        Boolean isImportant = detailInformationModel.getReminder().getIsImportant();
        timeSelectorComponentView.getFlaggedRadio().setSelected(isImportant != null && isImportant);
    }


    private void bindListenerOnDeleteButton() {
        detailInformationComponentView.getDeleteButton().addActionListener(e -> {
            //model layer
            detailInformationModel.deleteReminder();
            //view layer
            detailInformationComponentView.setVisibility(false);
        });
    }

    private void bindListenerOnSaveButton() {
        detailInformationComponentView.getSaveButton().addActionListener(e -> {
            //model layer
            detailInformationModel.getReminder().setContent(detailInformationComponentView.getContentTextField());
            detailInformationModel.getReminder().setNote(detailInformationComponentView.getNoteTextField());
            Reminder reminder = detailInformationModel.getReminder();
            //sub component
            reminder.setRemindTime(detailInformationComponentView.timSelectorComponentController.getTimestamp());
            reminder.setIsImportant(detailInformationComponentView.timeSelectorComponentView.getFlaggedRadio().isSelected());
            detailInformationModel.updateReminder(reminder);
        });
    }

    private void bindListenerOnResetButton() {
        detailInformationComponentView.getResetButton().addActionListener(e -> {
            detailInformationComponentView.setContentTextField(detailInformationModel.getReminder().getContent());
            detailInformationComponentView.setNoteTextField(detailInformationModel.getReminder().getNote());
        });
    }

    public void addListenerOnDeleteButton(ActionListener actionListener) {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        detailInformationComponentView.getDeleteButton().addActionListener(actionListener);
        bindListenerOnDeleteButton();
    }

    public void addListenerOnSaveButton(ActionListener actionListener) {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        detailInformationComponentView.getSaveButton().addActionListener(actionListener);
        bindListenerOnSaveButton();
    }

    public void addListenerOnRestButton(ActionListener actionListener) {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        detailInformationComponentView.getResetButton().addActionListener(actionListener);
        bindListenerOnResetButton();
    }
}
