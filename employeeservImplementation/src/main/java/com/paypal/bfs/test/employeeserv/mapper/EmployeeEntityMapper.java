package com.paypal.bfs.test.employeeserv.mapper;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeEntity;

/**
 * Utility class to convert DAO object to DTOs
 */
public class EmployeeEntityMapper {
    public static Employee toDto(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setDateOfBirth(employeeEntity.getDateOfBirth());
        employee.setId(employeeEntity.getId());
        employee.setAddress(AddressEntityMapper.toDto(employeeEntity.getAddress()));
        return employee;
    }

    public static EmployeeEntity toDao(Employee employee) {
        if (employee == null) {
            return null;
        }

        return EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .dateOfBirth(employee.getDateOfBirth())
                .address(AddressEntityMapper.toDao(employee.getAddress()))
                .build();
    }
}
