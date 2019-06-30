package me.learning.domain.model;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Optional<Employee> findByName(String name);

}
