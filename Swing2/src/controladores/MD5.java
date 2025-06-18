package controladores;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5 {

	public static String Encripta(String password) {
		// Variables
		
		if (password==null||password=="") {
			password = "clave12345";
		}
		
		//System.out.println(password);
		
		String md5 = "";
		byte[] digest = null;

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
		md5 = DatatypeConverter.printHexBinary(digest);
		
		return md5;

	}
	
	
}
