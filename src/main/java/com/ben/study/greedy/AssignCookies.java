package com.ben.study.greedy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChild = g.length;
        int numOfCook = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChild && j < numOfCook; i++, j++) {
            //当饼干指针未移动到终点并且饼干的能量值小于第一名儿童的能量值的时候，饼干指针一直后移
            while (j < numOfCook && g[i] > s[j]) {
                j++;
            }
            //出现第一个饼干能量值大于孩子需要的，将其分配，然后孩子和饼干指针各后移以为
            //解决了一个孩子，数量加一
            if (j < numOfCook) {
                count++;
            }
        }
        return count;
    }
}
