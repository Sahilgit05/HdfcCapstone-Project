package com.hdfc.EmployeewebClient.service;

import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.time.LocalDate;
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
    @Override
    public LocalDate convertToEntityForm(String encryptDate) throws GeneralSecurityException {
        if(encryptDate == null)
            return  null;
        initCipher(Cipher.DECRYPT_MODE);
        byte[] bytesArr= getCipher().doFinal(Base64.getDecoder().decode(encryptDate));
        return (LocalDate) SerializationUtils.deserialize(bytesArr);

    }
}
