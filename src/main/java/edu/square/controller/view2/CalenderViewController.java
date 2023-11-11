package edu.square.controller.view2;

import edu.square.controller.view1.component.GroupedListComponentController;
import edu.square.entity.Reminder;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.views.view.CalenderView;

import java.util.List;

public class CalenderViewController {
    private final CalenderView calenderView;
    private final GroupedListComponentController groupedListComponentController;

    public CalenderViewController(CalenderView calenderView) {
        this.calenderView = calenderView;

        groupedListComponentController = new GroupedListComponentController(calenderView.getGroupedListComponentView(), new GroupedListComponentModel());
    }

    private void initialize() {

        groupedListComponentController.setGroupedTitle("Grouped Title");


//        List<Reminder> thisMonthReminderList = groupedListComponentController.getReminderList();
//        groupedListComponentController.updateListModelAndView();
    }
}
