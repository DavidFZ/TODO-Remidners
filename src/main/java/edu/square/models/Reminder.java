package edu.square.models;

import lombok.Data;

import java.sql.Timestamp;

import static edu.square.utils.DevUtils.getTimeStamp;

@Data
public class Reminder {
    private String uuid;
    private String content;


    private Timestamp createTime;
    private Timestamp lastModifiedTime;
    private Timestamp remindTime;
    private Timestamp doneTime;


    private Boolean isEmergency;
    private Boolean isImportant;


    public Reminder(String c) {
        super();
        uuid = String.valueOf(java.util.UUID.randomUUID());
        content = c;
        createTime = lastModifiedTime = getTimeStamp();
    }

    public Reminder() {
        uuid = String.valueOf(java.util.UUID.randomUUID());
    }

    public static void main(String[] args) {
        System.out.println(java.util.UUID.randomUUID());

    }
}
