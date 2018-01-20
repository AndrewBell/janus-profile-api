package com.recursivechaos.profile.models;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Provides child entities ID generation for Spanner
 * Modified from: https://github.com/olavloite/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-jpa
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(nullable = false, columnDefinition = "BYTES(16)", unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private Date created;

    @Column(nullable = false)
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        if (uuid == null)
            uuid = UUID.randomUUID();
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
        updated = new Date();
        if (uuid == null)
            uuid = UUID.randomUUID();
        if (id == null)
            id = uuid.getMostSignificantBits() ^ uuid.getLeastSignificantBits();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof BaseEntity))
            return false;

        return ((BaseEntity) other).getUuid().equals(this.getUuid());
    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }

    public boolean isSaved() {
        return getId() != null;
    }

}