package com.ben.study.greedy;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    //给定一个数组，里面包含多个小数组，每个小数组都只有两个值，代表横坐标的位置
    //现在用箭射气球，一次可以穿破多个，只要重复的话，问最少射多少箭可以解决
    //一开始考虑按照最左标排序，但是问题在于，最左起始的这个区间可能和多个区间重合，但是多个区间之间并不一定重合
    //但是按照右端进行升序的话，拿当前区间的右端作为标杆，只要下一个的起始小于或者等于当前区间的右端，就可以继续往下走
    //当下一个的起始大于当前的右端，计数加一，然后将新区见的右端作为标杆继续往下走
    //todo 边界条件没有处理好 还有九个用例没有通过，输出3，应为4
    public static void main(String[] args) {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        findMinNumOfArow(points);
    }

    public static int findMinNumOfArow(int[][] points) {
        if (points.length == 0) {
        return 0;
    }
        if(points.length ==1) {
            return 1;
        }
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int count = 0;
        for(int i = 0; i < points.length-1;) {
            int right = points[i][1];
            while (i < points.length-1 && points[i+1][0] <= right) {
                i++;
            }
            count++;
            i++;
        }
        return count;
    }
}

