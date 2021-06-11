package com.self.dsa.sorting;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

	public static void mergeSort(int[] input) {

		int[] sorted = mergeSortArray(input);
		for (int i = 0; i < input.length; i++) {
			input[i] = sorted[i];
		}
	}

	public static int[] mergeSortArray(int[] input) {

		int start = 0;
		int end = input.length - 1;

		if (Math.abs(start - end) < 1)
			return input;

		int mid = (start + end) / 2;

		int firstLength = (mid + 1) - start;
		int secondLength = end - mid;

		int[] s1 = new int[firstLength];
		for (int i = start, j = 0; i <= mid; i++) {
			s1[j++] = input[i];
		}

		int[] s2 = new int[secondLength];
		for (int i = mid + 1, j = 0; i <= end; i++) {
			s2[j++] = input[i];
		}

		s1 = mergeSortArray(s1);
		s2 = mergeSortArray(s2);

		int[] merged = merge(s1, s2);
		return merged;

	}

	public static int[] merge(int[] s1, int[] s2) {

		List<Integer> mergedArray = new ArrayList<>();
		int firstPointer = 0;
		int secondPointer = 0;

		int maxLength = s1.length + s2.length;

		for (int i = 0; i < maxLength; i++) {
			int first = firstPointer < s1.length ? s1[firstPointer] : Integer.MAX_VALUE;
			int second = secondPointer < s2.length ? s2[secondPointer] : Integer.MAX_VALUE;

			if (first <= second) {
				mergedArray.add(first);
				firstPointer++;
			} else {
				mergedArray.add(second);
				secondPointer++;
			}
		}
		if (firstPointer < s1.length) {
			for (int i = firstPointer; i < s1.length; i++)
				mergedArray.add(s1[i]);
		}
		if (secondPointer < s2.length) {
			for (int i = secondPointer; i < s2.length; i++)
				mergedArray.add(s2[i]);
		}

		int[] merged = new int[mergedArray.size()];
		for (int i = 0; i < merged.length; i++) {
			merged[i] = mergedArray.get(i);
		}
		return merged;

	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

	}
}
