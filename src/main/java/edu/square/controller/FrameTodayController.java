package edu.square.controller;

import edu.square.models.Reminder;

import static edu.square.utils.DBUtils.hibernate.HDLUtil.updateReminder;
import static edu.square.utils.DBUtils.hibernate.SessionFactoryUtil.getSession;

public class FrameTodayController {
    public static void setReminderDoneStatusAndUpdate(Reminder reminder, boolean isDone) {

        reminder.setDoneTime(isDone ? reminder.getRemindTime() : null);
        reminder.setLastModifiedTime(reminder.getRemindTime());
        reminder.setRemindTime(isDone ? null : reminder.getRemindTime());

        updateReminder(getSession(),reminder);
    }
}
