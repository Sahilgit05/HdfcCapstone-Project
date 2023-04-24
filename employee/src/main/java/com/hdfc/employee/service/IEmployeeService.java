package com.hdfc.employee.service;

import com.hdfc.employee.entity.Employee;

public interface IEmployeeService {

    public Employee getEmployeeInfoById(int employeeId);

    public boolean existBYId(int employeeId);

    public String convertToEncryptForm(Object attribute);


}
