package edu.square.model.view1;

import edu.square.model.component.MModel;
import edu.square.model.view1.component.DetailInformationModel;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.component.LeftSideComponentModel;

public class ListModel extends MModel {
    public final LeftSideComponentModel leftSideComponentModel;
    public final GroupedListComponentModel groupedListComponentModel;
    public final DetailInformationModel detailInformationModel;

    public ListModel() {
        leftSideComponentModel = new LeftSideComponentModel();
        groupedListComponentModel = new GroupedListComponentModel();
        detailInformationModel = new DetailInformationModel();
    }

    @Override
    public void updateModelGlobally() {
        //order matters
        leftSideComponentModel.updateModelGlobally();

        int groupIndex = groupedListComponentModel.getGroupIndex();
        LeftSideComponentModel.GroupModel groupModel = leftSideComponentModel.getGroupModels().get(groupIndex);
        groupedListComponentModel.setList(groupModel.getReminderModels());

        detailInformationModel.updateModelGlobally();
    }
}
