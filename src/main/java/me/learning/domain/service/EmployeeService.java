package me.learning.domain.service;

import org.springframework.data.domain.Page;

import me.learning.domain.model.Employee;

public interface EmployeeService {

  public Page<Employee> getAllEmployees(int page, int size);
  public void createEmployee(String name, String dept);
  public Employee getStaffByName(String name);
  
}
