
package com.self.dsa.sorting;

public class Quicksort {
	
	public static void quickSort(int[] input) {
		quickSort(input, 0, input.length-1);
		
	}
	
    public static void quickSort(int[] input, int si, int ei) {
        
        if(si >= ei) {
            return;
        }
        
        int pivotIndex = partition(input, si, ei);

        quickSort(input, si, pivotIndex-1);
        quickSort(input, pivotIndex+1, ei);
    }
    
    public static int partition(int[] input, int si, int ei) {
        
        int pivotIndex = ei;
        int pivot = input[pivotIndex];
    
        int i = si-1;
        
        for(int j = si; j < ei; j++) {
            if(input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i+1, pivotIndex);
        return i+1;
    }
               
    public static void swap(int[] a, int i, int j) {
       
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
