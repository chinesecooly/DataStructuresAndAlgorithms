package com.chinesecooly.greedyAlgorithm.easy;

import java.util.Arrays;

/**
 * 题目：455. 分发饼干
 * 难度：简单
 * <p>
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 示例1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * <p>
 * 示例2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * <p>
 * 提示：
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <=231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_455 {

    public int findContentChildrenVersion1(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(s);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[j] == s[i]) {
                    count++;
                    g[j] = -1;
                    s[i] = -1;
                    break;
                }
            }
            for (int j = 0; j < g.length; j++) {
                if (s[i] != -1 && g[j] != -1 && g[j] < s[i]) {
                    count++;
                    g[j] = -1;
                    s[i] = -1;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 贪心加排序，两个数组只需要遍历一次
     */
    public int findContentChildrenVersion2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i <g.length && j < s.length; i++, j++) {
            while (j <s.length && g[i] > s[j]) {
                j++;
            }
            if (j < s.length) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        solution_455 solution_455 = new solution_455();
        System.out.println(solution_455.findContentChildrenVersion2(new int[]{1, 2, 3}, new int[]{1, 2}));
    }

}
