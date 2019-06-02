package me.learning.domain.model;

import javax.persistence.*;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "salaries")
@EqualsAndHashCode(callSuper=false)
public class Employee extends BaseEntity implements Serializable {

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

  @OneToMany(mappedBy = "employee")
  List<EmployeeSalary> salaries = Lists.newArrayList();

}
