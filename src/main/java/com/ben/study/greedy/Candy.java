package com.ben.study.greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] candyNum = new int[n];
        Arrays.fill(candyNum, 1);
        for (int i = 1; i < n; i++ ) {
            if (ratings[i] > ratings[i-1]) {
                candyNum[i] = candyNum[i-1] + 1;
            }
        }
        for (int i = n-1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candyNum[i-1] = Math.max(candyNum[i-1], candyNum[i] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += candyNum[i];
        }
        return res;
    }
}
