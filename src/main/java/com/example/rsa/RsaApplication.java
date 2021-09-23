package com.example.rsa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.*;


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




		//encripto la master key como un array de bytes en ascii
		byte[] encodedMK = rsaEncryptor.encryptMasterKeyWithRsa(masterKey, publicKey);


		System.out.println("MASTERKEY EN ASCII");
		System.out.println(encodedMK);
		System.out.println("-----------------------------------");


		//descrifro la master key
		String decodedMK = rsaEncryptor.decodeMasterKeyWithRsa(encodedMK, privateKey);
		System.out.println("MASTER KEY DESENCRIPTADA:"+decodedMK);

		//decodedMK should be equal to masterKey








	}

}
