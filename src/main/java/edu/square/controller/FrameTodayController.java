package edu.square.controller;

import edu.square.entity.Reminder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

import static edu.square.utils.DBUtils.hibernate.SessionFactoryUtil.getSession;
import static edu.square.utils.DevUtils.getTimeStamp;

public class FrameTodayController {

    public static List<Reminder> queryAllEntities() {
        Session session = getSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = criteriaBuilder.createQuery(Reminder.class);

        Root<Reminder> root = criteriaQuery.from(Reminder.class);
        criteriaQuery.select(root);
        List<Reminder> reminders = session.createQuery(criteriaQuery).getResultList();

        session.close();

        return reminders;
    }

    public static void updateReminderEntityDoneStatus(Reminder reminder, boolean isDone) {

        reminder.setDoneTime(isDone ? reminder.getRemindTime() : null);
        reminder.setLastModifiedTime(getTimeStamp());
        reminder.setRemindTime(isDone ? null : reminder.getRemindTime());

        updateReminder(getSession(), reminder);
    }

    public static Reminder insertReminderEntity(String content) {
        Session s = getSession();

        Reminder reminder = new Reminder(content);
        reminder.setRemindTime(getTimeStamp());

        s.merge(reminder);
        s.beginTransaction().commit();
        return reminder;
    }


    public static void updateReminder(Session session, Reminder reminder) {
        session.merge(reminder);
        session.beginTransaction().commit();
        session.close();
    }

}
