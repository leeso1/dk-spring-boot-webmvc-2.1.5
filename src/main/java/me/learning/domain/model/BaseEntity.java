package me.learning.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Getter
@ToString
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

}
