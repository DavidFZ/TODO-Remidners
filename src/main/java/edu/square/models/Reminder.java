package edu.square.models;


public class Reminder extends SyncEntity {
    private String content;


    private long remindTime;
    private long doneTime;


    private boolean isEmergency;
    private boolean isImportant;


    Reminder(String c) {
        super();
        content = c;
    }

    public static void main(String[] args) {
        System.out.println(java.util.UUID.randomUUID());

    }
}
