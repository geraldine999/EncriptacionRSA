package com.example.rsa;

import lombok.Data;

import java.security.*;

@Data
public class RSAKeys {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSAKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = null;
        generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();

    }
}
