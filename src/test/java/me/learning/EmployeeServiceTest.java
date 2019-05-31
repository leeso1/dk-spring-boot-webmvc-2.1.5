package me.learning;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
  
  @TestConfiguration
  static class EmployeeServiceContextConfiguration {
  }

}
