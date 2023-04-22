package com.hdfc.employee.service;

import com.hdfc.employee.entity.Employee;
import com.hdfc.employee.exception.EmployeeNotFound;
import com.hdfc.employee.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    IEmployeeRepository repo;


    @Override
    public Employee getEmployeeInfoById(int employeeId) {
        return repo.findById(employeeId).orElse(null);
    }

    @Override
    public boolean existBYId(int employeeId) {
        return repo.existsById(employeeId);
    }
}
