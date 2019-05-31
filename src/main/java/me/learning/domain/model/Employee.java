package me.learning.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode(callSuper=false)
public class Employee extends BaseEntity {

  /**
   * Employee ID
   */
  @Id
  @GeneratedValue
  @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false)
  private Long id;
  
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
