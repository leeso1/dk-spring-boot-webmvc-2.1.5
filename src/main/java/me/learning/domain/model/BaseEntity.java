package me.learning.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.ToString;

@MappedSuperclass
@Getter
@ToString
public abstract class BaseEntity {
  
  /**
   * updated time
   */
  @Column(name = "UPDATED", nullable = false)
  private LocalDateTime updated;
  
  /**
   * created time
   */
  @Column(name = "CREATED", nullable = false, updatable = false)
  private LocalDateTime created;
  
  @PrePersist
  public void prePersist() {
    LocalDateTime now = LocalDateTime.now().withNano(0);
    this.updated = now;
    this.created = now;
  }
  
  @PreUpdate
  public void preUpdate() {
    this.updated = LocalDateTime.now().withNano(0);
  }

}
