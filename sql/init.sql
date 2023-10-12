create table REMINDER
(
    UUID               CHAR(32)  not null
        primary key,
    CREATE_TIME        TIMESTAMP not null,
    LAST_MODIFIED_TIME TIMESTAMP not null,
    CONTENT            VARCHAR(512),
    DONE_TIME          TIMESTAMP,
    IS_EMERGENCY       BOOLEAN,
    IS_IMPORTANT       BOOLEAN
);

