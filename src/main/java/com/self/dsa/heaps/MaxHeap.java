package com.self.dsa.heaps;

import java.util.List;
import java.util.ArrayList;

public class MaxHeap {
	
    List<Integer> heap;
    
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    
	boolean isEmpty() {
		return heap.isEmpty();
	}

	int getSize() {
		return heap.size();
	}

	int getMax() {
		return isEmpty() ? Integer.MIN_VALUE : heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
        
        int childIndex = heap.size() - 1;
        int parentIndex = (heap.size() - 1)/2;
        
        while(childIndex > 0) {
            
            parentIndex = (childIndex - 1)/2;
            
            int child = heap.get(childIndex);
            int parent = heap.get(parentIndex);
            
            if(parent < child) {
                heap.set(parentIndex, child);
                heap.set(childIndex, parent);
            }
            else {
                break;
            }
            childIndex = parentIndex;
        }
	}

	int removeMax() {
		int max = heap.get(0);
        
        int lastElem = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);
        heap.set(0, lastElem);
        
        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        
        while(leftChildIndex < heap.size()) {
        	int parent = heap.get(parentIndex);
            int leftChild = heap.get(leftChildIndex);
            int rightChild = rightChildIndex < heap.size() ? heap.get(rightChildIndex) : Integer.MIN_VALUE;
            
            int maxChildIndex = leftChildIndex;
            if(leftChild < rightChild) {
                maxChildIndex = rightChildIndex;
            }
            
            int maxChild = heap.get(maxChildIndex);
            if(parent < maxChild) {
                heap.set(parentIndex, maxChild);
                heap.set(maxChildIndex, parent);
                parentIndex = maxChildIndex;
            }
            else {
                break;
            }
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
            
                
        }
        
        return max;
        
	}
}