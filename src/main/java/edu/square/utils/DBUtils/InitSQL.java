package edu.square.utils.DBUtils;

public class InitSQL {
    public static String initSQL = "CREATE TABLE REMINDER (UUID CHAR(36) not null primary key, CONTENT VARCHAR(512), TAG VARCHAR(16), CREATE_TIME TIMESTAMP not null, EARLY_REMINDER_TIME TIMESTAMP, REMIND_TIME TIMESTAMP, DONE_TIME TIMESTAMP, IS_EMERGENCY BOOLEAN, IS_IMPORTANT BOOLEAN, NOTE VARCHAR(512), IS_DELETED BOOLEAN)";

    public static String[] insertData = {"INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('44920bee-b1f6-41a5-86b8-61c1def380ea', 'reminder 10.22', null, '2023-10-22 18:56:41.326000000', null, '2023-10-22 18:56:41.326000000', null, null, false, 'this project start from 10.19', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('3a4b5de5-45a9-4dfe-ad7b-910699e092a3', 'reminder 10.21', null, '2023-10-22 19:47:13.644000000', null, '2023-10-21 19:47:13.644000000', '2023-11-09 18:51:04.894000000', null, false, 'start from 10.19', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('e30995ba-de36-420c-b0bd-9ac017fb179d', 'Reminder Flagged', null, '2023-10-22 19:47:21.644000000', null, '2023-10-31 19:00:00.000000000', '2023-11-09 18:49:37.604000000', null, true, 'note', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('a0afc37b-742c-4be2-a647-24816f1509c7', 'Remidner Flagged', null, '2023-10-22 19:47:30.947000000', null, '2023-10-22 19:47:30.947000000', '2023-10-22 19:47:30.947000000', null, true, null, false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('b637ddb3-f82e-4c2e-90f3-cb44eacfc778', 'Reminder 10.19', null, '2023-10-22 19:47:44.280000000', null, '2023-10-22 19:47:44.280000000', '2023-10-22 19:47:44.280000000', null, false, 'start from 10.19', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('ca4505c3-3de8-4ffb-b8ca-5273687d7315', 'Reminder 10.31', null, '2023-10-31 11:02:49.693000000', null, '2023-10-31 11:02:49.693000000', null, null, false, null, false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('cde24f13-a99f-473f-8aea-cba438e6c15f', 'deleted Reminder', null, '2023-10-31 14:34:53.857000000', null, '2023-10-31 14:34:53.857000000', null, null, false, null, true)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('ab770fbd-9031-4bb1-bfbd-3fef20568a60', 'Remidner 11.9', null, '2023-11-09 18:51:37.844000000', null, '2023-11-09 18:00:00.000000000', null, null, true, '', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('d3b04dc3-f0d9-48c7-bdf3-c2827ab8d229', 'Reminder 11.10', null, '2023-11-09 18:55:34.518000000', null, '2023-11-10 18:00:00.000000000', null, null, true, '', false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('e01f0046-0ebb-4b37-8889-6e00b51c5f64', 'Remidner 11.11', null, '2023-11-09 19:03:48.537000000', null, '2023-11-09 19:03:48.537000000', '2023-11-09 19:43:45.693000000', null, null, null, false)",
            "INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('68db216f-0827-4d1e-aa73-9970705df874', 'Reminder 12.12', null, '2023-11-09 19:05:00.692000000', null, '2023-11-09 19:00:00.000000000', null, null, false, '12.12', false)"};
}