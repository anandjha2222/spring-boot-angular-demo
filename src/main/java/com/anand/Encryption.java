package com.anand;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

	private static Key secretKey;
	
	public static void setKey(String myKey){
	    try {
			secretKey = new SecretKeySpec(myKey.getBytes("UTF-8"),"AES" );
	    }
	    catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	}
	
	public static String encrypt(String strToEncrypt, String secret)
	{
	    try
	    {
	        setKey(secret);
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while encrypting: " + e.toString());
	    }
	    return null;
	}

	public static String decrypt(String strToDecrypt, String secret)
	{
	    try
	    {
	        setKey(secret);
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while decrypting: " + e.toString());
	    }
	    return null;
	}
}
