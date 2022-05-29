package com.golikov.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Embeddable

public class Audit {
    @Column(name = "create_at")
    private LocalDateTime createAt;
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public Audit() {
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    @PrePersist
    public void create() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        updateAt = LocalDateTime.now();
    }
}
