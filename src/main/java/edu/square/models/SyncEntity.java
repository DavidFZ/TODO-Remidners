package edu.square.models;

import java.util.UUID;

public abstract class SyncEntity {
    public final UUID uuid;
    public final Long createdTime;
    private final Long lastModifiedTime;

    /**
     * if this entity is deleted,
     * this field will be set to the time of deletion.
     * if not, this filed value will keep 0
     */
    private Long deletedTime;

    SyncEntity() {
        uuid = java.util.UUID.randomUUID();
        createdTime = System.currentTimeMillis();
        lastModifiedTime = createdTime;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

}
