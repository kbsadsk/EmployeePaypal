package com.paypal.bfs.test.employeeserv.repository;

import com.paypal.bfs.test.employeeserv.dao.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    EmployeeEntity findByFirstNameAndLastNameAndDateOfBirth(String firstName, String lastName, String dob);
}
