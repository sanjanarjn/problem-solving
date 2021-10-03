package com.self.dsa.recursion;

public class SumOfDigits {


    public static int getDigitSum(int n) {

        if (n == 0)
            return 0;

        int currentDigit = n % 10;
        int sum = currentDigit + getDigitSum(n/10);

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(getDigitSum(873));
    }

}
