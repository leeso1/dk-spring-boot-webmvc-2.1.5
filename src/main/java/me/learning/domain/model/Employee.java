package me.learning.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Entity(name = "EMPLOYEE")
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper=false)
public class Employee extends BaseEntity {

  /**
   * Employee ID
   */
  @Id
  @GeneratedValue
  @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false)
  private final Long id;
  
  /**
   * Employee Name
   */
  @Column(name = "EMPLOYEE_NM", nullable = false, length = 100)
  private String name;
  
  /**
   * Employee Department
   */
  @Column(name = "EMPLOYEE_DEPT", length = 100)
  private String department;
}
