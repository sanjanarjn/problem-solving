package com.self.dsa.dp;

import java.util.HashMap;

/*

Byteland has a very strange monetary system.
Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?

 */
public class ByteLandian {

    public static long bytelandian(long n, HashMap<Long, Long> memo) {

        if(n <= 1)
            return n;

        if(memo.get(n) != null)
        {
            return memo.get(n);
        }

        long breakDownValue = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);
        memo.put(n, Math.max(n, breakDownValue));


        return memo.get(n);
    }

}
