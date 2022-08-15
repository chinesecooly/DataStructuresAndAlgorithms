package com.chinesecooly.stack.easy;

import java.util.LinkedList;

/**
 * 32. 最长有效括号
 */

//todo
public class solution_32 {

    static public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int i = longestValidParentheses(s, stack, 0);
        return 2*i;
    }

   static private int longestValidParentheses(String s, LinkedList stack, int index) {
        if (index<s.length()){
            if (s.charAt(index) == ')') {
                if (stack.isEmpty()) {
                    return 0;
                } else {
                    stack.pop();
                    return longestValidParentheses(s,stack,index+1)+1;
                }
            } else {
                stack.push(s.charAt(index));
                return longestValidParentheses(s,stack,index+1);
            }
        }else {
            return 0;
        }
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()((())("));
    }
}
