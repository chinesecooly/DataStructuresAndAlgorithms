package com.chinesecooly.greedyAlgorithm.easy;

import java.util.Arrays;

/**
 * 题目：1005. K 次取反后最大化的数组和
 * 难度：简单
 *
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_1005 {

    public int largestSumAfterKNegationsVersion1(int[] nums, int k) {

        int sum = 0;
        int maxMinusIndex = -1;
        int minPositiveIndex = -1;

        Arrays.sort(nums);

        if (nums[0] >= 0) {
            minPositiveIndex = 0;
        } else if (nums[nums.length - 1] < 0) {
            maxMinusIndex = nums.length - 1;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < 0 && nums[i + 1] >= 0) {
                    maxMinusIndex = i;
                    minPositiveIndex = i + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (minPositiveIndex != -1 && i == minPositiveIndex) {
                continue;
            }
            if (maxMinusIndex != -1 && i == maxMinusIndex) {
                continue;
            }
            if (k > 0) {
                if (nums[i] <= 0) {
                    k--;
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            } else {
                sum += nums[i];
            }
        }

        if (k == 0) {
            sum += minPositiveIndex == -1 ? 0 : nums[minPositiveIndex];
            sum += maxMinusIndex == -1 ? 0 : nums[maxMinusIndex];
        } else {
            if (k % 2 == 0) {
                if (maxMinusIndex != -1 && minPositiveIndex != -1) {
                    if (Math.abs(nums[maxMinusIndex]) >= nums[minPositiveIndex]) {
                        sum -= nums[maxMinusIndex];
                        sum -= nums[minPositiveIndex];
                    } else {
                        sum += nums[minPositiveIndex];
                        sum += nums[maxMinusIndex];
                    }
                } else if (maxMinusIndex == -1 && minPositiveIndex != -1) {
                    sum += nums[minPositiveIndex];
                } else if (maxMinusIndex != -1) {
                    sum += nums[maxMinusIndex];
                }
            } else {
                if (maxMinusIndex != -1 && minPositiveIndex != -1) {
                    sum -= nums[maxMinusIndex];
                    sum += nums[minPositiveIndex];
                } else if (maxMinusIndex == -1 && minPositiveIndex != -1) {
                    sum -= nums[minPositiveIndex];
                } else if (maxMinusIndex != -1) {
                    sum += nums[maxMinusIndex];
                }
            }
        }

        return sum;
    }

    //充分利用条件，好好学，好好练
    public int largestSumAfterKNegationsVersion2(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }

    public static void main(String[] args) {
        solution_1005 solution_1005 = new solution_1005();
    }
}
