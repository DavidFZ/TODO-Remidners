package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.model.component.MModel;
import edu.square.model.view1.component.LeftSideComponentModel;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.LeftSideComponentView;

import java.awt.event.MouseListener;
import java.util.List;

public class LeftSideComponentController extends MController {

    public LeftSideComponentController(MComponent mComponentView, MModel mModel) {
        super(mComponentView, mModel);
    }


    @Override
    public void initialize() {
        initializeGroupLabel();
    }

    private void initializeGroupLabel() {
        LeftSideComponentView leftSideComponentView = (LeftSideComponentView) mComponentView;

        List<LeftSideComponentModel.GroupModel> list = ((LeftSideComponentModel) mModel).getGroupModels();
        for (int i = 0; i < list.size(); i++) {
            LeftSideComponentModel.GroupModel groupModel = list.get(i);
            //set group name
            leftSideComponentView.addGroupLabel(groupModel.getGroupName(), groupModel.getReminderModels().size());
            //set group counter
            leftSideComponentView.setGroupLabelCount(i, groupModel.getReminderModels().size());
        }
    }

    public void updateGroupCounterByModel() {
        LeftSideComponentView leftSideComponentView = (LeftSideComponentView) mComponentView;

        List<LeftSideComponentModel.GroupModel> list = ((LeftSideComponentModel) mModel).getGroupModels();
        for (int i = 0; i < list.size(); i++) {
            LeftSideComponentModel.GroupModel groupModel = list.get(i);
            //set group counter
            leftSideComponentView.setGroupLabelCount(i, groupModel.getReminderModels().size());
        }
    }

    public void setMouseListenerOnGroupLabel(int index, MouseListener groupLabelMouseListener) {
        ((LeftSideComponentView) mComponentView).addGroupLabelMouseListener(index, groupLabelMouseListener);
    }
}
