package com.paypal.bfs.test.employeeserv.advice;

import com.paypal.bfs.test.employeeserv.exception.EmployeeInvalidRequest;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ServiceErrorResponse> handleNotFound(RuntimeException ex) {
        log.error("Not found exception: {}", ex.getMessage());
        ServiceErrorResponse errorResp = new ServiceErrorResponse(HttpStatus.NOT_FOUND,
                ex.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ServiceErrorResponse> handleValidationError(MethodArgumentNotValidException exception) {
        log.error("Not valid request: {}", exception.getMessage());
        ServiceErrorResponse errorResp = new ServiceErrorResponse(HttpStatus.BAD_REQUEST,
                exception.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeInvalidRequest.class)
    public ResponseEntity<ServiceErrorResponse> handleInvalidRequest(RuntimeException ex) {
        log.error("Invalid Request: {}", ex.getMessage());
        ServiceErrorResponse errorResp = new ServiceErrorResponse(HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return new ResponseEntity<>(errorResp, HttpStatus.BAD_REQUEST);
    }

    // Generic Exception Handler
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ServiceErrorResponse> handleUnexpectedError(Throwable th) {
        log.error("Unexpected error occurred", th);
        ServiceErrorResponse errorResponse = new ServiceErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "Unexpected Error Occurred");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    @AllArgsConstructor
    @Setter
    @Getter
    private static class ServiceErrorResponse {
        private Integer statusCode;
        private String message;

        public ServiceErrorResponse(HttpStatus status, String message) {
            this.message = message;
            this.statusCode = status.value();
        }
    }

}
