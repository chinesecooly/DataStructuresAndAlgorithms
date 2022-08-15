package com.chinesecooly.greedyAlgorithm.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：942. 增减字符串匹配
 * 难度：简单
 *
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * 如果perm[i] < perm[i + 1]，那么s[i] == 'I'
 * 如果perm[i] > perm[i + 1]，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 示例 1：
 *
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2：
 *
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 *
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 只包含字符"I"或"D"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_942 {

    public int[] diStringMatchVersion1(String s) {
        Deque<Integer> deque=new LinkedList<>();
        int[] ints = new int[s.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            deque.offerLast(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='I'){
                ints[i]= deque.pollFirst();
            }else {
                ints[i]=deque.pollLast();
            }
        }
        ints[s.length()]=deque.pop();
        return ints;
    }
    //巧妙的存储最小值和最大值。
    public int[] diStringMatchVersion2(String s) {
        int  lo = 0, hi = s.length();
        int[] perm = new int[s.length() + 1];
        for (int i = 0; i < s.length(); ++i) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[s.length()] = lo;
        return perm;
    }

    public static void main(String[] args) {
        solution_942 solution_942 = new solution_942();
    }

}
