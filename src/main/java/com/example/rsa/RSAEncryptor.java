package com.example.rsa;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;



public class RSAEncryptor {

    public byte[] encryptMasterKeyWithRsa(String masterKey, PublicKey publicKey) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        //paso la mk a bytes porque el cipher solo acepta ese formato
        byte[] masterKeyBytes = masterKey.getBytes(StandardCharsets.US_ASCII);
        byte[] encryptedMasterKeyBytes = cipher.doFinal(masterKeyBytes);
        return encryptedMasterKeyBytes;
    }



    public String decodeMasterKeyWithRsa(byte[] encryptedMasterKeyBytes, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedMasterKeyBytes = decryptCipher.doFinal(encryptedMasterKeyBytes);
        String decodedMasterKey = new String(decodedMasterKeyBytes, StandardCharsets.US_ASCII);
        return decodedMasterKey;
    }



}
