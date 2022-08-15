package com.chinesecooly.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：1021. 删除最外层的括号
 * 难度：简单
 *
 * 有效括号字符串为空 ""、"(" + A + ")"或A + B ，其中A和B都是有效的括号字符串，+代表字符串的连接。
 * 例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B的方法，我们称其为原语（primitive），其中A和B都是非空有效括号字符串。
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 *
 * 示例 1：
 *
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * 示例 2：
 *
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *
 * 示例 3：
 *
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1021 {

    /**
     * @param s 非空有效字符串
     * @return 参数s的原语
     */

    public String removeOuterParenthesesVersion1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag=true;
        int leftCount=0;
        for (char c : s.toCharArray()) {
            if (flag){
                flag=false;
            }else if (c=='('){
                stringBuilder.append(c);
                leftCount++;
            }else if (c==')'&&leftCount>0){
                stringBuilder.append(c);
                leftCount--;
            }else{
                flag=true;
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 不需要flag标志
     */
    public String removeOuterParenthesesVersion2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int leftCount=0;
        for (char c : s.toCharArray()) {
            if (c == ')') {
                leftCount--;
            }
            if (leftCount > 0) {
                stringBuilder.append(c);
            }
            if (c == '(') {
                leftCount++;
            }
        }
        return stringBuilder.toString();
    }

}
