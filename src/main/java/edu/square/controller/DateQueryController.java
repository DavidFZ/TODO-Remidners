package edu.square.controller;

import edu.square.entity.Reminder;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import static edu.square.utils.DBUtils.hibernate.CriteriaQueryUtil.getCriteriaQuery;
import static edu.square.utils.DBUtils.hibernate.SessionFactoryUtil.getSession;
import static edu.square.utils.TimeUtils.getStartOrEndTimestampOfDate;
import static edu.square.utils.TimeUtils.getStartOrEndTimestampOfToday;


public class DateQueryController {

    public static List<Reminder> queryReminderByDate(String attribute, Timestamp start, Timestamp end) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate = criteriaBuilder.between(root.get(attribute), start, end);
        criteriaQuery.select(root).where(predicate);

        TypedQuery<Reminder> query = s.createQuery(criteriaQuery);
        List<Reminder> list = query.getResultList();
        s.close();

        return list;
    }

    public static List<Reminder> queryReminderDuringDate(String attribute, LocalDate localDate) {
        return queryReminderByDate(attribute, getStartOrEndTimestampOfDate(localDate, true), getStartOrEndTimestampOfDate(localDate, false));
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
        List<Reminder> list = queryReminderByDate("lastModifiedTime", getStartOrEndTimestampOfToday(true), getStartOrEndTimestampOfToday(false));
        List<Reminder> list1 = queryReminderDuringDate("lastModifiedTime", LocalDate.now());
        System.out.println(list.size());
        System.out.println(list1.size());
        System.out.println(list);
        System.out.println(list1);
//    System.out.println(getStartTimestampOfToday(true));
//    System.out.println(getStartTimestampOfToday(false));
    }

}
