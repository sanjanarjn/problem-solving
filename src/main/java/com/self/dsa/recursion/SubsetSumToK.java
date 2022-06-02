package com.self.dsa.recursion;

public class SubsetSumToK {
    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subsetsSumK(int input[], int k) {

        return subsets(input, k, 0);
    }
    private static int[][] subsets(int[] input, int k, int si) {

        if(k == 0)
            return new int[1][];

        if(si >= input.length)
            return new int[0][];

        if(k < 0)
            return new int[0][];

        int elem = input[si];
        int[][] withSubsets = subsets(input, k - elem, si+1);
        int[][] withoutSubsets = subsets(input, k, si+1);

        int[][] subsets = new int[withSubsets.length + withoutSubsets.length][];

        int index = 0;
        for(int i=0; i < withSubsets.length; i++) {
            int[] subset = withSubsets[i];

            int subsetLength = subset != null ?  subset.length + 1: 1;
            int[] withSubset = new int[subsetLength];
            withSubset[0] = elem;

            if(subset != null)
                for(int j = 0; j < subset.length; j++) {
                    withSubset[j+1] = subset[j];
                }
            subsets[index++] = withSubset;
        }
        for(int i=0; i < withoutSubsets.length; i++) {
            subsets[index++] = withoutSubsets[i];
        }
        return subsets;
    }
}
