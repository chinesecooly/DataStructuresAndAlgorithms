package com.chinesecooly.greedyAlgorithm.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * 题目：2160. 拆分数位后四位数字的最小和
 * 难度：简单
 *
 * 给你一个四位正整数num。请你使用 num中的 数位 ，将num拆成两个新的整数new1和new2。new1 和new2中可以有前导 0，且num中 所有数位都必须使用。
 * 比方说，给你num = 2932，你拥有的数位包括：两个2，一个9和一个3。一些可能的[new1, new2]数对为[22, 93]，[23, 92]，[223, 9] 和[2, 329]。
 * 请你返回可以得到的new1和 new2的 最小和。
 *
 * 示例 1：
 *
 * 输入：num = 2932
 * 输出：52
 * 解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
 * 最小和为数对 [29, 23] 的和：29 + 23 = 52 。
 *
 *
 * 示例 2：
 *
 * 输入：num = 4009
 * 输出：13
 * 解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
 * 最小和为数对 [4, 9] 的和：4 + 9 = 13 。
 *
 * 提示：
 *
 * 1000 <= num <= 9999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_2160 {

    public int minimumSum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (;num!=0;num=num/10){
            int temp=num%10;
            if (temp!=0){
                list.add(temp);
            }
        }
        Collections.sort(list);
        if (list.size()==1){
            return list.get(0);
        }else if (list.size()==2){
            return list.get(0)+list.get(1);
        }else if (list.size()==3){
            return list.get(0)*10+list.get(1)+list.get(2);
        }else {
            return list.get(0)*10+list.get(1)*10+list.get(2)+list.get(3);
        }
    }
    public static void main(String[] args) {
        solution_2160 solution_2160 = new solution_2160();
        System.out.println(solution_2160.minimumSum(2932));
    }
}
