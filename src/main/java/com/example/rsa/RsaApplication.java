package com.example.rsa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;

@SpringBootApplication
public class RsaApplication {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(RsaApplication.class, args);



		//escribo una masterkey
		String masterKey = "milanesas napolitanas con pure";
		System.out.println("MASTER KEY A ENCRIPTAR: "+ masterKey);

		//RSAKeys rsaKeys = new RSAKeys();
		RSAEncryptor rsaEncryptor = new RSAEncryptor();

		/*/guardo la public key en un archivo
		try (FileOutputStream fos = new FileOutputStream("public.key")) {
			fos.write(rsaKeys.getPublicKey().getEncoded());

		} catch (IOException e) {
			e.printStackTrace();
		}


		//guardo la private key en otro archivo
		try (FileOutputStream fos = new FileOutputStream("private.key")) {
			fos.write(rsaKeys.getPrivateKey().getEncoded());
		} catch (IOException e) {
			e.printStackTrace();
		} */





		//obtengo las keys de los archivos

		PrivateKey privateKey = PrivateKeyReader.get("private.key");
		System.out.println(privateKey.getFormat());
		PublicKey publicKey = PublicKeyReader.get("public.key");
		System.out.println(publicKey.getFormat());

		//TODO AVERIGUAR EN QUE FORMATO ESTAN LOS ARCHIVOS DE LAS KEYS



		//encripto la master key
		byte[] encodedMK = rsaEncryptor.encryptMasterKeyWithRsa(masterKey, publicKey);
		//la masterkey encriptada la paso a ASCII para mandarla por la api rest
		String masterKeyInASCII = rsaEncryptor.bytesToASCIIConverter(encodedMK);

		System.out.println("MASTERKEY EN ASCII");
		System.out.println(masterKeyInASCII);
		System.out.println("-----------------------------------");

		//descrifro la master key
		String decodedMK = rsaEncryptor.decodeMasterKeyWithRsa(encodedMK, privateKey);
		System.out.println("MASTER KEY DESENCRIPTADA:"+decodedMK);

		//decodedMK should be equal to masterKey








	}

}
