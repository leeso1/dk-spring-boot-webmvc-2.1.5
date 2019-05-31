package me.learning.domain.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.google.common.collect.Lists;

import me.learning.domain.model.Employee;
import me.learning.domain.model.EmployeeRepository;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {

  private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Transactional(readOnly=true)
  public List<Employee> getAllEmployees() {
    return Lists.newArrayList(employeeRepository.findAll());
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
    return employee.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
  }
}
