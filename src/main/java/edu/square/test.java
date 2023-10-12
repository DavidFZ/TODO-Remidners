package edu.square;

import edu.square.models.Reminder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.List;

import static edu.square.utils.DevUtils.getTimeStamp;
import static edu.square.utils.FileUtil.parseSQLFile;

public class test {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration().configure();
        System.out.println(configuration);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Reminder reminder = new Reminder("java test");
        reminder.setRemindTime(getTimeStamp());

        session.save(reminder);
        session.beginTransaction().commit();
    }
}
