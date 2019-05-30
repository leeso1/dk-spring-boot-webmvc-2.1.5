package me.learning.domain.service;

import java.util.List;

import me.learning.domain.model.Employee;

public interface EmployeeService {

  public List<Employee> getAllEmployees();
  public void createEmployee(String name, String dept);
  
}
