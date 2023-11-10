package edu.square.utils.DBUtils.hibernate;

import edu.square.entity.Reminder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static edu.square.utils.DevUtils.getTimeStamp;

public class SessionFactoryUtil {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Returns the session
     *
     * @return session
     */
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
