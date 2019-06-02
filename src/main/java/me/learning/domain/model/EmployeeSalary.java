package me.learning.domain.model;

import com.google.common.collect.Lists;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@IdClass(EmployeeSalaryId.class)
@Table(name = "EMPLOYEE_SALARY")
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmployeeSalary extends BaseEntity implements Serializable {

  /**
   * Employee ID
   */
  @Id
  private Long id;

  /**
   * Pay year
   */
  @Id
  private int year;

  /**
   * Pay month
   */
  @Id
  private int month;

  /**
   * Pay day
   */
  private int day;

  @ManyToOne
  private Employee employee;
}

