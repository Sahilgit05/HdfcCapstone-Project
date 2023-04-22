package com.hdfc.employee.globalException;

import com.hdfc.employee.exception.EmployeeNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<String> employeeWithIDNotFoundHandler(){

        return new ResponseEntity<String>("Invalid EmployeeID:-Please Enter Proper EmployeeId.", HttpStatus.NOT_FOUND);

    }
}
