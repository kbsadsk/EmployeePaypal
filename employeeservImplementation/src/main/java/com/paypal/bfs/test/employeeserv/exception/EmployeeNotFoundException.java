package com.paypal.bfs.test.employeeserv.exception;

/**
 * Exception when Employee not present within our system.
 */
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    public EmployeeNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
