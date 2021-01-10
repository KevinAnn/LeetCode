package com.ex200518;

import com.base.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 拥有糖果最多的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
 * 此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 * @Author: An Qi
 * @Date: 2020/5/18
 */
public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        Util.print(kidsWithCandies(candies, extraCandies));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null) {
            return null;
        }
        // 获取最大值
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= max) {
                max = candies[i];
            }
        }
        // 与最大值比较
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy + extraCandies < max) {
                result.add(false);
            } else {
                result.add(true);
            }
        }
        return result;
    }


}
