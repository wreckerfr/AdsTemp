package com.app.utility;

public class BinarySearch {

	//Binary Search Without Recursion 
	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// Check if target is present at mid
			if (arr[mid] == target) {
				return mid;
			}

			// If target greater, ignore left half
			if (arr[mid] < target) {
				left = mid + 1;
			} else { // If target is smaller, ignore right half
				right = mid - 1;
			}
		}

		// Target not found
		return -1;
	}

	// Recursive binary search implementation
	public static int recursiveBinarySearch(int[] arr, int target, int left, int right) {
		if (left <= right) {
			int mid = left + (right - left) / 2;

			// Check if target is present at mid
			if (arr[mid] == target) {
				return mid;
			}

			// If target greater, ignore left half
			if (arr[mid] < target) {
				return recursiveBinarySearch(arr, target, mid + 1, right);
			} else { // If target is smaller, ignore right half
				return recursiveBinarySearch(arr, target, left, mid - 1);
			}
		}

		// Target not found
		return -1;
	}

}
