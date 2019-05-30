package me.learning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.learning.domain.model.Employee;
import me.learning.domain.model.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository employeeRepo;
  
  @Test
  public void whenSave_thenReturnEmployee() {
    // given
    Employee employee = Employee.builder()
        .name("SongDaeKwon")
        .department("SDP Team")
        .build();
    
    // when
    Employee sdk = employeeRepo.save(employee);
    
    // then
    assertThat(sdk.getId()).isGreaterThanOrEqualTo(1L);
    assertThat(sdk.getName()).isEqualTo(employee.getName());
    assertThat(sdk.getDepartment()).isEqualTo(employee.getDepartment());
  }
}
