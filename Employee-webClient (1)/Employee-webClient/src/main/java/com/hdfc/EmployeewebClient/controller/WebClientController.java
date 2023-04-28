package com.hdfc.EmployeewebClient.controller;

import com.hdfc.EmployeewebClient.pojo.Employee;
import com.hdfc.EmployeewebClient.service.IEmployeeService;
import com.hdfc.EmployeewebClient.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.GeneralSecurityException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/webclient/Employee")
public class WebClientController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    IEmployeeService service;

    String baseUrl="https://127.0.0.1:53892/api/employee-management";

    @GetMapping("/get-employee-by-Id/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) throws GeneralSecurityException {

        EmployeeVo employeeVo=restTemplate.getForObject(baseUrl+"/get-employee-by-Id/"+employeeId,EmployeeVo.class);

        Employee employee=new Employee();
        employee.setEmployeeId(employeeVo.getEmployeeId());
        employee.setEmployeeName(employeeVo.getEmployeeName());
        LocalDate dateOfBirth=service.convertToEntityForm(employeeVo.getDateOfBirth());

        employee.setDateOfBirth(dateOfBirth);

        return employee;



    }
}
