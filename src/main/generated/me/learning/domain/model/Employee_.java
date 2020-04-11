package me.learning.domain.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ extends me.learning.domain.model.BaseEntity_ {

	public static volatile ListAttribute<Employee, EmployeeSalary> salaries;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, String> department;

	public static final String SALARIES = "salaries";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String DEPARTMENT = "department";

}

