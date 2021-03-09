package com.paypal.bfs.test.employeeserv.api;

import javax.validation.Valid;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

    /**
     * Creates {@link Employee} resource.
     *
     * @param employee {@link Employee}
     * @return
     */
    @RequestMapping("/v1/bfs/employees")
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody final Employee employee);
}
