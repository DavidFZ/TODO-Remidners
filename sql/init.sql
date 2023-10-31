create table REMINDER
(
    UUID                CHAR(36)  not null
        primary key,
    CONTENT             VARCHAR(512),
    TAG                 VARCHAR(16),
    CREATE_TIME         TIMESTAMP not null,
    EARLY_REMINDER_TIME TIMESTAMP,
    REMIND_TIME         TIMESTAMP,
    DONE_TIME           TIMESTAMP,
    IS_EMERGENCY        BOOLEAN,
    IS_IMPORTANT        BOOLEAN,
    NOTE                VARCHAR(512),
    IS_DELETED          BOOLEAN
);

INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('44920bee-b1f6-41a5-86b8-61c1def380ea', 'reminder 10.22', null, '2023-10-22 18:56:41.326000000', null, null, null, null, null, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('3a4b5de5-45a9-4dfe-ad7b-910699e092a3', 'Reminder 10.21', null, '2023-10-22 19:47:13.644000000', null, '2023-10-21 19:47:13.644000000', null, null, null, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('e30995ba-de36-420c-b0bd-9ac017fb179d', 'Reminder Flagged', null, '2023-10-22 19:47:21.644000000', null, '2023-10-22 19:47:21.644000000', null, null, true, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('a0afc37b-742c-4be2-a647-24816f1509c7', 'Remidner Flagged', null, '2023-10-22 19:47:30.947000000', null, null, '2023-10-22 19:47:30.947000000', null, true, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('b637ddb3-f82e-4c2e-90f3-cb44eacfc778', 'Reminder 10.19', null, '2023-10-22 19:47:44.280000000', null, null, '2023-10-22 19:47:44.280000000', null, null, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('ca4505c3-3de8-4ffb-b8ca-5273687d7315', 'Reminder 10.31', null, '2023-10-31 11:02:49.693000000', null, null, null, null, null, null, false);
INSERT INTO APP.REMINDER (UUID, CONTENT, TAG, CREATE_TIME, EARLY_REMINDER_TIME, REMIND_TIME, DONE_TIME, IS_EMERGENCY, IS_IMPORTANT, NOTE, IS_DELETED) VALUES ('cde24f13-a99f-473f-8aea-cba438e6c15f', 'deleted Reminder', null, '2023-10-31 14:34:53.857000000', null, null, null, null, null, null, true);



