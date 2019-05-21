package com.zhiyou100.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	
	private static String [] md5arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

//	md5加密 boolean 表示是否全转大写
	public static String getNewString(String str , String encode , boolean uperLower) throws Exception{
		//按照MD5的加密方式得到一个文件的暂存管理器
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		
		// 将管理器更新为 传入的字符串的字节文件类型
		String newStr = str ;
		messageDigest.update(newStr.getBytes(encode));
		
		//将字节文件转换成字节文件数组,返回十六位
		newStr = byteArrayToHexString(messageDigest.digest());
		return uperLower ? newStr.toUpperCase() : newStr;
	}
	
	/**
	 * 将字节数组转换成string字符串
	 * @param bytes
	 * @return
	 * String
	 */
	 private static String byteArrayToHexString(byte[] bytes) {
	        StringBuilder stringBuilder = new StringBuilder();
	        for (byte tem : bytes) {
	            stringBuilder.append(byteToHexString(tem));
	        }
	        return stringBuilder.toString();
	    }

	    /**
	     * 转换byte到16进制
	     * 
	     * @param b
	     *            要转换的byte
	     * @return 16进制对应的字符
	     */
	    private static String byteToHexString(byte b) {
	        int n = b;
//	        字节内容从 -128~0~127   0~ 127 ~ 255
	        if (n < 0) {
	            n = 256 + n;
	        }
//	        十六位进制的 十位数上 肯定是 一个数  个位数上是余数 
//	        17    16进制的11 就相当于10进制的17
	        int d1 = n / 16;
	        int d2 = n % 16;
	        return md5arr[d1] + md5arr[d2];
	    }

	
}
