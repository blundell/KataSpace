package com.blundell.kata.pragprog.two;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * 
 * Iterative take 2
 * 
 * @author Blundell
 *
 */
public class BinarySearchTwo {

	private static int[] haystack = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private static int[] targets = new int[] { 0, 1, 3, 10, 11, 15, 20, 21 };

//	private static int[] targets = new int[] { 10 };

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

		int suspect = haystack[splitAt];

		for (int i = 0; i < haystack.length; i++) {
			if (needle == suspect) {
				return splitAt;
			} else if (needle > suspect) {
				start = splitAt + 1;
				//end = haystack.length;
				splitAt = start + ((end - start) / 2);

				if (splitAt >= haystack.length) {
					return -1;
				}

				suspect = haystack[splitAt];

			} else if (needle < suspect) {

				start = 0;
				end = splitAt - 1;
				splitAt = (end - start) / 2;

				if (splitAt < start) {
					return -1;
				}

				suspect = haystack[splitAt];

			}
		}

		return -1;
	}
}
