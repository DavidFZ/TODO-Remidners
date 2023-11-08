package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.entity.Reminder;
import edu.square.model.MModel;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.views.component.MComponent;

import java.util.List;

public class GroupedListComponentController extends MController {
    public GroupedListComponentController(MComponent mComponentView, MModel mModel) {
        super(mComponentView, mModel);
    }

    @Override
    public void initialize() {

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
}
