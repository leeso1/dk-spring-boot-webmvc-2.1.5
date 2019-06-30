package me.learning.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.annotation.Generated;

@Entity
@IdClass(EmployeeSalaryId.class)
@Table(name = "EMPLOYEE_SALARY")
@SuppressWarnings("serial")
public class EmployeeSalary extends BaseEntity implements Serializable {

    /**
     * Employee ID
     */
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private Long id;

    /**
     * Pay year
     */
    @Id
    @Column(name = "YEAR", nullable = false)
    private int year;

    /**
     * Pay month
     */
    @Id
    @Column(name = "MONTH", nullable = false)
    private int month;

    /**
     * Pay day
     */
    @Column(name = "DAY", nullable = false)
    private int day;

    /**
     * Total salary of month
     */
    @Column(name = "SALARY", nullable = false)
    private BigDecimal salary;

    /**
     * Currency Code ( ISO 4217 )
     * ex) EUR(유), USD(미국달러), KRW(원)
     */
    @Column(name = "CURRENCY", length = 3)
    private String currency;

    @ManyToOne(optional = true)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    private Employee employee;

    @Generated("SparkTools")
    private EmployeeSalary(Builder builder) {
        this.id = builder.id;
        this.year = builder.year;
        this.month = builder.month;
        this.day = builder.day;
        this.salary = builder.salary;
        this.currency = builder.currency;
        this.employee = builder.employee;
    }

    public EmployeeSalary() {
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + month;
        result = prime * result + year;
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
        EmployeeSalary other = (EmployeeSalary) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeSalary [id=" + id + ", year=" + year + ", month=" + month
                + ", day=" + day + ", salary=" + salary + ", currency=" + currency
                + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private int year;
        private int month;
        private int day;
        private BigDecimal salary;
        private String currency;
        private Employee employee;

        private Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withYear(int year) {
            this.year = year;
            return this;
        }

        public Builder withMonth(int month) {
            this.month = month;
            return this;
        }

        public Builder withDay(int day) {
            this.day = day;
            return this;
        }

        public Builder withSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public Builder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder withEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public EmployeeSalary build() {
            return new EmployeeSalary(this);
        }
    }
}

