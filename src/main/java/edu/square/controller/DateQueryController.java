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


public class DateQueryController {

    public static final String CREATE_TIME = "createTime";
    public static final String LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String REMIND_TIME = "remindTime";
    public static final String DONE_TIME = "doneTime";
    public static final String IS_EMERGENCY = "isEmergency";
    public static final String IS_IMPORTANT = "isImportant";


    /**
     * Query the reminder by date
     * Attribute should be the field name of Reminder
     *
     * @param attribute field name of Reminder
     * @param start     start Timestamp
     * @param end       end Timestamp
     * @return Reminder list range between start and end
     */
    public static List<Reminder> queryReminderByDate(String attribute, Timestamp start, Timestamp end) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate = criteriaBuilder.between(root.get(String.valueOf(attribute)), start, end);
        criteriaQuery.select(root).where(predicate);

        TypedQuery<Reminder> query = s.createQuery(criteriaQuery);
        List<Reminder> list = query.getResultList();
        s.close();

        return list;
    }


    /**
     * Query the reminder by date
     *
     * @param attribute field name of Reminder
     * @param localDate LocalDate
     * @return Reminder list at the date
     */
    public static List<Reminder> queryReminderByDate(String attribute, LocalDate localDate) {
        return queryReminderByDate(attribute, getStartOrEndTimestampOfDate(localDate, true), getStartOrEndTimestampOfDate(localDate, false));
    }

    //TODO: abstract the queryReminderByDate method

    /**
     * Query the reminder by done status
     *
     * @param isDone done status
     * @return Reminder list which is done or not
     */
    public static List<Reminder> queryReminderByDoneStatus(boolean isDone) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate;
        if (isDone)
            predicate = criteriaBuilder.isNotNull(root.get(DONE_TIME));
        else
            predicate = criteriaBuilder.isNull(root.get(DONE_TIME));
        criteriaQuery.select(root).where(predicate);

        TypedQuery<Reminder> query = s.createQuery(criteriaQuery);
        List<Reminder> list = query.getResultList();
        s.close();

        return list;
    }

    public static void main(String[] args) {
//        List<Reminder> list = queryReminderByDate(LAST_MODIFIED_TIME, getStartOrEndTimestampOfToday(true), getStartOrEndTimestampOfToday(false));
        List<Reminder> list = queryReminderByDoneStatus(false);
        System.out.println(list.size());
        System.out.println(list);
    }

}
