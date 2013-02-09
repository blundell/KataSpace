package com.blundell.kata.pragprog.two;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * 
 * @author Blundell
 *
 */
public class BinarySearchOne {

	public static void main(String[] args) {
		int target = 3;
		int[] haystack = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		int result = search(target, haystack);

		System.out.println("Found: " + result);
	}

	public static int search(int target, int[] haystack) {

		int originalLength = haystack.length;
		for (int x = 0; x < originalLength; x++) {
			System.out.println("Searching For Needle " + target + " in Haystack");
			print(haystack);
			int size = haystack.length;
			int halfwayPoint = size / 2;
			int valueUnderTest = haystack[halfwayPoint];
			System.out.println("Chopped at : " + halfwayPoint + " Found value: " + valueUnderTest);
			if (target < valueUnderTest) {
				System.out.println("Needle is less than chop value: " + valueUnderTest);
				int[] newChopHaystack = new int[halfwayPoint];
				int newSize = newChopHaystack.length;
				//int newHalfwayPoint = newSize / 2;
				for (int i = 0; i < newSize; i++) {
					newChopHaystack[i] = haystack[i];
				}
				haystack = newChopHaystack;
			} else if (target > valueUnderTest) {
				System.out.println("Needle is greater than chop value: " + valueUnderTest);
				int[] newChopHaystack = new int[halfwayPoint];
				int newSize = newChopHaystack.length;
				int newHalfwayPoint = newSize / 2;
				for (int i = 0; i < newSize; i++) {
					newChopHaystack[i] = haystack[i + newHalfwayPoint];
				}
				haystack = newChopHaystack;
			} else {
				System.out.println("Needle is chop value. Needed " + (x + 1) + " iterations");
				return valueUnderTest;
			}
		}

		return -1;
	}

	private static void print(int[] in) {
		System.out.print("[");
		for (int i = 0; i < in.length; i++) {
			System.out.print(" " + in[i] + " ");
		}
		System.out.println("]");
	}
}
