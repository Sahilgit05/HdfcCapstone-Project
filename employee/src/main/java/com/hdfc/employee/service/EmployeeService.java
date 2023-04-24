package com.hdfc.employee.service;

import com.hdfc.employee.entity.Employee;
import com.hdfc.employee.repository.IEmployeeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

@Service
public class EmployeeService implements IEmployeeService{

    private final String encryptionKey="this-is-test-key";
     private final String encryptionCipher="AES";

     private static Key key;
     private static Cipher cipher;

    private Key getKey() {
        if(key==null)
            key=new SecretKeySpec(encryptionKey.getBytes(),encryptionCipher);
        return key;
    }

    private Cipher getCipher() throws GeneralSecurityException {
        if(cipher == null)
            cipher= Cipher.getInstance(encryptionCipher);
        return cipher;
    }

    private void initCipher(int encryptMode) throws GeneralSecurityException {
        getCipher().init(encryptMode, getKey());
    }

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

    @SneakyThrows
    @Override
    public String convertToEncryptForm(Object attribute) {
        if(attribute == null)
            return  null;
        initCipher(Cipher.ENCRYPT_MODE);
        byte[] bytesArr= SerializationUtils.serialize(attribute);
        return Base64.getEncoder().encodeToString(getCipher().doFinal(bytesArr));

    }



}
