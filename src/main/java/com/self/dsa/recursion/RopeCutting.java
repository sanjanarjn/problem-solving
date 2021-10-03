package com.self.dsa.recursion;

public class RopeCutting {

    private static int maximumPieces(int n, int a, int b, int c) {

        if (n < 0)
            return -1;

        if (n == 0)
            return 0;

        int maxA = maximumPieces(n - a, a, b, c);
        int maxB = maximumPieces(n - b, a, b, c);
        int maxC = maximumPieces(n - c, a, b, c);

        int max = Math.max(maxA, Math.max(maxB, maxC));
        if(max == -1) {
            return -1;
        }
        return 1 + max;
    }

    public static void main(String[] args) {


    }
}
