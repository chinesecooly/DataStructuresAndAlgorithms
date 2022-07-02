package com.chinesecooly.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：1544. 整理字符串
 * 难度：简单
 *
 * 给你一个由大小写英文字母组成的字符串 s 。
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 * 示例 1：
 *
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *
 * 示例 2：
 *
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 示例 3：
 *
 * 输入：s = "s"
 * 输出："s"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-the-string-great
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1544 {

    /**
     * @param s 未整理的字符串
     * @return 整理后的字符串
     */
    public String makeGood(String s) {
        Deque<Character> stack=new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()){
                stack.push(c);
            }else {
                if (c+32==stack.peek()||c-32==stack.peek()){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        for (;!stack.isEmpty();){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        solution_1544 solution_1544 = new solution_1544();
        System.out.println(solution_1544.makeGood("abBAcC"));
    }
}
