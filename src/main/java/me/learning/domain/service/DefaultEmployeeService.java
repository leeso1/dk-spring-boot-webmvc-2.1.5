package me.learning.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import me.learning.domain.model.Employee;
import me.learning.domain.model.EmployeeRepository;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

  private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
  
  private final EmployeeRepository employeeRepo;
  
  public DefaultEmployeeService(EmployeeRepository repository) {
    this.employeeRepo = repository;
  }
  
  public List<Employee> getAll() {
    return null;
  }
 
  public void create(String name, String dept) {
    Assert.notNull(name, "name must be not null");
    Employee employee = Employee.builder()
        .name(name)
        .department(dept)
        .build();
    employee = employeeRepo.save(employee);
    LOG.info("Created new employee with id({})", employee.getId());
  }
}
