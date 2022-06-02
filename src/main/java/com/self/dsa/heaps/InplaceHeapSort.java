package com.self.dsa.heaps;

public class InplaceHeapSort {
    public static void inplaceHeapSort(int arr[]) {

        int n = arr.length;

        for(int i=1; i < n; i++) {
            heapify(arr, 0, i);
        }


        removeFromHeap(arr, n);
    }

    private static void removeFromHeap(int[] arr, int n) {

        for(int i = n-1; i > 0; i--) {
            swap(arr, 0, i);
            removeFromHeap(arr, 0, i - 1);
        }
    }

    private static void removeFromHeap(int[] arr, int si, int ei) {
        int parentIndex = si;
        int leftChildIndex = 2*si + 1;
        int rightChildIndex = 2*si + 2;

        while(leftChildIndex <= ei) {

            int leftChild = arr[leftChildIndex];
            int rightChild = rightChildIndex <= ei ? arr[rightChildIndex]: Integer.MAX_VALUE;

            int minChildIndex = leftChildIndex;
            if(rightChild < arr[minChildIndex])
                minChildIndex = rightChildIndex;

            if(arr[parentIndex] < arr[minChildIndex])
                break;

            swap(arr, parentIndex, minChildIndex);
            parentIndex = minChildIndex;

            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
    }

    private static void heapify(int[] arr, int si, int ei) {
        int childIndex = ei;
        int parentIndex = (ei - 1)/2;

        while(childIndex > si) {

            parentIndex = (childIndex - 1)/2;
            if(arr[parentIndex] < arr[childIndex])
                break;

            swap(arr, parentIndex, childIndex);
            childIndex = parentIndex;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
