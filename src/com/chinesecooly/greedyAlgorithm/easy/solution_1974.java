package com.chinesecooly.greedyAlgorithm.easy;

import sun.awt.windows.WPrinterJob;

/**
 * 题目：1974. 使用特殊打字机键入单词的最少时间
 * 难度：简单
 * <p>
 * 有一个特殊打字机，它由一个 圆盘 和一个 指针组成， 圆盘上标有小写英文字母'a' 到'z'。只有当指针指向某个字母时，它才能被键入。指针 初始时指向字符 'a'。
 * 每一秒钟，你可以执行以下操作之一：
 * <p>
 * 将指针 顺时针或者 逆时针移动一个字符。
 * 键入指针 当前指向的字符。
 * 给你一个字符串word，请你返回键入word所表示单词的 最少秒数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abc"
 * 输出：5
 * 解释：
 * 单词按如下操作键入：
 * - 花 1 秒键入字符 'a' in 1 ，因为指针初始指向 'a' ，故不需移动指针。
 * - 花 1 秒将指针顺时针移到 'b' 。
 * - 花 1 秒键入字符 'b' 。
 * - 花 1 秒将指针顺时针移到 'c' 。
 * - 花 1 秒键入字符 'c' 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "bza"
 * 输出：7
 * 解释：
 * 单词按如下操作键入：
 * - 花 1 秒将指针顺时针移到 'b' 。
 * - 花 1 秒键入字符 'b' 。
 * - 花 2 秒将指针逆时针移到 'z' 。
 * - 花 1 秒键入字符 'z' 。
 * - 花 1 秒将指针顺时针移到 'a' 。
 * - 花 1 秒键入字符 'a' 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "zjpc"
 * 输出：34
 * 解释：
 * 单词按如下操作键入：
 * - 花 1 秒将指针逆时针移到 'z' 。
 * - 花 1 秒键入字符 'z' 。
 * - 花 10 秒将指针顺时针移到 'j' 。
 * - 花 1 秒键入字符 'j' 。
 * - 花 6 秒将指针顺时针移到 'p' 。
 * - 花 1 秒键入字符 'p' 。
 * - 花 13 秒将指针逆时针移到 'c' 。
 * - 花 1 秒键入字符 'c' 。
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word只包含小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-time-to-type-word-using-special-typewriter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1974 {

    public int minTimeToType(String word) {
        int result=word.length();
        for (int i = 0; i < word.length(); i++) {
            if (i==0){
                int abs = Math.abs(word.charAt(i) - 'a');
                result+=Math.min(abs,26- abs);
            }else {
                int temp=Math.abs(word.charAt(i)-word.charAt(i-1));
                result+= Math.min(temp, 26 - temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        solution_1974 solution_1974 = new solution_1974();
        System.out.println(solution_1974.minTimeToType("zjpc"));
    }
}
