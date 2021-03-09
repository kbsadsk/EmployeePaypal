package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

/**
 * Interface for all Actions on Employee
 */
public interface EmployeeService {
    Employee findById(String id);
    Employee create(Employee employee);
}
