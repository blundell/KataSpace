package com.blundell.kata.careercup;

/**
 * Write a program to sum two binary numbers represented as strings.
 * Input: "110", "01101"
 * Output: "10011"
 * Method signature:
 * public String addBinaryNumbers(String num1, String num2);
 *
 */
public class BinarySum {

	private static final int[] binaryValues = { 1, 2, 4, 8, 16, 32, 64, 128 };

	public static void main(String[] args) {

		String num1 = "110";
		String num2 = "01101";
		System.out.println("Add " + num1 + " to " + num2);

		String answer = addBinaryNumbers(num1, num2);

		System.out.println("Answer: " + answer);
	}

	private static String addBinaryNumbers(String num1, String num2) {
		char[] charNum1 = num1.toCharArray();
		char[] charNum2 = num2.toCharArray();

		int intAnswer = addBinaryNumbers(charNum1, charNum2);

		String binaryAnswer = convertToBinaryString(intAnswer);

		return binaryAnswer;
	}

	private static int addBinaryNumbers(char[] num1, char[] num2) {

		int totalNum1 = toBinaryValue(num1);
		int totalNum2 = toBinaryValue(num2);

		System.out.println("Add " + totalNum1 + " to " + totalNum2);
		int total = totalNum1 + totalNum2;
		System.out.println("Answer: " + total);
		return total;
	}

	private static int toBinaryValue(char[] num) {
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[(num.length - 1) - i] == '1') {
				total += binaryValues[i];
			}
		}
		return total;
	}

	private static String convertToBinaryString(int value) {
		StringBuilder binaryString = new StringBuilder();
		for (int i = binaryValues.length - 1; i >= 0; i--) {
			int binaryValue = binaryValues[i];

			if ((value - binaryValue) >= 0) {
				value -= binaryValue;
				binaryString.append("1");
			} else {
				binaryString.append("0");
			}
		}
		return binaryString.toString();
	}

}
