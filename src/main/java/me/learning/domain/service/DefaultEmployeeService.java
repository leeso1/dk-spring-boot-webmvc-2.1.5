package me.learning.domain.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import me.learning.domain.model.Employee;
import me.learning.domain.model.EmployeeRepository;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

  private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Transactional(readOnly=true)
  public Page<Employee> getAllEmployees(int page, int size, Sort sort) {
    
    PageRequest req = PageRequest.of(page, size, sort);
    Page<Employee> result = employeeRepository.findAll(req);
    return result;
  }
 
  public void createEmployee(String name, String dept) {
    Assert.notNull(name, "name must be not null");
    
    // TODO 동명인이 있을 경우 유니크 에러를 발생하도록 수정 예정
    
    Employee employee = Employee.builder()
        .name(name)
        .department(dept)
        .build();
    employee = employeeRepository.save(employee);
    LOG.info("Created new employee with id({})", employee.getId());
  }

  @Override
  @Transactional(readOnly=true)
  public Employee getStaffByName(String name) {
    Assert.notNull(name, "name must be not null");
    Optional<Employee> employee = employeeRepository.findByName(name);
    return employee.orElseThrow(() -> new ResourceNotFoundException("Not Found " + name));
  }
}
