package com.hdfc.employee.controller;

import com.hdfc.employee.dto.EmployeeDto;
import com.hdfc.employee.entity.Employee;
import com.hdfc.employee.exception.EmployeeNotFound;
import com.hdfc.employee.service.IEmployeeService;
import com.hdfc.employee.vo.EmployeeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/employee-management")
public class EmployeeRestController {

    Logger logger= LoggerFactory.getLogger(EmployeeRestController.class);
    @Autowired
    IEmployeeService service;
    @GetMapping("/get-employee-by-Id/{employeeId}")
    public EmployeeVo getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFound {
      logger.trace("Entering getEmployeeById() method.");
      logger.debug("Checking the Employee With employeeId provided:-"+employeeId);
    if(service.existBYId(employeeId)) {

        logger.info("Employee Info Delivered.");
        Employee employee= service.getEmployeeInfoById(employeeId);
//        EmployeeDto employeeDto=new EmployeeDto();
//        employeeDto.setEmployeeId(employee.getEmployeeId());
//        employeeDto.setEmployeeName(employee.getEmployeeName());
//        String encryptedDate=service.convertToEncryptForm(employee.getDateOfBirth());
//        employeeDto.setDateOfBirth(LocalDate.parse(encryptedDate));
//
//        return employeeDto;

        EmployeeVo employeeVo=new EmployeeVo();
        employeeVo.setEmployeeId(employee.getEmployeeId());
        employeeVo.setEmployeeName(employee.getEmployeeName());
        String encryptedDate=service.convertToEncryptForm(employee.getDateOfBirth());
        employeeVo.setDateOfBirth(encryptedDate);

        return employeeVo;

    }else {

        logger.error("Employee not Found with employeeId "+employeeId +" EmployeeNotFound Exception Thrown.");

        throw new EmployeeNotFound();
    }




    }
}
