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
    private final List<GroupLabelWidget> groupLabelWidgets;
    private LeftSideComponent leftSideComponent;
    private GroupedListComponent groupedListComponent;
    private List<List<Reminder>> reminders;
    private int currentGroupIndex = 0;


    public View1Controller(LeftSideComponent leftSideComponent, GroupedListComponent groupedListComponent) {
        this.leftSideComponent = leftSideComponent;
        this.groupedListComponent = groupedListComponent;

        //Add listeners to group labels, so that when clicked, the reminder list & title panel will be updated
        groupLabelWidgets = (List) leftSideComponent.getGroupLabelWidgets();
        reminders = getGroupedReminders();

        for (int i = 0; i < reminders.size(); i++) {
            GroupLabelWidget widget = (GroupLabelWidget) groupLabelWidgets.get(i);
            List<Reminder> reminderList = reminders.get(i);
            int finalI = i;
            widget.getGroupView().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    //update title panel
                    groupedListComponent.getTitleLabel().setText(groupTitles[finalI]);
                    //update reminder list
                    currentGroupIndex = finalI;
                    upDateReminderListViews(finalI);
                }
            });
            widget.setGroupViewCount(reminders.get(i).size());
        }


//        List<ReminderListWidget.ReminderView> list = groupedListComponent.getReminderListWidget().getReminderViews();
//        for (ReminderListWidget.ReminderView reminderView : list) {
//            //finish listener
//            reminderView.getRadioButton().addActionListener(e -> {
//                upDateView();
//            });
//            //delete listener
//            //TODO: still waiting for right component to be implemented
//        }
        //listener for add button
        groupedListComponent.getAddButton().addActionListener(e -> {
            //TODO:implement add button listener
        });
    }

    public static String[] getGroupTitles() {
        //TODO: get group titles from database
        return groupTitles;
    }

    //TODO: multi thread support
    private static List<List<Reminder>> getGroupedReminders() {
        List<List<Reminder>> reminders = new ArrayList<>();
        reminders.add(queryAllEntities());
        reminders.add(queryReminderOfToday());
        reminders.add(queryReminderByDoneStatus(true));
        reminders.add(queryReminderByImportantStatus(true));
        return reminders;
    }

    private void upDateView() {
        reminders = getGroupedReminders();
        for (int i = 0; i < reminders.size(); i++) {
            List<Reminder> reminderList = reminders.get(i);
            //update left side group view count label
            GroupLabelWidget groupLabelWidget = (GroupLabelWidget) leftSideComponent.getGroupLabelWidgets().get(i);
            groupLabelWidget.setGroupViewCount(reminderList.size());

        }
    }

    private void upDateReminderListViews(int index) {
        groupedListComponent.getReminderListWidget().clearReminderListView();
        for (Reminder reminder : reminders.get(index)) {
            groupedListComponent.addItem(reminder);
        }
    }


}
