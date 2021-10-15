package com.ben.study.greedy;

public class Trade {
    public static void main(String[] args) {

    }

    public int moreMoney(int[] price) {
        int ans = 0;
        int size = price.length;
        for (int i = 0; i < size - 1; i++) {
            if (price[i+1] > price[i]) {
                ans += price[i+1] - price[i];
            }
        }
        return ans;
    }
}
