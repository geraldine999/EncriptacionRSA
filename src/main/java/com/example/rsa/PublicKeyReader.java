package com.example.rsa;

import java.nio.file.*;
import java.security.*;
import java.security.spec.*;

public class PublicKeyReader {

    public static PublicKey get(String fileName) throws Exception {

        byte[] keyBytes = Files.readAllBytes(Paths.get(fileName));

        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
}