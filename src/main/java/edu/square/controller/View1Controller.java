package edu.square.controller;

import edu.square.entity.Reminder;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.TodayPanelManage;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.widget.ReminderListWidget;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static edu.square.model.ReminderModel.queryAllEntities;
import static edu.square.model.ReminderModel.queryReminderOfToday;

public class View1Controller {
    public static String[] groupTitles = {"All", "Today", "Completed", "Flagged"};

    public static String[] getGroupTitles() {
        //TODO: get group titles from database
        return groupTitles;
    }

    public static void bindComponents(LeftSideComponent leftSideComponent, TodayPanelManage todayPanelManage) {
        List groupLabelWidgets = (List) leftSideComponent.getGroupLabelWidgets();

        GroupLabelWidget widget = (GroupLabelWidget) groupLabelWidgets.get(0);
        widget.getGroupView().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ReminderListWidget reminderListWidget = todayPanelManage.getReminderListWidget();
                reminderListWidget.clearReminderListViewWithoutRepaint();

                List<Reminder> reminders = queryAllEntities();
                for (Reminder reminder :
                        reminders) {
                     todayPanelManage.addItem(reminder);
                }
            }
        });

        widget = (GroupLabelWidget) groupLabelWidgets.get(1);
        widget.getGroupView().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ReminderListWidget reminderListWidget = todayPanelManage.getReminderListWidget();
                reminderListWidget.clearReminderListViewWithoutRepaint();

                List<Reminder> reminders = queryReminderOfToday();
                for (Reminder reminder :
                        reminders) {
                     todayPanelManage.addItem(reminder);
                }
            }
        });

//        for (GroupLabelWidget widget :
//                (List<GroupLabelWidget>) groupLabelWidgets) {
//            widget.getGroupView().addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    super.mouseClicked(e);
//                    todayPanelManage.getReminderListWidget().clearReminderListView();
//                }
//            });
//        }

    }


}
