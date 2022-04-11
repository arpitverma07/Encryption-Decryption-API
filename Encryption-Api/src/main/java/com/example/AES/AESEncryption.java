package com.example.AES;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class AESEncryption {
	private static final String ALGO = "AES";
    private static final int KEYSZ = 256;// 128 default; 192 and 256 also possible

    private SecretKey secretKey;
    private File file_key = new File("key");
    
    public SecretKey loadKey() throws IOException
    {

        byte[] encoded = Files.readAllBytes(file_key.toPath());;
        SecretKey key = new SecretKeySpec(encoded, ALGO);
        return key;
    }


    public String encrypt(String algorithm, String input, SecretKey key,
                                 IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }
    
    
    public String encrypted(String message) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, IOException {
    	secretKey = loadKey();
//    	System.out.println(secretKey);
    	String input = message;
        IvParameterSpec ivParameterSpec = new IvParameterSpec("1234567812345678".getBytes());
        String algorithm = "AES/CBC/PKCS5Padding";
        return encrypt(algorithm , input , secretKey , ivParameterSpec);
        
    	
    }


}
