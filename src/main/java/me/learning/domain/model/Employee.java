package me.learning.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@SuppressWarnings("serial")
public class Employee extends BaseEntity implements Serializable {

    /**
     * Employee ID
     */
    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID", nullable = false, updatable = false)
    private Long id;

    /**
     * Employee Name
     */
    @Column(name = "EMPLOYEE_NM", nullable = false, length = 100)
    private String name;

    /**
     * Employee Department
     */
    @Column(name = "EMPLOYEE_DEPT", length = 100)
    private String department;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<EmployeeSalary> salaries = new ArrayList<>();

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.department = builder.department;
        this.salaries = builder.salaries;
    }

    /**
     * Parameter Constructor
     */
    public Employee(Long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<EmployeeSalary> getSalaries() {
        return salaries;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department="
                + department + "]";
    }

    /**
     * Pay salary to employee
     *
     * @param year
     * @param month
     */
    public void paySalary(int year, int month, BigDecimal salary, String currency) {
        LocalDateTime now = LocalDateTime.now().withNano(0);
        EmployeeSalary employSalary = EmployeeSalary.builder()
                .withId(getId())
                .withYear(now.getYear())
                .withMonth(now.getMonthValue())
                .withDay(now.getDayOfMonth())
                .withSalary(salary)
                .withCurrency(currency)
                .build();
        salaries.add(employSalary);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private Long id;
        private String name;
        private String department;
        private List<EmployeeSalary> salaries = Collections.emptyList();

        private Builder() {
        }

        public Builder withId(Long id) {
            Objects.requireNonNull(id);
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            Objects.requireNonNull(name);
            this.name = name;
            return this;
        }

        public Builder withDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder withSalaries(List<EmployeeSalary> salaries) {
            this.salaries = salaries;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}
