package edu.square.controller;

import edu.square.entity.Reminder;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.GroupedListComponent;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.widget.ReminderListWidget;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static edu.square.model.ReminderModel.*;

public class View1Controller {
    public static String[] groupTitles = {"All", "Today", "Completed", "Flagged"};
    private LeftSideComponent leftSideComponent;
    private GroupedListComponent groupedListComponent;


    public View1Controller(LeftSideComponent leftSideComponent, GroupedListComponent groupedListComponent) {
        this.leftSideComponent = leftSideComponent;
        this.groupedListComponent = groupedListComponent;

        List groupLabelWidgets = (List) leftSideComponent.getGroupLabelWidgets();

        List<List<Reminder>> reminders = new ArrayList<>();
        reminders.add(queryAllEntities());
        reminders.add(queryReminderOfToday());
        reminders.add(queryReminderByDoneStatus(true));
        reminders.add(queryReminderByImportantStatus(true));

        for (int i = 0; i < reminders.size(); i++) {
            GroupLabelWidget widget = (GroupLabelWidget) groupLabelWidgets.get(i);
            List<Reminder> reminderList = reminders.get(i);
            int finalI = i;
            widget.getGroupView().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    groupedListComponent.getTitleLabel().setText(groupTitles[finalI]);

                    groupedListComponent.getReminderListWidget().clearReminderListView();
                    for (Reminder reminder : reminderList) {
                        groupedListComponent.addItem(reminder);
                    }
                }
            });
            widget.setGroupViewCount(reminders.get(i).size());
        }

    }

    public static String[] getGroupTitles() {
        //TODO: get group titles from database
        return groupTitles;
    }


}
