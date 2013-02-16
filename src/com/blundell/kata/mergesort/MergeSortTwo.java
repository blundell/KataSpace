package com.blundell.kata.mergesort;

import com.blundell.kata.LogUtils;

public class MergeSortTwo {

	public static void main(String[] args) {

		int[] input = LogUtils.createRandomIntArrayOfSize(6);
		System.out.println("Input array: ");
		LogUtils.print(input);
		sort(input);
		System.out.println("Sorted Array: ");
		LogUtils.print(input);
	}

	private static void sort(int[] input) {
		mergeSort(input, 0, input.length - 1);
	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int midPoint = (low + high) / 2;
			mergeSort(array, low, midPoint);
			mergeSort(array, midPoint + 1, high);
			merge(array, low, midPoint, high);
			LogUtils.print(array);
		}
	}

	private static void merge(int[] array, int low, int midpoint, int high) {
		int[] temp = new int[high - low + 1];
		int left = low;
		int right = midpoint + 1;
		int k = 0;

		while (left <= midpoint && right <= high) {
			if (array[left] < array[right]) {
				temp[k] = array[left];
				left++;
			} else {
				temp[k] = array[right];
				right++;
			}
			k++;
		}

		if (left <= midpoint) {
			while (left <= midpoint) {
				temp[k] = array[left];
				left++;
				k++;
			}
		} else if (right <= high) {
			while (right <= high) {
				temp[k] = array[right];
				right++;
				k++;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			array[low + i] = temp[i];
		}
	}

}
