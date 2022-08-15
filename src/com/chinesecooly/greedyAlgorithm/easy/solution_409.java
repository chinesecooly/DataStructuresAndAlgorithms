package com.chinesecooly.greedyAlgorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：409. 最长回文串
 * 难度：简单
 *
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 *
 * 示例 3:
 *
 * 输入:s = "bb"
 * 输入: 2
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s只能由小写和/或大写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_409 {

    public int longestPalindromeVersion1(String s) {
        int sameCount=0;
        int differentCount=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()%2==0){
                sameCount+=entry.getValue()/2;
            }else if(entry.getValue()%2==1){
                sameCount+=(entry.getValue()-1)/2;
                differentCount++;
            }else {
                differentCount++;
            }
        }
        return differentCount==0?sameCount*2:sameCount*2+1;
    }

    /**
     * 利用数组存储字符
     * @param s 原始字符串
     * @return 回文串的长度
     */
    public int longestPalindromeVersion2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        solution_409 solution_409 = new solution_409();
    }
}
