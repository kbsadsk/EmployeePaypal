package com.paypal.bfs.test.employeeserv.service.impl;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.exception.EmployeeInvalidRequest;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeEntityMapper;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to interact with DB
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(String id) throws EmployeeNotFoundException {
        log.debug("Finding an employee with id {}", id);
        EmployeeEntity employeeEntity = employeeRepository.findById(Integer.valueOf(id)).orElseThrow(() ->
                new EmployeeNotFoundException(String.format("Employee with id %s does not exist", id)));
        return EmployeeEntityMapper.toDto(employeeEntity);
    }

    @Override
    public Employee create(Employee employee) {
        // Validate employee request
        if (employee.getFirstName() == null || employee.getLastName() == null || employee.getDateOfBirth() == null) {
            throw new EmployeeInvalidRequest("Mandatory fields are missing");
        }
        EmployeeEntity employeeEntity = employeeRepository.findByFirstNameAndLastNameAndDateOfBirth(employee.getFirstName(), employee.getLastName(), employee.getDateOfBirth());
        // if employee exist return same employee
        if (employeeEntity != null) {
            return EmployeeEntityMapper.toDto(employeeEntity);
        }
        return EmployeeEntityMapper.toDto(employeeRepository.save(EmployeeEntityMapper.toDao(employee)));
    }
}
