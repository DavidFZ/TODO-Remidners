package edu.square.controller.view1.component;

import edu.square.controller.view.MComponentController;
import edu.square.entity.Reminder;
import edu.square.views.view1.component.DetailInformationComponentView;
import edu.square.views.widget.ReminderListWidgetView;

import static edu.square.model.ReminderModel.updateReminder;

public class DetailInformationComponentController extends MComponentController {
    private final DetailInformationComponentView detailInformationComponentView;

    public DetailInformationComponentController(DetailInformationComponentView detailInformationComponentView) {
        super();
        this.detailInformationComponentView = detailInformationComponentView;
    }

    @Override
    public void initController() {
        detailInformationComponentView.getBackButton().addActionListener(e -> {
            detailInformationComponentView.setVisibility(false);
        });
        detailInformationComponentView.getDeleteButton().addActionListener(e -> {
            detailInformationComponentView.setVisibility(false);
        });
    }
}
