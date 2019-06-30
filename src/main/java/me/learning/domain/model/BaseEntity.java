package me.learning.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class BaseEntity {

    /**
     * updated time
     */
    @Column(name = "UPDATED", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updated;

    /**
     * created time
     */
    @Column(name = "CREATED", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    public LocalDateTime getUpdated() {
        return updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "BaseEntity [updated=" + updated + ", created=" + created + "]";
    }

}
