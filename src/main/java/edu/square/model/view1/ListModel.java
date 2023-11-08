package edu.square.model.view1;

import edu.square.model.view1.component.DetailInformationModel;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.component.LeftSideComponentModel;

public class ListModel {
    public final LeftSideComponentModel leftSideComponentModel;
    public final GroupedListComponentModel groupedListComponentModel;
    public final DetailInformationModel detailInformationModel;

    public ListModel() {
        leftSideComponentModel = new LeftSideComponentModel();
        groupedListComponentModel = new GroupedListComponentModel();
        detailInformationModel = new DetailInformationModel();
    }
}
