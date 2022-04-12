package com.example.DecryptionAES;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class AESDecryption {
	
	private File file_key = new File("../Encryption-Api/key");
	private static final String ALGO = "AES";
	
	
  public SecretKey loadKey() throws IOException
  {

      byte[] encoded = Files.readAllBytes(file_key.toPath());;
      SecretKey key = new SecretKeySpec(encoded, ALGO);
      return key;
  }
	
	
  public String decrypt(String algorithm, String cipherText, SecretKey key,
	IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
	InvalidAlgorithmParameterException, InvalidKeyException,
	BadPaddingException, IllegalBlockSizeException {
	
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder()
		.decode(cipherText));
		return new String(plainText);
	}
  
  public String decrypted(String message) throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException {
	  SecretKey key = loadKey();
//	  System.out.println(key);
	  String input = message;
      IvParameterSpec ivParameterSpec = new IvParameterSpec("1234567812345678".getBytes());
      String algorithm = "AES/CBC/PKCS5Padding";
      System.out.println(decrypt(algorithm , input , key , ivParameterSpec));
      return decrypt(algorithm , input , key , ivParameterSpec);
      
  }
  

}
