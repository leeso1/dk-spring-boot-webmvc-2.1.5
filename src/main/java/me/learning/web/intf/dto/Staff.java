package me.learning.web.intf.dto;

import lombok.Builder;
import lombok.Data;
import me.learning.domain.model.Employee;

@Data
@Builder
public class Staff {

  private Long staffId;
  private String staffName;
  private String staffDepartment;
  
  public static Staff from(Employee employee) {
    return Staff.builder()
        .staffId(employee.getId())
        .staffName(employee.getName())
        .staffDepartment(employee.getDepartment())
        .build();
  }
}
