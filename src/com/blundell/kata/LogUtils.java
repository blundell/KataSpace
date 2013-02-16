package com.blundell.kata;

public class LogUtils {

	public static int[] createRandomIntArrayOfSize(int size) {
		int[] output = new int[size];
		for (int i = 0; i < size; i++) {
			output[i] = (int) (Math.random() * 100);
		}
		return output;
	}

	public static void print(int[] in) {
		System.out.print("[");
		for (int i = 0; i < in.length; i++) {
			System.out.print(" " + in[i] + " ");
		}
		System.out.println("]");
	}

}
