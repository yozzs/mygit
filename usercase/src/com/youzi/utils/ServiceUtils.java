package com.youzi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class ServiceUtils {

	public ServiceUtils() {
	}

	public static String md5(String message) {
		byte md5[];
		BASE64Encoder encoder;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			md5 = md.digest(message.getBytes());
			encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
		// NoSuchAlgorithmException e;
		// e;
		// throw new RuntimeException();
	}
}
