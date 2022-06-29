package com.chinesecooly.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 题目：1047. 删除字符串中的所有相邻重复项
 * 难度：简单
 *
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 *
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_1047 {

    /**
     * @param s 小写字母组成的字符串
     * @return 无重复项的s
     */

    public String removeDuplicates(String s) {
        Deque<Character> stack=new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()&&c==stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        solution_1047 solution_1047 = new solution_1047();
        System.out.println(solution_1047.removeDuplicates("dbbdca"));
    }
}
