package com.chinesecooly.greedyAlgorithm.easy;

/**
 * 题目：680. 验证回文字符串 Ⅱ
 * 难度：简单
 * <p>
 * 给定一个非空字符串s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_680 {

    public boolean validPalindrome(String s) {
        boolean result = true;
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (!result){
                break;
            }
            if (s.charAt(i) != s.charAt(j)) {
                int tempJ=j,tempI=i;
                for (j-=1;i<=j;i++,j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        result = false;
                        break;
                    }
                }
                if (!result){
                    for (i=tempI+1,j=tempJ;i<=j;i++,j--) {
                        if (s.charAt(i) != s.charAt(j)) {
                            result=false;
                            break;
                        }else {
                            result=true;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        solution_680 solution_680 = new solution_680();
        System.out.println(solution_680.validPalindrome("aaaaff"));
    }

}
