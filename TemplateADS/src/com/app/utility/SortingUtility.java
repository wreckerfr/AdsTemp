package com.app.utility;

public class SortingUtility {

	// An optimized version of Bubble Sort
	static void bubbleSort(int arr[], int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {

					// Swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// If no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	// Java program for implementation of Insertion Sort
	public class InsertionSort {
		/* Function to sort array using insertion sort */
		void sort(int arr[]) {
			int n = arr.length;
			for (int i = 1; i < n; ++i) {
				int key = arr[i];
				int j = i - 1;

				/*
				 * Move elements of arr[0..i-1], that are greater than key, to one position
				 * ahead of their current position
				 */
				while (j >= 0 && arr[j] > key) {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
				arr[j + 1] = key;
			}
		}

	}
	
	//Selection Sort 
	 void Selectionsort(int arr[])
	    {
	        int n = arr.length;

	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++)
	                if (arr[j] < arr[min_idx])
	                    min_idx = j;

	            // Swap the found minimum element with the first
	            // element
	            int temp = arr[min_idx];
	            arr[min_idx] = arr[i];
	            arr[i] = temp;
	        }
	    }
	 
	 
	
}
