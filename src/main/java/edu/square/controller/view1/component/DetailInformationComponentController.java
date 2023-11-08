package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.model.MModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.DetailInformationComponentView;

public class DetailInformationComponentController extends MController {

    public DetailInformationComponentController(MComponent mComponent, MModel model) {
        super(mComponent, model);
    }

    @Override
    public void initialize() {
        DetailInformationComponentView detailInformationComponentView = (DetailInformationComponentView) mComponentView;

        detailInformationComponentView.getBackButton().addActionListener(e -> {
            detailInformationComponentView.setVisibility(false);
        });
        detailInformationComponentView.getDeleteButton().addActionListener(e -> {
            detailInformationComponentView.setVisibility(false);
        });
    }
}
