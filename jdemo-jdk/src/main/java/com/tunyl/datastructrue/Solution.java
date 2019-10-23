package com.tunyl.datastructrue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author create by Tunyl on 2019/10/16
 * @version 1.0
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        int max = 0;
        for (int i = (T.length - 1); i >= 0; i--) {
            if (T[i] >= max) {
                res[i] = 0;
            } else {
                if (T[i] == T[i + 1]) {
                    res[i] = res[i + 1] + 1;
                } else {
                    int j = i + 1;
                    while (T[i] >= T[j]) {
                        j++;
                    }
                    res[i] = j - i;
                }
            }
            max = max < T[i] ? T[i] : max;

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70});
        System.out.println(Arrays.toString(res));
    }
}

