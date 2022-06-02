package com.self.dsa.heaps;

public class CheckIfMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {

        return isMaxHeap(arr, 0);
    }

    private static boolean isMaxHeap(int[] arr, int parentIndex) {

        int n = arr.length;
        if(parentIndex >= n - 1)
            return true;

        int leftchildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        int parent = arr[parentIndex];

        int leftChild = leftchildIndex < n ? arr[leftchildIndex] : Integer.MIN_VALUE;
        int rightChild = rightChildIndex < n ? arr[rightChildIndex] : Integer.MIN_VALUE;

        boolean isMaxHeap = parent > leftChild && parent > rightChild;

        return isMaxHeap && isMaxHeap(arr, leftchildIndex) && isMaxHeap(arr, rightChildIndex);

    }
}
