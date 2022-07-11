package com.chinesecooly.greedyAlgorithm;

import java.util.Arrays;

/**
 * 题目：1013. 将数组分成和相等的三个部分
 * 难度：简单
 *
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回true，否则返回 false。
 * 形式上，如果可以找出索引i + 1 < j且满足(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])就可以将数组三等分。
 *
 * 示例 1：
 *
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 *
 * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 *
 * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * 提示：
 *
 * 3 <= arr.length <= 5 * 104
 * -104 <= arr[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num: A) {
            sum += num;
        }
        // 数组A的和如果不能被3整除直接返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段
        sum /= 3;
        int curSum = 0, cnt = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            if (curSum == sum) {
                cnt++;
                curSum = 0;
            }
        }
        // 最后判断是否找到了3段（注意如果目标值是0的话可以大于3段）
        return cnt == 3 || (cnt > 3 && sum == 0);
    }

    public static void main(String[] args) {
        solution_1013 solution_1013 = new solution_1013();
        System.out.println(solution_1013.canThreePartsEqualSum(new int[]{1,-1,1,-1}));
    }

}
