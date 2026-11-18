package com.campuslab.platform.u202212214.shared.domain.model.aggregates;

import java.time.Instant;

/**
 * @author Oskar Sosa
 */
public abstract class AbstractDomainAggregateRoot {

    private final Long id;
    private final Instant createdAt;
    private final Instant updatedAt;

    protected AbstractDomainAggregateRoot() {
        this(null, null, null);
    }

    protected AbstractDomainAggregateRoot(Long id, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
