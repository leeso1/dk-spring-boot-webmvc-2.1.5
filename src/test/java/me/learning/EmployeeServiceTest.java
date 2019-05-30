package me.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import me.learning.domain.model.EmployeeRepository;
import me.learning.domain.service.DefaultEmployeeService;
import me.learning.domain.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

  @TestConfiguration
  static class EmployeeServiceTestContextConfiguration {
    @Bean
    public EmployeeService employeeService() {
      return new DefaultEmployeeService();
    }
  }
  
  @Autowired
  private EmployeeService employeeService;
  
  @MockBean
  private EmployeeRepository employeeRepository;
}
