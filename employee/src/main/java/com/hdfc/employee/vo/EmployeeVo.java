package com.hdfc.employee.vo;

import java.time.LocalDate;

public class EmployeeVo {

    private int employeeId;

    private String employeeName;

    private String dateOfBirth;

    public EmployeeVo() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
