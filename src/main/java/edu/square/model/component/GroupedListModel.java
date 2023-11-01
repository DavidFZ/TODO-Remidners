package edu.square.model.component;

import edu.square.views.component.GroupedListComponent;
import edu.square.views.widget.ReminderListWidget;

public class GroupedListModel extends MComponentModel {
    private final GroupedListComponent groupedListComponent;

    public GroupedListModel(GroupedListComponent groupedListComponent) {
        this.groupedListComponent = groupedListComponent;

    }

    public void clearSingleReminderView(ReminderListWidget.ReminderView reminderView) {
    }
}
