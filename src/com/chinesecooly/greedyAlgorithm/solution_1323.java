package com.chinesecooly.greedyAlgorithm;

/**
 * 题目：1323. 6 和 9 组成的最大数字
 * 难度：简单
 *
 * 给你一个仅由数字 6 和 9 组成的正整数num。
 * 你最多只能翻转一位数字，将 6 变成9，或者把9 变成6 。
 * 请返回你可以得到的最大数字。
 *
 * 示例 1：
 *
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 *
 * 示例 2：
 *
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 *
 * 示例 3：
 *
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *
 * 提示：
 *
 * 1 <= num <= 10^4
 * num每一位上的数字都是 6 或者9 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-69-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_1323 {

    public int maximum69Number (int num) {
        StringBuilder builder = new StringBuilder();
        builder.append(num);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i)=='6'){
                builder.setCharAt(i,'9');
                break;
            }
        }
       return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) {
        solution_1323 solution_1323 = new solution_1323();
        System.out.println(solution_1323.maximum69Number(9999));
    }
}
