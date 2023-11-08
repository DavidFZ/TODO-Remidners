package edu.square.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import static edu.square.utils.DevUtils.getTimeStamp;

@Data
public class Reminder implements Exportable, Serializable {
    private String uuid;
    private String content;
    private String tag;


    private Timestamp createTime;
    private Timestamp earlyReminderTime;
    private Timestamp remindTime;
    private Timestamp doneTime;


    private Boolean isEmergency;
    private Boolean isImportant;
    private Boolean isDeleted;

    private String note;


    public Reminder(String c) {
        super();
        uuid = String.valueOf(java.util.UUID.randomUUID());
        content = c;
        createTime = getTimeStamp();
        isDeleted = false;
    }

    public Reminder() {
        uuid = String.valueOf(java.util.UUID.randomUUID());
        isDeleted = false;
    }

    public static void main(String[] args) {
        System.out.println(java.util.UUID.randomUUID());
    }

    @Override
    public String toString() {
        return UUID.randomUUID().toString() + " :" + content;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Reminder) {
            Reminder reminder = (Reminder) obj;
            return this.uuid.equals(reminder.uuid);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
