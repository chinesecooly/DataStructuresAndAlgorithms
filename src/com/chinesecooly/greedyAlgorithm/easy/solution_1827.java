package com.chinesecooly.greedyAlgorithm.easy;

/**
 * 题目：1827. 最少操作使数组递增
 * 难度：简单
 *
 * 给你一个整数数组nums（下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加1。
 * 比方说，如果nums = [1,2,3]，你可以选择增加nums[1]得到nums = [1,3,3]。
 * 请你返回使 nums严格递增的 最少操作次数。
 * 我们称数组nums是 严格递增的，当它满足对于所有的0 <= i < nums.length - 1都有nums[i] < nums[i+1]。一个长度为 1的数组是严格递增的一种特殊情况。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以进行如下操作：
 * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
 * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
 * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
 *
 * 示例 2：
 *
 * 输入：nums = [1,5,2,4,1]
 * 输出：14
 *
 * 示例 3：
 *
 * 输入：nums = [8]
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * 1 <= nums[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1827 {

    public int minOperations(int[] nums) {
        int result=0;
        int temp;
        for(int i=0,j=i+1;j<nums.length;i++,j++){
            if (nums[i]>=nums[j]){
                temp=nums[i]-nums[j]+1;
                nums[j]+=temp;
                result+=temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        solution_1827 solution_1827 = new solution_1827();
        System.out.println(solution_1827.minOperations(new int[]{8}));
    }

}
