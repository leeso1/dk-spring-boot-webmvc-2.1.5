package me.learning.web.intf;

import java.util.stream.Collectors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.learning.domain.model.Employee;
import me.learning.domain.service.EmployeeService;
import me.learning.web.intf.dto.PageResult;
import me.learning.web.intf.dto.Staff;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {
  
  private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
  
  @Autowired
  EmployeeService employeeService;
  
  /**
   * Page를 이용한 Staff 조회
   * 
   * @param page - page index
   * @param size - item size
   * @param sort - nm_desc, nm_asc(default)
   * @return Page<Staff>
   */
  @GetMapping(value = "/staffs", params = {"page", "size"})
  public PageResult<Staff> getAllStaffs(
      @RequestParam(name = "page", defaultValue="0") @Min(0) int page,
      @RequestParam(name = "size", defaultValue = "10") @Min(1) @Max(100) int size,
      @RequestParam(name = "sort", defaultValue = "nm_asc") String sort) {
    LOG.info("[IF-001.STAFF 조회] params -> page={}, size={}, sort={}", page, size, sort);
    Page<Employee> employees = employeeService.getAllEmployees(page, size);
    LOG.info("[IF-001.STAFF 조회] OK. Returned elements={}", employees.getNumberOfElements());
    return PageResult.<Staff>builder()
        .total(employees.getTotalElements())
        .items(
            employees.getContent().stream()
            .map(Staff::from)
            .collect(Collectors.toList()))
        .build();
    }
  
  /**
   * Offset, Limit을 이용한 Staff 조회
   * 
   * @param offset
   * @param limit
   * @return
   */
  @GetMapping(value = "/staffs", params = {"offset", "limit"})
  public Page<Staff> getStaffPagenated(
      @RequestParam(name = "offset", defaultValue="0") @Min(0) int offset,
      @RequestParam(name = "limit", defaultValue = "10") @Min(1) @Max(100) int limit) {
    LOG.info("[IF-002.STAFF 조회] params -> offset={}, size={}", offset, limit);
    return Page.empty();
  }
  
  /**
   * Staff 생성
   * 
   * @param staffName
   * @param staffDepartment
   */
  @PostMapping(value = "/staffs")
  public void createStaff(
      @RequestParam(name = "name") @NotBlank String staffName,
      @RequestParam(name = "department") String staffDepartment ) {
    LOG.info("[IF-003.STAFF 생성] params -> name={}, department={}", staffName, staffDepartment);
    employeeService.createEmployee(staffName, staffDepartment);
    LOG.info("[IF-003.STAFF 생성] OK");
  }
  
  /**
   * 이름으로 Staff 조회
   * 
   * @param staffName
   * @return
   */
  @GetMapping(value = "/staffs/showByName")
  public Staff getStaffByName(
      @RequestParam(name = "name") @NotBlank String staffName) {
    LOG.info("[IF-003.STAFF 조회] params -> name={}", staffName);
    Employee employee = employeeService.getStaffByName(staffName);
    LOG.info("[IF-003.STAFF 조회] OK. staffId={}", employee.getId());
    return Staff.from(employee);
  }

}
