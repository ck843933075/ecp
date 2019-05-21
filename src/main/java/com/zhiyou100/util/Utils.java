package com.zhiyou100.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class Utils {
	public static void main(String[] args) throws Exception {
//		Tue Jan 15 15:10:22 CST 2019
		
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid :" +uuid);
		System.out.println(new Date());
		System.out.println(new Date().getTime());
		
		System.out.println(MD5Util.getNewString("abc", "utf-8", true));
		
	}
}
