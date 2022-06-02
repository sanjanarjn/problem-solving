package com.self.dsa.recursion;

public class AllSubsets {
    public static int[][] subsets(int input[]) {
        int[][] subsets = subsets(input, 0);
       /* int[][] output = new int[subsets.length - 1][];
        for(int i = 0; i < subsets.length; i++) {
            if(subsets[i] != null)
            	output[i] = subsets[i];
        }*/
        return subsets;
    }

    private static int[][] subsets(int[] input, int si) {

        if(si >= input.length)
            return new int[1][0];

        int[][] withoutSubsets = subsets(input, si + 1);

        int length =  2 * withoutSubsets.length;
        int[][] subsets = new int[length][];

        int k = 0;
        int elem = input[si];
        for(int i = 0; i < withoutSubsets.length; i++) {
            int[] subset = i < withoutSubsets.length ? withoutSubsets[i] : null;
            int[] withSubset = new int[(subset != null ? subset.length+1 : 1)];
            withSubset[0] = elem;

            if(subset != null) {
                for(int j = 0; j< subset.length; j++)
                    withSubset[j+1] = subset[j];
            }
            if(withSubset != null)
                subsets[k++] = withSubset;
        }
        for(int i = 0; i < withoutSubsets.length; i++) {
            if(withoutSubsets[i] != null)
                subsets[k++] = withoutSubsets[i];
        }
        return subsets;
    }
}
