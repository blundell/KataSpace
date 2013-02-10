package com.blundell.kata.pragprog.two;

import static com.blundell.kata.LogUtils.print;

/**
 * http://codekata.pragprog.com/2007/01/kata_two_karate.html
 * 
 * Functional?
 * 
 * This is a failed strategy, not only does it not work, it can't return the position in the original array the item was at
 * scrapped and started again
 * 
 * @author Blundell
 *
 */
public class BinarySearchOne {

	private static int[] haystack = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	private static int[] targets = new int[] { 1, 3, 10, 11, 15, 20, 21 };

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
		int size = end - start;

		for (int x = 0; x < haystack.length + 1; x++) {
			print(haystack);

			int splitAt = size / 2;
			int suspect = haystack[splitAt];

			if (needle == suspect) {
				return splitAt;
			} else if (needle > suspect) {
				System.out.println("Needle is greater than chop value: " + suspect);
				start = splitAt + 1;
				end = haystack.length;
				size = (end - start);
				int[] newSplitHaystack = new int[size];
				for (int i = 0; i < size; i++) {
					newSplitHaystack[i] = haystack[start + i];
				}
				haystack = newSplitHaystack;
			} else if (needle < suspect) {
				System.out.println("Needle is less than chop value: " + suspect);
				start = 0;
				end = splitAt;
				size = (end - start);
				int[] newChopHaystack = new int[size];
				for (int i = 0; i < size; i++) {
					newChopHaystack[i] = haystack[i];
				}
				haystack = newChopHaystack;
			}
		}
		return -1;
	}
}
