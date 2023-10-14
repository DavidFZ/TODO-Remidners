package edu.square.controller;

import edu.square.entity.Reminder;

import static edu.square.utils.DBUtils.hibernate.HDLUtil.updateReminder;
import static edu.square.utils.DBUtils.hibernate.SessionFactoryUtil.getSession;
import static edu.square.utils.DevUtils.getTimeStamp;

public class FrameTodayController {
    public static void setReminderDoneStatusAndUpdate(Reminder reminder, boolean isDone) {

        reminder.setDoneTime(isDone ? reminder.getRemindTime() : null);
        reminder.setLastModifiedTime(getTimeStamp());
        reminder.setRemindTime(isDone ? null : reminder.getRemindTime());

        updateReminder(getSession(),reminder);
    }
}
