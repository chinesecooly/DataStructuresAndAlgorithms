package com.chinesecooly.stack;

/**
 * 316. 去除重复字母
 */

public class solution_316 {

    static public String removeDuplicateLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!stringBuilder.toString().contains(aChar+"")){
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

}
