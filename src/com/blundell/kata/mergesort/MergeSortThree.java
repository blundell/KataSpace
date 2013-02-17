package com.blundell.kata.mergesort;

import com.blundell.kata.LogUtils;

public class MergeSortThree {

	public static void main(String[] args) {

		int[] input = LogUtils.createRandomIntArrayOfSize(100);
		System.out.println("Input");
		LogUtils.print(input);

		new MergeSort(input).sort();

		System.out.println("Output");
		LogUtils.print(input);

	}

	private static class MergeSort {
		private final int[] numbers;
		private final int[] helper;
		private final int number;

		public MergeSort(int[] numbers) {
			this.numbers = numbers;
			this.number = numbers.length;
			this.helper = new int[number];
		}

		public void sort() {
			mergeSort(0, number - 1);
		}

		private void mergeSort(int low, int high) {
			if (low < high) {
				int middle = low + (high - low) / 2;
				mergeSort(low, middle); // Left
				mergeSort(middle + 1, high); // Right
				merge(low, middle, high);
			}
		}

		private void merge(int low, int middle, int high) {
			for (int i = 0; i <= high; i++) {
				helper[i] = numbers[i];
			}

			int lowIndex = low;
			int highIndex = middle + 1;
			int helperIndex = low;

			while (lowIndex <= middle && highIndex <= high) {
				if (helper[lowIndex] <= helper[highIndex]) {
					numbers[helperIndex] = helper[lowIndex];
					lowIndex++;
				} else {
					numbers[helperIndex] = helper[highIndex];
					highIndex++;
				}
				helperIndex++;
			}

			while (lowIndex <= middle) {
				numbers[helperIndex] = helper[lowIndex];
				helperIndex++;
				lowIndex++;
			}
		}
	}
}
