package com.example.rsa;

import java.nio.file.*;
import java.security.*;
import java.security.spec.*;

public class PrivateKeyReader{

    public static PrivateKey get(String fileName) throws Exception {

        byte[] keyBytes = Files.readAllBytes(Paths.get(fileName));

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
