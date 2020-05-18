package com.ex200518;

import com.util.Util;

/**
 * @Description: 猜数字
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
 * 他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * 示例：
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *
 * @Author: An Qi
 * @Date: 2020/5/18
 */
public class GuessNumbers {

    public static void main(String[] args) {
        int[] guess = {1, 2, 3};
        int[] answer = {3, 2, 1};
        Util.print(game(guess,answer));
    }

    private static int game(int[] guess, int[] answer) {
        int n = 0;
        for (int i = 0; i < guess.length; i++) {
            if (guess[i] == answer[i]) {
                n++;
            }
        }
        return n;
    }

}
