package edu.square.model;

import edu.square.entity.Reminder;
import edu.square.utils.TimeUtils;
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
import static edu.square.utils.DevUtils.getTimeStamp;
import static edu.square.utils.TimeUtils.getStartOrEndTimestampOfDate;

public class ReminderModel {

    public static final String CREATE_TIME = "createTime";
    public static final String LAST_MODIFIED_TIME = "lastModifiedTime";
    public static final String REMIND_TIME = "remindTime";
    public static final String DONE_TIME = "doneTime";
    public static final String IS_EMERGENCY = "isEmergency";
    public static final String IS_IMPORTANT = "isImportant";

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
     * Query today's reminder
     *
     * @return Reminder list at today
     */
    public static List<Reminder> queryReminderOfToday() {
        return queryReminderByDate(REMIND_TIME, getStartOrEndTimestampOfDate(LocalDate.now(), true), getStartOrEndTimestampOfDate(LocalDate.now(), false));
    }

    //Reuse code for two fields
    private static List<Reminder> queryReminderBoolField(String attribute, boolean bool) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate;
        if (bool)
            predicate = criteriaBuilder.isTrue(root.get(attribute));
        else
            predicate = criteriaBuilder.isFalse(root.get(attribute));
        criteriaQuery.select(root).where(predicate);

        TypedQuery<Reminder> query = s.createQuery(criteriaQuery);
        List<Reminder> list = query.getResultList();
        s.close();

        return list;
    }

    /**
     * Query the reminder by important status
     *
     * @param isImportant important status
     * @return Reminder list which is important or not
     */
    public static List<Reminder> queryReminderByImportantStatus(boolean isImportant) {
        return queryReminderBoolField(IS_IMPORTANT, isImportant);
    }

    /**
     * Query the reminder by emergency status
     *
     * @param isEmergency emergency status
     * @return Reminder list which is emergency or not
     */
    public static List<Reminder> queryReminderByEmergencyStatus(boolean isEmergency) {
        return queryReminderBoolField(IS_EMERGENCY, isEmergency);
    }

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

    /**
     * Query the reminder by important and emergency status
     * Query once, instead of query twice and merge the result
     *
     * @param isImportant important status
     * @param isEmergency emergency status
     * @return List of Reminder which is important and emergency or not
     */
    public static List<Reminder> queryReminderByImportantAndEmergency(boolean isImportant, boolean isEmergency) {
        Session s = getSession();

        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = getCriteriaQuery(s, Reminder.class);
        Root<Reminder> root = criteriaQuery.from(Reminder.class);

        Predicate predicate;
        if (isImportant && isEmergency)
            predicate = criteriaBuilder.and(criteriaBuilder.isTrue(root.get(IS_IMPORTANT)), criteriaBuilder.isTrue(root.get(IS_EMERGENCY)));
        else if (isImportant)
            predicate = criteriaBuilder.and(criteriaBuilder.isTrue(root.get(IS_IMPORTANT)), criteriaBuilder.isFalse(root.get(IS_EMERGENCY)));
        else if (isEmergency)
            predicate = criteriaBuilder.and(criteriaBuilder.isFalse(root.get(IS_IMPORTANT)), criteriaBuilder.isTrue(root.get(IS_EMERGENCY)));
        else
            predicate = criteriaBuilder.and(criteriaBuilder.isFalse(root.get(IS_IMPORTANT)), criteriaBuilder.isFalse(root.get(IS_EMERGENCY)));
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


    public static void updateReminderEntityDoneStatus(Reminder reminder, boolean isDone) {

        reminder.setDoneTime(isDone ? TimeUtils.getCurrentTimestamp() : null);
        reminder.setRemindTime(isDone ? null : reminder.getRemindTime());

        updateReminder(reminder);
    }

    public static Reminder insertReminder(String content) {
        Session s = getSession();

        Reminder reminder = new Reminder(content);
        reminder.setRemindTime(getTimeStamp());

        s.merge(reminder);
        s.beginTransaction().commit();
        return reminder;
    }

    public static void updateReminder(Reminder reminder) {
        Session session = getSession();

        session.merge(reminder);
        session.beginTransaction().commit();

        session.close();
    }
}
