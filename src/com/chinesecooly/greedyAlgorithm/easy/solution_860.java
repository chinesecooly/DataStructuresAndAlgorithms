package com.chinesecooly.greedyAlgorithm.easy;

import java.util.HashMap;

/**
 * 题目：860. 柠檬水找零
 * 难度：简单
 * <p>
 * 在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * 提示：
 * <p>
 * 1 <= bills.length <= 105
 * bills[i]不是5就是10或是20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution_860 {

    public boolean lemonadeChangeVersion1(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    map.put(5, map.get(5) + 1);
                    break;
                case 10:
                    map.put(10, map.get(10) + 1);
                    if (map.get(5) == 0) {
                        return false;
                    } else {
                        map.put(5, map.get(5) - 1);
                    }
                    break;
                case 20:
                    map.put(20, map.get(20) + 1);
                    if (map.get(5) != 0 && map.get(10) != 0) {
                        map.put(5, map.get(5) - 1);
                        map.put(10, map.get(10) - 1);
                    } else if (map.get(5) >= 3) {
                        map.put(5, map.get(5) - 3);
                    } else {
                        return false;
                    }
                    break;
                default:
                    return true;
            }
        }
        return true;
    }

    //注意额外空间的使用
    public boolean lemonadeChangeVersion2(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solution_860 solution_860 = new solution_860();
    }
}
