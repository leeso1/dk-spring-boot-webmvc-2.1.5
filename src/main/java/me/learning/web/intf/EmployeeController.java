package me.learning.web.intf;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.learning.domain.service.EmployeeService;
import me.learning.web.intf.dto.Staff;

@RestController
@RequestMapping("/api")
public class EmployeeController {
  
  @Autowired
  EmployeeService employeeService;
  
  @GetMapping(value = "/staffs")
  public List<Staff> getAllStaffs() {
    return employeeService.getAllEmployees().stream()
        .map(Staff::from)
        .collect(Collectors.toList());
  }

}
