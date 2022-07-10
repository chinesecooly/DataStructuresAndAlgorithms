package com.chinesecooly.greedyAlgorithm;

import java.util.Arrays;

/**
 * 题目：976.三角形的最大周长
 * 难度：简单
 *
 *给定由一些正数（代表长度）组成的数组 nums，返回 由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回0。
 *
 * 示例 1：
 *
 * 输入：nums = [2,1,2]
 * 输出：5
 *
 * 示例 2：
 *
 * 输入：nums = [1,2,1]
 * 输出：0
 *
 * 提示：
 *
 * 3 <= nums.length <= 104
 * 1 <= nums[i] <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length-3; i >=0; i--) {
            if (nums[i]+nums[i+1]>nums[i+2]){
                return nums[i]+nums[i+1]+nums[i+2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        solution_976 solution_976 = new solution_976();
        System.out.println(solution_976.largestPerimeter(new int[]{1,1,2}));
    }

}
