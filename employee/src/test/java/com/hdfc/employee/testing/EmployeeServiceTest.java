package com.hdfc.employee.testing;


import com.hdfc.employee.entity.Employee;
import com.hdfc.employee.service.EmployeeService;
import com.hdfc.employee.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {
   @Autowired
   IEmployeeService service;



    @Test
    void getEmployeeInfoById() {
        int employeeId=101;
        Employee employee=service.getEmployeeInfoById(101);
        assertNotNull(employee);
        assertEquals(employee.getEmployeeName(),"Sahil");

    }
}