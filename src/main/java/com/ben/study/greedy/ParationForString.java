package com.ben.study.greedy;

import java.util.ArrayList;
import java.util.List;

//763
public class ParationForString {
    public static void main(String[] args) {

    }

    public List<Integer> part(String s) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] temp = new int[27];
        //将每个数字出现得最后得位置更新进数组，
        for (int i = 0; i < chars.length; i++) {
            temp[chars[i] - 'a'] = i;
        }
        //接下来找一段字母中出现得最大值，直到跑到这个最大值得时候
        int max = -1;
        int mark = 0;
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(max, temp[chars[i] - 'a']);
            if (max == i) {
                int tempNum = i - mark + 1;
                result.add(tempNum);
                mark = i + 1;
            }
        }
        return result;
    }
}
