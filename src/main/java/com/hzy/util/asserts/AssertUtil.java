package com.hzy.util.asserts;

/**
 * 
 */
public class AssertUtil {

	public static void asserts(boolean boo, String message) {
		if (!boo)
			throw new AssertException(message);
	}

	public static void asserts(boolean boo) {
		if (!boo)
			throw new AssertException();
	}

	public static void isZero(int num, String message) {
		asserts(num == 0, message);
	}

	public static void isZero(int num) {
		asserts(num == 0);
	}

	public static void notZero(int num, String message) {
		asserts(num != 0, message);
	}

	public static void notZero(int num) {
		asserts(num != 0);
	}

	public static void isNull(Object obj, String message) {
		asserts(obj == null, message);
	}

	public static void isNull(Object obj) {
		asserts(obj == null);
	}

	public static void notNull(Object obj, String message) {
		asserts(obj != null, message);
	}

	public static void notNull(Object obj) {
		asserts(obj != null);
	}
}
