package com.ben.study.greedy;

public class FlowersNums {
    //有时间是数学规律，数学归纳法
    //当走到某个位置是1的时候，下一个肯定是0，我们只需要走下下个，
    //当走到一个位置是0的时候，上一个肯定也是0，因为是1的话我们已经走到下下个了,如果下一个是0则可以当前位置种花，然后按照上面规则走下下个位置
    //如果下一个是1则按照第一个规则再往后延申两位，则相对该索引位置是向后延申三个位置
    public boolean canPlaceFlowers(int[] flower, int n) {
        for (int i = 0, len = flower.length;  i < len && n > 0;) {
            if (flower[i] == 1) {
                i += 2;
            }
            //说明flower[i] == 0, flower[i-1] = 0 如果刚搞是最后一个位置的话，也可以种
            else if (flower[i+1] == 0 || i== len - 1) {
                n--;
                i += 2;
            }
            else {
                i += 3;
            }
        }
        return n <= 0;
    }
}
