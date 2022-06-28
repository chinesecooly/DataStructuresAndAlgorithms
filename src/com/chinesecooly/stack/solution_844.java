package com.chinesecooly.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_844 {

    public boolean backspaceCompare(String s, String t) {

        Deque<Character> stackS = new LinkedList<>();
        Deque<Character> stackT = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(c);
            }
        }

        boolean result=stackT.size()==stackS.size();

        for (;result&&!stackS.isEmpty();){
            result=stackT.pop()==stackS.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        solution_844 solution_844 = new solution_844();
        System.out.println(solution_844.backspaceCompare("a#c", "b"));
    }
}
