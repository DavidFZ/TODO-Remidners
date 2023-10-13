package edu.square.utils.DBUtils.hibernate;

import edu.square.models.Reminder;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.List;

public class HDLUtil {
    public static List<Reminder> queryAllEntities(Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Reminder> criteriaQuery = criteriaBuilder.createQuery(Reminder.class);

        Root<Reminder> root = criteriaQuery.from(Reminder.class);
        criteriaQuery.select(root);
        List<Reminder> reminders = session.createQuery(criteriaQuery).getResultList();
        session.close();

        return reminders;
    }

    public static void updateReminder(Session session, Reminder reminder) {
        session.merge(reminder);
        session.beginTransaction().commit();
        session.close();
    }
}
