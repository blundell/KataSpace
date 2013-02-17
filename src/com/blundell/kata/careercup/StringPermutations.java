package com.blundell.kata.careercup;

/**
 * Print all the permutations of a given string.
 * 
 * 1) explain time\space complexity?
 * 2) how can you improve time\space complexity? 
 */
public class StringPermutations {

	public static void main(String[] args) {

		String given = "FooBar";

		char[] input = given.toCharArray();
		int start = 0;

		printChangingStartPermutation(input, start);
	}

	private static void printChangingStartPermutation(char[] word, int start) {
		int length = (word.length - start);

		if (start >= word.length || length == 0) {
			return;
		}

		System.out.println(new String(word, start, length));

		printChangingEndPermutation(word, start, length);

		printChangingStartPermutation(word, start + 1);
	}

	private static void printChangingEndPermutation(char[] word, int start, int length) {
		if (start >= word.length || length == 0) {
			return;
		}

		System.out.println(new String(word, start, length));

		printChangingEndPermutation(word, start, length - 1);
	}

}
