package me.learning;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import me.learning.domain.model.Employee;
import me.learning.domain.model.EmployeeRepository;
import me.learning.domain.model.EmployeeSalary;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepo;

    Employee employee;

    @Before
    public void init() {
        employee = Employee.builder()
                .withId(1L)
                .withName("SongDaeKwon")
                .withDepartment("SDP Team")
                .build();
        employeeRepo.save(employee);
    }

    @Test
    public void whenSave_thenReturnEmployee() {
        // given
        // init()

        // when
        Optional<Employee> sdk = employeeRepo.findById(employee.getId());

        // then
        assertThat(sdk.get().getId()).isEqualTo(employee.getId());
        assertThat(sdk.get().getName()).isEqualTo(employee.getName());
        assertThat(sdk.get().getDepartment()).isEqualTo(employee.getDepartment());
    }

    @Test
    public void whenSalarySave_thenReturnEmployeeWithSalary() {
        // given
        employee.paySalary(2019, 6, BigDecimal.valueOf(10000.00), "USD");
        Employee sdk = employeeRepo.save(employee);

        // when
        List<EmployeeSalary> employeeSalaries = sdk.getSalaries();

        // then
        assertThat(employeeSalaries).isNotEmpty();

    }
}
