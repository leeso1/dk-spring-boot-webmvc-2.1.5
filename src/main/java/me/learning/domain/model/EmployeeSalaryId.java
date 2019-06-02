package me.learning.domain.model;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
@Getter
@ToString
public class EmployeeSalaryId implements Serializable {

  /**
   * Employee ID
   */
  private Long id;

  /**
   * Pay Year
   * ex) 1973, 2019
   */
  private int year;

  /**
   * Pay month
   * ex) 01, 02...12
   */
  private int month;

}
