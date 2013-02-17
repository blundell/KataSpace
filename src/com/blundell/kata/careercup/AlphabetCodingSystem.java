package com.blundell.kata.careercup;

/**
 * We have a coding system from alphabets to numbers where a=1, b=2, ...z=26. 
 * You are given a string of digits as an input. 
 * Write a function that will compute the number of valid interpretations of the input.
 * 
 * Here are some examples:
 * f('11') = 2 Actual interpretations: ('aa', 'k') 
 * f('111') = 3 Actual interpretations: ('aaa', 'ak', 'ka')
 * f('1111') = 5 Actual interpretations: ('aaaa', 'aka', 'aak', 'kk', 'kaa' )
 * 
 * FAIL
 *
 */
public class AlphabetCodingSystem {

	private static final char[] alphabet = {
			'0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {

		String input = "1111";

		printAlphabeticalInterpretation(input);

	}

	private static void printAlphabeticalInterpretation(String input) {
		char[] inputAsChars = input.toCharArray();

		for (int i = 0; i < inputAsChars.length; i++) {
			printSingle(inputAsChars, i);
		}

		System.out.print("\n");

		if (input.length() % 2 == 0) {
			for (int i = 0; i < input.length() / 2; i++) {
				printDouble(inputAsChars, i * 2);
			}
		}

		System.out.print("\n");
		printSingle(inputAsChars, 0);
		printSingle(inputAsChars, 1);
		printDouble(inputAsChars, 2);

		System.out.print("\n");
		printSingle(inputAsChars, 0);
		printDouble(inputAsChars, 1);
		printSingle(inputAsChars, 3);

		System.out.print("\n");
		printDouble(inputAsChars, 0);
		printSingle(inputAsChars, 2);
		printSingle(inputAsChars, 3);

	}

	private static void printDouble(char[] input, int index) {
		int twoDigitChar = input[index] + input[index + 1];
		int alphabetIndex = Character.getNumericValue(twoDigitChar);
		System.out.print(alphabet[alphabetIndex]);
	}

	private static void printSingle(char[] input, int index) {
		int alphabetIndex = Character.getNumericValue(input[index]);
		System.out.print(alphabet[alphabetIndex]);
	}
}
