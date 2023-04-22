package com.hdfc.employee.controller;

import com.hdfc.employee.entity.Employee;
import com.hdfc.employee.exception.EmployeeNotFound;
import com.hdfc.employee.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee-management")
public class EmployeeRestController {

    Logger logger= LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    IEmployeeService service;
    @GetMapping("/get-employee-by-Id/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFound {
      logger.trace("Entering getEmployeeById() method.");
      logger.debug("Checking the Employee With employeeId provided:-"+employeeId);
    if(service.existBYId(employeeId)) {

        logger.info("Employee Info Delivered.");
        return service.getEmployeeInfoById(employeeId);

    }else {

        logger.error("Employee not Found with employeeId "+employeeId +" EmployeeNotFound Exception Thrown.");

        throw new EmployeeNotFound();
    }




    }
}
