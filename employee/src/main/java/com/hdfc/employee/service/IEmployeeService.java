package com.hdfc.employee.service;

import com.hdfc.employee.entity.Employee;

import java.util.Optional;

public interface IEmployeeService {

    public Employee getEmployeeInfoById(int employeeId);

    public boolean existBYId(int employeeId);
}
