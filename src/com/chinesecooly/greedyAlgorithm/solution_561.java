package com.chinesecooly.greedyAlgorithm;

import java.lang.management.MemoryUsage;
import java.util.Arrays;

/**
 * 题目：561. 数组拆分 I
 * 难度：简单
 *
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 *
 * 示例 2：
 *
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * nums.length == 2 * n
 * -104 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_561 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int num=0;
        for (int i = 0; i < nums.length; i+=2) {
            num+=nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        solution_561 solution_561 = new solution_561();
        System.out.println(solution_561.arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

}
