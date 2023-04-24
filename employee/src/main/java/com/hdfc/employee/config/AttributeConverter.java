//package com.hdfc.employee.config;
//
//import lombok.SneakyThrows;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.SerializationUtils;
//
//import javax.crypto.Cipher;
//import javax.crypto.NoSuchPaddingException;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.GeneralSecurityException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.Base64;
//
//@Configuration
//public class AttributeConverter implements javax.persistence.AttributeConverter<Object, String> {
//
//     private final String encryptionKey="encryption-key";
//     private final String encryptionCipher="AES";
//
//     private static Key key;
//     private static Cipher cipher;
//
//    private Key getKey() {
//        if(key==null)
//            key=new SecretKeySpec(encryptionKey.getBytes(),encryptionCipher);
//        return key;
//    }
//
//    private Cipher getCipher() throws GeneralSecurityException {
//        if(cipher == null)
//            cipher= Cipher.getInstance(encryptionCipher);
//        return cipher;
//    }
//
//    private void initCipher(int encryptMode) throws GeneralSecurityException {
//        getCipher().init(encryptMode, getKey());
//    }
//
//    @SneakyThrows
//    @Override
//    public String convertToDatabaseColumn(Object attribute) {
//        if(attribute == null)
//            return  null;
//        initCipher(Cipher.ENCRYPT_MODE);
//        byte[] bytesArr= SerializationUtils.serialize(attribute);
//        return Base64.getEncoder().encodeToString(getCipher().doFinal(bytesArr));
//
//    }
//
//
//
//    @SneakyThrows
//    @Override
//    public Object convertToEntityAttribute(String dbData) {
//        if(dbData == null)
//            return  null;
//        initCipher(Cipher.DECRYPT_MODE);
//        byte[] bytesArr= getCipher().doFinal(Base64.getDecoder().decode(dbData));
//        return SerializationUtils.deserialize(bytesArr);
//    }
//}
