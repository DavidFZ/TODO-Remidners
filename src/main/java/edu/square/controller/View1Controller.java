package edu.square.controller;

import edu.square.entity.Reminder;
import edu.square.utils.TimeUtils;
import edu.square.views.component.GroupedListComponent;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.widget.ReminderListWidget;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static edu.square.model.ReminderModel.*;

public class View1Controller {
    public static String[] groupTitles = {"All", "Today", "Completed", "Flagged"};
    private final List<GroupLabelWidget> groupLabelWidgets;
    private final LeftSideComponent leftSideComponent;
    private final GroupedListComponent groupedListComponent;
    private List<List<Reminder>> reminders;
    private int currentGroupIndex = 0;


    public View1Controller(LeftSideComponent leftSideComponent, GroupedListComponent groupedListComponent) {
        this.leftSideComponent = leftSideComponent;
        this.groupedListComponent = groupedListComponent;

        //Add listeners to group labels, so that when clicked, the reminder list & title panel will be updated
        groupLabelWidgets = leftSideComponent.getGroupLabelWidgets();
        reminders = getGroupedReminders();

        for (int i = 0; i < reminders.size(); i++) {
            GroupLabelWidget widget = groupLabelWidgets.get(i);
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
                    updateReminderListViews(finalI);
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


        //add listener for add frame confirm button
        groupedListComponent.addReminderInsertConfirmListener(e -> {
            updateCountLabel();
        });

        updateReminderDoneStatus();
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

    public ActionListener getCompletedStatusListener(ReminderListWidget.ReminderView reminderView) {
        return e -> {
            //TODO: fix this bull shit
            Reminder reminder =reminderView.getReminder();
            updateReminderEntityDoneStatus(reminder, reminderView.getRadioButton().isSelected());
            updateCountLabel();
        };
    }

    private void updateCountLabel() {
        reminders = getGroupedReminders();
        for (int i = 0; i < reminders.size(); i++) {
            List<Reminder> reminderList = reminders.get(i);
            //update left side group view count label
            GroupLabelWidget groupLabelWidget = leftSideComponent.getGroupLabelWidgets().get(i);
            groupLabelWidget.setGroupViewCount(reminderList.size());
            groupLabelWidget.repaint();
        }
    }


    private void updateReminderListViews(int index) {
        groupedListComponent.getReminderListWidget().clearReminderListView();
        for (Reminder reminder : reminders.get(index)) {
            groupedListComponent.addItem(reminder);
        }
        updateReminderDoneStatus();
    }

    private void updateReminderDoneStatus() {
        List<ReminderListWidget.ReminderView> reminderViews = groupedListComponent.getReminderListWidget().getReminderViews();
        for (ReminderListWidget.ReminderView reminderView : reminderViews) {
            reminderView.getRadioButton().addActionListener(getCompletedStatusListener(reminderView));
        }
    }


}
