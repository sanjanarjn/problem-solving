package com.self.dsa.heaps;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<Integer>();
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {

        if(isEmpty())
            throw new PriorityQueueException();

        int n = heap.size();
        int min = heap.get(0);

        int lastElem = heap.get(n - 1);
        heap.set(0, lastElem);
        heap.remove(n -1);

        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;

        while(leftChildIndex < heap.size()) {

            int parent = heap.get(parentIndex);
            int leftChild = heap.get(leftChildIndex);
            int rightChild = rightChildIndex < heap.size() ? heap.get(rightChildIndex) : Integer.MAX_VALUE;

            int minChildIndex = leftChild < rightChild ? leftChildIndex : rightChildIndex;
            int minChild = heap.get(minChildIndex);

            if(parent > minChild) {
                swap(heap, parentIndex, minChildIndex);
                parentIndex = minChildIndex;
            }
            else {
                break;
            }
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        return min;
    }

    private void swap(List<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
