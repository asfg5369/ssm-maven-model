/*
 *Java基本类型与byte数组之间相互转换
 */
package com.ssm.utils;

import java.nio.charset.Charset;

/**
 * 
 * @author 姜亮
 */
public class ByteUtils {
	/**
	 * 自己的byte[]转int
	 * 
	 * @param bys
	 *            字节数组
	 * @param start
	 *            需要转换的开始索引位数
	 * @param len
	 *            需要转换的字节数量
	 * @return
	 */
	public static int bytes2IntBE(byte[] bys, int start, int len) {
		return bytes2Int(bys, start, len, true);
	}

	private static int bytes2Int(byte[] bys, int start, int len,
			boolean isBigEndian) {
		int n = 0;
		for (int i = start, k = start + len % (Integer.SIZE / Byte.SIZE + 1); i < k; i++) {
			n |= (bys[i] & 0xff) << ((isBigEndian ? (k - i - 1) : i) * Byte.SIZE);
		}
		return n;
	}

	 /**
     * 从一个byte[]数组中截取一部分
     * @param src
     * @param begin
     * @param count
     * @return
     */
    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        for (int i=begin;i<begin+count; i++) bs[i-begin] = src[i];
        return bs;
    }

	/**
	 * short转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(short data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data & 0xff00) >> 8);
		return bytes;
	}

	/**
	 * char转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(char data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data);
		bytes[1] = (byte) (data >> 8);
		return bytes;
	}

	/**
	 * int转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(int data) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data & 0xff00) >> 8);
		bytes[2] = (byte) ((data & 0xff0000) >> 16);
		bytes[3] = (byte) ((data & 0xff000000) >> 24);
		return bytes;
	}

	/**
	 * long转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(long data) {
		byte[] bytes = new byte[8];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data >> 8) & 0xff);
		bytes[2] = (byte) ((data >> 16) & 0xff);
		bytes[3] = (byte) ((data >> 24) & 0xff);
		bytes[4] = (byte) ((data >> 32) & 0xff);
		bytes[5] = (byte) ((data >> 40) & 0xff);
		bytes[6] = (byte) ((data >> 48) & 0xff);
		bytes[7] = (byte) ((data >> 56) & 0xff);
		return bytes;
	}

	/**
	 * float转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(float data) {
		int intBits = Float.floatToIntBits(data);
		return getBytes(intBits);
	}

	/**
	 * double转byte
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] getBytes(double data) {
		long intBits = Double.doubleToLongBits(data);
		return getBytes(intBits);
	}

	public static byte[] getBytes(String data, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return data.getBytes(charset);
	}

	public static byte[] getBytes(String data) {
		return getBytes(data, "GBK");
	}

	/**
	 * byte[]转short
	 * 
	 * @param bytes
	 * @return
	 */
	public static short getShort(byte[] bytes) {
		return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	}

	/**
	 * byte[]转char
	 * 
	 * @param bytes
	 * @return
	 */
	public static char getChar(byte[] bytes) {
		return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	}

	public static int getInt_3(byte[] bytes) {
		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8))
				| (0xff0000 & (bytes[2] << 16));
	}

	/**
	 * byte[]转int
	 * 
	 * @param bytes
	 * @return
	 */
	public static int getInt(byte[] bytes) {
		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8))
				| (0xff0000 & (bytes[2] << 16))
				| (0xff000000 & (bytes[3] << 24));
	}

	/**
	 * byte[]转long
	 * 
	 * @param bytes
	 * @return
	 */
	public static long getLong(byte[] bytes) {
		return (0xffL & (long) bytes[0]) | (0xff00L & ((long) bytes[1] << 8))
				| (0xff0000L & ((long) bytes[2] << 16))
				| (0xff000000L & ((long) bytes[3] << 24))
				| (0xff00000000L & ((long) bytes[4] << 32))
				| (0xff0000000000L & ((long) bytes[5] << 40))
				| (0xff000000000000L & ((long) bytes[6] << 48))
				| (0xff00000000000000L & ((long) bytes[7] << 56));
	}
/**
 * byte[]转float
 * @param bytes
 * @return
 */
	public static float getFloat(byte[] bytes) {
		return Float.intBitsToFloat(getInt(bytes));
	}

	/**
	 * byte[]转double
	 * 
	 * @param bytes
	 * @return
	 */
	public static double getDouble(byte[] bytes) {
		long l = getLong(bytes);
		System.out.println(l);
		return Double.longBitsToDouble(l);
	}

	public static String getString(byte[] bytes, String charsetName) {
		return new String(bytes, Charset.forName(charsetName));
	}

	/**
	 * byte[]转string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String getString(byte[] bytes) {
		return getString(bytes, "GBK");
	}
}
