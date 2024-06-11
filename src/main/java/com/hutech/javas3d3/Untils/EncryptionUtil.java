package com.hutech.javas3d3.Untils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class EncryptionUtil {
//  DES
//  private static final String ALGORITHM = "DES";
//  private static final byte[] SECRET_KEY = "12345678".getBytes(); // 8 bytes key
//  3DES
    private static final String ALGORITHM = "DESede";
    private static final byte[] SECRET_KEY = "123456789123456789123456".getBytes(); // 24 bytes key

    public static String encrypt(String data) throws GeneralSecurityException {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws GeneralSecurityException {
        SecretKey key = new SecretKeySpec(SECRET_KEY, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
}