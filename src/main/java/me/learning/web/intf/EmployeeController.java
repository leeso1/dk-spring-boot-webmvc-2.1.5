package me.learning.web.intf;

import java.util.stream.Collectors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.learning.domain.model.Employee;
import me.learning.domain.service.EmployeeService;
import me.learning.web.intf.dto.Staff;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {
  
  private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
  
  @Autowired
  EmployeeService employeeService;
  
  @GetMapping(value = "/staffs", params = {"page", "size"})
  public Page<Staff> getAllStaffs(
      @RequestParam(name = "page", defaultValue="0") @Min(0) int page,
      @RequestParam(name = "size", defaultValue = "10") @Min(1) @Max(100) int size) {
    LOG.info("[IF-001.STAFF 조회] params -> page={}, size={}", page, size);
    Page<Employee> employees = employeeService.getAllEmployees(page, size);
    return new PageImpl<>(
        employees.getContent().stream()
        .map(Staff::from)
        .collect(Collectors.toList()), 
        employees.getPageable(), employees.getTotalElements());
    }
  
  @GetMapping(value = "/staffs", params = {"offset", "limit"})
  public Page<Staff> getStaffPagenated(
      @RequestParam(name = "offset", defaultValue="0") @Min(0) int offset,
      @RequestParam(name = "limit", defaultValue = "10") @Min(1) @Max(100) int limit) {
    LOG.info("[IF-002.STAFF 조회] params -> offset={}, size={}", offset, limit);
    return Page.empty();
  }
  
  @PostMapping(value = "/staffs")
  public void createStaff(
      @RequestParam(name = "name") @NotBlank String staffName,
      @RequestParam(name = "department") String staffDepartment ) {
    LOG.info("[IF-003.STAFF 생성] params -> name={}, department={}", staffName, staffDepartment);
    employeeService.createEmployee(staffName, staffDepartment);
    LOG.info("[IF-003.STAFF 생성] OK");
  }
  
  @GetMapping(value = "/staffs/find")
  public Staff getStaffByName(
      @RequestParam(name = "name") @NotBlank String staffName) {
    LOG.info("[IF-003.STAFF 조회] params -> name={}", staffName);
    Employee employee = employeeService.getStaffByName(staffName);
    LOG.info("[IF-003.STAFF 조회] OK. staffId={}", employee.getId());
    return Staff.from(employee);
  }

}
