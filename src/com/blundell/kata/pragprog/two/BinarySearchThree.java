package com.blundell.kata.pragprog.two;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * 
 * Recursive
 * 
 * @author Blundell
 *
 */
public class BinarySearchThree {

	private static int[] haystack = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private static int[] targets = new int[] { 0, 1, 3, 10, 11, 15, 20, 21 };

//	private static int[] targets = new int[] { 3 };

	public static void main(String[] args) {
		for (int i = 0; i < targets.length; i++) {
			int target = targets[i];
			System.out.println("Looking for: " + target);
			int result = search(target, haystack);
			System.out.println("Found at position: " + result);
			System.out.println("_______________________________");
		}
	}

	public static int search(int needle, int[] haystack) {
		int start = 0;
		int end = haystack.length;
		int splitAt = (end - start) / 2;

		return search(needle, haystack, start, end, splitAt);
	}

	private static int search(int needle, int[] haystack, int start, int end, int splitAt) {
		if (end < 0 || end > haystack.length) {
			return -1;
		}
		if (start < 0 || start >= haystack.length) {
			return -1;
		}

		int suspect = haystack[splitAt];

		if (needle == suspect) {
			return splitAt;
		} else if (needle > suspect) {
			// check higher
			start = splitAt + 1;
			splitAt = start + ((end - start) / 2);
			return search(needle, haystack, start, end, splitAt);
		} else if (needle < suspect) {
			// check lower
			start = 0;
			end = splitAt - 1;
			splitAt = (end - start) / 2;
			return search(needle, haystack, start, end, splitAt);
		}
		return -1;
	}
}
