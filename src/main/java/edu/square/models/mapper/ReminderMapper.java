package edu.square.models.mapper;

import edu.square.models.Reminder;

import java.util.List;

public interface ReminderMapper {
    List<Reminder> getAllEntities();

    void insertEntity(Reminder reminder);
}
