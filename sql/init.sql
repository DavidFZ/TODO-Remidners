create table REMINDER
(
    UUID               CHAR(36)  not null
        primary key,
    CONTENT            VARCHAR(512),
    CREATE_TIME        TIMESTAMP not null,
    LAST_MODIFIED_TIME TIMESTAMP not null,
    REMIND_TIME        TIMESTAMP,
    DONE_TIME          TIMESTAMP,
    IS_EMERGENCY       BOOLEAN,
    IS_IMPORTANT       BOOLEAN
);

