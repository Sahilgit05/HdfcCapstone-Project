package com.hdfc.EmployeewebClient.service;

import java.security.GeneralSecurityException;
import java.time.LocalDate;

public interface IEmployeeService {

    public LocalDate convertToEntityForm(String encryptDate) throws GeneralSecurityException;
}
