package com.chinesecooly.stack.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_682 {

    public int calPoints(String[] ops) {
        Deque<String> stack = new LinkedList<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    String pop = stack.pop();
                    String value = String.valueOf(Integer.parseInt(pop) + Integer.parseInt(stack.peek()));
                    stack.push(pop);
                    stack.push(value);
                    break;
                case "D":
                    stack.push(String.valueOf(Integer.parseInt(stack.peek()) * 2));
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(op);
            }
        }
        int sum=0;
        for (;!stack.isEmpty();){
            sum+=Integer.parseInt(stack.pop());
        }
        return sum;
    }

    public static void main(String[] args) {
        solution_682 solution_682 = new solution_682();
        System.out.println(solution_682.calPoints(new String[]{"5"}));
    }

}
