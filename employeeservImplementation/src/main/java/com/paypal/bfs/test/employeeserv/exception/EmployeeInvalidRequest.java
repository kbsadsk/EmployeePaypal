package com.paypal.bfs.test.employeeserv.exception;

/**
 * Exception to represent bad request for employee
 */
public class EmployeeInvalidRequest extends RuntimeException {
    public EmployeeInvalidRequest(String msg) {
        super(msg);
    }

    public EmployeeInvalidRequest(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
