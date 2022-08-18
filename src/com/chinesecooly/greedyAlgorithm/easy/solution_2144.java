package com.chinesecooly.greedyAlgorithm.easy;

import java.util.Arrays;

/**
 * 题目：2144. 打折购买糖果的最小开销
 * 难度：简单
 *
 *一家商店正在打折销售糖果。每购买 两个糖果，商店会 免费送一个糖果。
 * 免费送的糖果唯一的限制是：它的价格需要小于等于购买的两个糖果价格的 较小值。
 * 比方说，总共有 4个糖果，价格分别为1，2，3和4，一位顾客买了价格为2 和3的糖果，那么他可以免费获得价格为 1的糖果，但不能获得价格为4的糖果。
 * 给你一个下标从 0开始的整数数组cost，其中cost[i]表示第i个糖果的价格，请你返回获得 所有糖果的 最小总开销。
 *
 * 示例 1：
 *
 * 输入：cost = [1,2,3]
 * 输出：5
 * 解释：我们购买价格为 2 和 3 的糖果，然后免费获得价格为 1 的糖果。
 * 总开销为 2 + 3 = 5 。这是开销最小的唯一方案。
 * 注意，我们不能购买价格为 1 和 3 的糖果，并免费获得价格为 2 的糖果。
 * 这是因为免费糖果的价格必须小于等于购买的 2 个糖果价格的较小值。
 *
 * 示例 2：
 *
 * 输入：cost = [6,5,7,9,2,2]
 * 输出：23
 * 解释：最小总开销购买糖果方案为：
 * - 购买价格为 9 和 7 的糖果
 * - 免费获得价格为 6 的糖果
 * - 购买价格为 5 和 2 的糖果
 * - 免费获得价格为 2 的最后一个糖果
 * 因此，最小总开销为 9 + 7 + 5 + 2 = 23 。
 *
 * 示例 3：
 *
 * 输入：cost = [5,5]
 * 输出：10
 * 解释：由于只有 2 个糖果，我们需要将它们都购买，而且没有免费糖果。
 * 所以总最小开销为 5 + 5 = 10 。
 *
 * 提示：
 *
 * 1 <= cost.length <= 100
 * 1 <= cost[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-of-buying-candies-with-discount
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_2144 {

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int result=0;
        for (int i = cost.length-1; i >=0; i--) {
            result+=cost[i];
            i--;
            if (i>=0){
                result+=cost[i];
               i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
