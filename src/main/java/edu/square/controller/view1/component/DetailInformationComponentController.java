package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.component.DetailInformationModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.DetailInformationComponentView;

public class DetailInformationComponentController extends MController {

    public DetailInformationComponentController(MComponent mComponent, MModel mModel) {
        super(mComponent, mModel);
    }

    @Override
    public void initialize() {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;
        DetailInformationModel detailInformationModel = (DetailInformationModel) mModel;

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
        detailInformationComponentView.getDeleteButton().addActionListener(e -> {
            //model layer
            detailInformationModel.deleteReminder();
            //view layer
            detailInformationComponentView.setVisibility(false);
        });

        //reset button
        detailInformationComponentView.getResetButton().addActionListener(e -> {
            detailInformationComponentView.setContentTextField(detailInformationModel.getReminder().getContent());
            detailInformationComponentView.setNoteTextField(detailInformationModel.getReminder().getNote());
        });

        //update button
        detailInformationComponentView.getDoneButton().addActionListener(e -> {
            //model layer
            detailInformationModel.getReminder().setContent(detailInformationComponentView.getContentTextField());
            detailInformationModel.getReminder().setNote(detailInformationComponentView.getNoteTextField());
            detailInformationModel.updateReminder(detailInformationModel.getReminder());
        });

    }

    /**
     * Call this method when reminder entity out of this component is updated
     *
     * @param reminder updated reminder entity
     */
    public void reminderUpdate(Reminder reminder) {
        DetailInformationModel detailInformationModel = (DetailInformationModel) mModel;
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;

        //model layer
        detailInformationModel.updateReminder(reminder);
        //view layer
        detailInformationComponentView.setContentTextField(detailInformationModel.getReminder().getContent());
        detailInformationComponentView.setNoteTextField(detailInformationModel.getReminder().getNote());
    }

    public void updateViewByModel() {
        DetailInformationModel detailInformationModel = (DetailInformationModel) mModel;
        reminderUpdate(detailInformationModel.getReminder());
    }

}
