package com.blundell.kata.pragprog.two;

import static com.blundell.kata.LogUtils.print;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * 
 * @author Blundell
 *
 */
public class BinarySearchOne {

	private static int[] haystack = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
//	private static int[] targets = new int[] { 1, 3, 10, 11, 15, 20, 21 };

	private static int[] targets = new int[] { 20 };

	public static void main(String[] args) {
		for (int i = 0; i < targets.length; i++) {
			int target = targets[i];
			int result = search(target, haystack);
			System.out.println("Found at position: " + result);
			System.out.println("_______________________________");
		}
	}

	public static int search(int needle, int[] haystack) {
		for (int x = 0; x < haystack.length; x++) {
			System.out.println("Searching For Needle " + needle + " in Haystack");
			print(haystack);
			int size = haystack.length;

			if (size == 0) {
				System.out.println("Not Found");
				break;
			}

			int halfwayPoint = size / 2;
			int valueUnderTest = haystack[halfwayPoint];
			System.out.println("Chopped at position: " + halfwayPoint + " Found value: " + valueUnderTest);
			if (needle == valueUnderTest) {
				System.out.println("Needle is chop value. Needed " + (x + 1) + " iterations");
				return halfwayPoint;
			} else if (needle < valueUnderTest) {
				System.out.println("Needle is less than chop value: " + valueUnderTest);
				int[] newChopHaystack = new int[halfwayPoint];
				for (int i = 0; i < halfwayPoint; i++) {
					newChopHaystack[i] = haystack[i];
				}
				haystack = newChopHaystack;
			} else if (needle > valueUnderTest) {
				System.out.println("Needle is greater than chop value: " + valueUnderTest);
				int[] newChopHaystack = new int[halfwayPoint - 1];
				for (int i = 0; i < halfwayPoint - 1; i++) {
					newChopHaystack[i] = haystack[(halfwayPoint + 1) + i];
				}
				haystack = newChopHaystack;
			}
		}
		return -1;
	}
}
