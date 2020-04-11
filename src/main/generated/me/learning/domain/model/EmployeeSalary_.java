package me.learning.domain.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmployeeSalary.class)
public abstract class EmployeeSalary_ extends me.learning.domain.model.BaseEntity_ {

	public static volatile SingularAttribute<EmployeeSalary, Integer> month;
	public static volatile SingularAttribute<EmployeeSalary, Integer> year;
	public static volatile SingularAttribute<EmployeeSalary, String> currency;
	public static volatile SingularAttribute<EmployeeSalary, Long> id;
	public static volatile SingularAttribute<EmployeeSalary, BigDecimal> salary;
	public static volatile SingularAttribute<EmployeeSalary, Employee> employee;
	public static volatile SingularAttribute<EmployeeSalary, Integer> day;

	public static final String MONTH = "month";
	public static final String YEAR = "year";
	public static final String CURRENCY = "currency";
	public static final String ID = "id";
	public static final String SALARY = "salary";
	public static final String EMPLOYEE = "employee";
	public static final String DAY = "day";

}

