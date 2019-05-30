package me.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.learning.domain.model.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository employeeRepo;
  
  @Test
  public void whenSave_thenReturnEmployee() {
    //given
    
  }
}
