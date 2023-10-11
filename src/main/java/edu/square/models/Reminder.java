package edu.square.models;


public class Reminder extends SyncEntity {
    private String content;


    private long remindTime;
    private long doneTime;


    private boolean isDone;
    private boolean isFlagged;
    private boolean isEmergency;
    private boolean isImportant;


    /**
     * for recognizing devices  by ues cloud to sync
     */
    private String createBy;

    Reminder(String c) {
        super();
        content = c;
    }

    public static void main(String[] args) {
        System.out.println(java.util.UUID.randomUUID());

    }
}
