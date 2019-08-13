package com.abbot.schimneylife.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class Md5Util {
	/**
	 * md5编码
	 * @param password
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeByMod5(String password,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		String str = encrypt(password,salt);
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
	public static boolean checkPassword(String newPassword,String salt,String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encodeByMod5(newPassword,salt).equals(oldPassword);
	}
	/**
	 * 根据盐值加密用户密码
	 * @param password
	 * @param salt
	 * @return
	 */
	private static String encrypt(String password,String salt) {
		char[] p = password.toCharArray();
		char[] s = salt.toCharArray();
		StringBuffer sp = new StringBuffer();
		int len = p.length/2;
		for(int i=0;i<len;i++) {
			sp.append((int)(p[i]<<1)|p[len+i]);
			if(i<salt.length()) {
				sp.append((int)(s[i]<<1));
			}
		}
		//如果是奇数则将最后一位放到末尾
		if(p.length%2!=0) {
			sp.append((int)p[p.length-1]);
		}
		return sp.toString();
	}
	/**
	 * 随机生成盐值
	 * @return
	 */
	public static String createSalt() {
		Random ranGen = new SecureRandom();
        byte[] aesKey = new byte[3];
        ranGen.nextBytes(aesKey);
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < aesKey.length; i++) {
            String hex = Integer.toHexString(0xff & aesKey[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
		return hexString.toString();
	}
}
