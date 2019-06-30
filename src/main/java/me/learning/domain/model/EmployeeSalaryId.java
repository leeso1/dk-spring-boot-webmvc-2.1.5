package me.learning.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class EmployeeSalaryId implements Serializable {

    /**
     * Employee ID
     */
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private Long id;

    /**
     * Pay Year
     * ex) 1973, 2019
     */
    @Column(name = "YEAR", nullable = false)
    private int year;

    /**
     * Pay month
     * ex) 01, 02...12
     */
    @Column(name = "MONTH", nullable = false)

    private int month;

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
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
        EmployeeSalaryId other = (EmployeeSalaryId) obj;
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
        return "EmployeeSalaryId [id=" + id + ", year=" + year + ", month=" + month
                + "]";
    }

}
