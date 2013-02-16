package com.blundell.kata.mergesort;

import com.blundell.kata.LogUtils;

public class MergeSortOne {

	public static void main(String[] args) {

		int[] items = LogUtils.createRandomIntArrayOfSize(100);

		System.out.println("Before sorting: ");
		LogUtils.print(items);

		items = mergeSort(items);

		System.out.println("After sorting: ");
		LogUtils.print(items);
	}

	private static int[] mergeSort(int[] input) {
		int size = input.length;
		if (size <= 1) {
			return input;
		}

		int midpoint = size / 2;

		int[] left = new int[midpoint];

		int[] right;
		if (size % 2 == 0) {
			right = new int[midpoint];
		} else {
			right = new int[midpoint + 1];
		}

		int[] result = new int[size];

		for (int i = 0; i < midpoint; i++) {
			left[i] = input[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = input[i + midpoint];
		}

		left = mergeSort(left);
		right = mergeSort(right);

		result = merge(left, right);

		return result;
	}

	private static int[] merge(int[] left, int[] right) {
		int lengthResult = left.length + right.length;
		int[] result = new int[lengthResult];
		int indexL = 0;
		int indexR = 0;
		int indexResult = 0;

		while (indexL < left.length || indexR < right.length) {
			if (indexL < left.length && indexR < right.length) {
				if (left[indexL] <= right[indexR]) {
					result[indexResult] = left[indexL];
					indexL++;
					indexResult++;
				} else {
					result[indexResult] = right[indexR];
					indexR++;
					indexResult++;
				}
			} else if (indexL < left.length) {
				result[indexResult] = left[indexL];
				indexL++;
				indexResult++;
			} else if (indexR < right.length) {
				result[indexResult] = right[indexR];
				indexR++;
				indexResult++;
			}
		}
		return result;
	}

}
