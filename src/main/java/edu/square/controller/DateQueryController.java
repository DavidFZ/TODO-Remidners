package edu.square.controller;

import edu.square.entity.Reminder;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.List;

import static edu.square.utils.DBUtils.hibernate.CriteriaQueryUtil.getCriteriaQuery;
import static edu.square.utils.DBUtils.hibernate.SessionFactoryUtil.getSession;
import static edu.square.utils.TimeUtils.getStartTimestampOfToday;


public class DateQueryController {

    public static List<Reminder> queryReminderEntitiesByDate(Timestamp start, Timestamp end) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate = criteriaBuilder.between(root.get("lastModifiedTime"), start, end);
        criteriaQuery.select(root).where(predicate);

        TypedQuery<Reminder> query = s.createQuery(criteriaQuery);
        List<Reminder> list = query.getResultList();
        s.close();

        return list;
    }

    public static List<Reminder> queryAllEntitiesByDate(String date) {
//        Session session = getSession();
//
//
//        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQueryOfAll(session, Reminder.class);
//
//
//
//        session.close();
//
//        return reminders;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(queryReminderEntitiesByDate(getStartTimestampOfToday(true), getStartTimestampOfToday(false)));
//    System.out.println(getStartTimestampOfToday(true));
//    System.out.println(getStartTimestampOfToday(false));
    }

}
