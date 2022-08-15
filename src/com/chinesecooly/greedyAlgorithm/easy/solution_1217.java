package com.chinesecooly.greedyAlgorithm.easy;

import java.util.Arrays;

/**
 * 题目：1217. 玩筹码
 * 难度：简单
 * <p>
 * 有n个筹码。第 i 个筹码的位置是position[i]。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从position[i]改变为:
 * position[i] + 2或position[i] - 2，此时cost = 0
 * position[i] + 1或position[i] - 1，此时cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * <p>
 * 示例 2：
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * <p>
 * 示例 3:
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1217 {

    //结果不对
    public int minCostToMoveChipsVersion1(int[] position) {
        int result = 0;
        int now = 0;
        int count = 0;
        Arrays.sort(position);
        for (int i = 0, j = 0; i < position.length; i++) {
            int temp=position[i];
            while (i < position.length && position[i]==temp) {
                i++;
                j++;
            }
            if (now==0||count <= j) {
                count = j;
                now = position[i-1];
            }
            j = 1;
        }
        if (count == 1) {
            now = position[0];
        }
        if (now == 0) {
            return 0;
        } else {
            for (int i : position) {
                result += Math.abs(i - now) % 2;
            }
            return result;
        }
    }

    //判断奇偶个数即可，想不到
    public int minCostToMoveChipsVersion2(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        solution_1217 solution_1217 = new solution_1217();
    }
}
