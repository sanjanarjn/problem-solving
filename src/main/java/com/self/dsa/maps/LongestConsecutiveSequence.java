package com.self.dsa.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
 */
public class LongestConsecutiveSequence {

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int num : arr) {
            countMap.put(num, 1);
        }

        int index = 0;
        for(int num : arr) {
            indexMap.put(num, index++);
        }

        int start = arr[0];
        int end = arr[0];


        int firstElem = 0;
        int lastElem = 0;

        for(int num : arr) {
            if(countMap.containsKey(num)) {
                start = num;
                end = num;
                countMap.remove(num);

                boolean nextNumFound = true;
                while(nextNumFound) {
                    int left = start - 1;
                    int right = end + 1;

                    if(!countMap.containsKey(left) && !countMap.containsKey(right)) {
                        nextNumFound = false;
                    }

                    if(countMap.containsKey(left)) {
                        start = left;
                        countMap.remove(left);
                    }
                    if(countMap.containsKey(right)) {
                        end = right;
                        countMap.remove(right);
                    }
                }
                if((end - start) > (lastElem - firstElem)) {
                    firstElem = start;
                    lastElem = end;
                }
                else if((end - start) == (lastElem - firstElem) && (indexMap.getOrDefault(start, -1) < indexMap.getOrDefault(firstElem, -1))) {
                    firstElem = start;
                    lastElem = end;
                }
            }
        }
        ArrayList<Integer> longest = new ArrayList<>();
        longest.add(firstElem);
        longest.add(lastElem);
        return longest;

    }
}
