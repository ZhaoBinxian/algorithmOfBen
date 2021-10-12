package com.ben.study.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NoOverlapping {
    //给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
    //根据结尾对每个区间进行排序，从小到大，每次找到下一个不重复的且结束的最早的
    public int eraseOverLapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        //按照每个区间结束端点从小到大进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = intervals.length;
        //找到了区间结束最早的第一个位置
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
