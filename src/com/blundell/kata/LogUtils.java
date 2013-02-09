package com.blundell.kata;

public class LogUtils {

	public static void print(int[] in) {
		System.out.print("[");
		for (int i = 0; i < in.length; i++) {
			System.out.print(" " + in[i] + " ");
		}
		System.out.println("]");
	}

}
