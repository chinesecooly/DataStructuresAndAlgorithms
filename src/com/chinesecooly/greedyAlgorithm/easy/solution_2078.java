package com.chinesecooly.greedyAlgorithm.easy;

/**
 * 题目；2078. 两栋颜色不同且距离最远的房子
 * 难度：简单
 *
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第i 栋房子的颜色。
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 *
 *示例 1：
 *
 * 输入：colors = [1,1,1,6,1,1,1]
 * 输出：3
 * 解释：上图中，颜色 1 标识成蓝色，颜色 6 标识成红色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 3 。
 * 房子 0 的颜色是颜色 1 ，房子 3 的颜色是颜色 6 。两栋房子之间的距离是 abs(0 - 3) = 3 。
 * 注意，房子 3 和房子 6 也可以产生最佳答案。
 *
 * 示例 2：
 *
 * 输入：colors = [1,8,3,8,3]
 * 输出：4
 * 解释：上图中，颜色 1 标识成蓝色，颜色 8 标识成黄色，颜色 3 标识成绿色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 4 。
 * 房子 0 的颜色是颜色 1 ，房子 4 的颜色是颜色 3 。两栋房子之间的距离是 abs(0 - 4) = 4 。
 *
 * 示例 3：
 *
 * 输入：colors = [0,1]
 * 输出：1
 * 解释：两栋颜色不同且距离最远的房子是房子 0 和房子 1 。
 * 房子 0 的颜色是颜色 0 ，房子 1 的颜色是颜色 1 。两栋房子之间的距离是 abs(0 - 1) = 1 。
 *
 * 提示：
 *
 * n ==colors.length
 * 2 <= n <= 100
 * 0 <= colors[i] <= 100
 * 生成的测试数据满足 至少 存在 2 栋颜色不同的房子
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-furthest-houses-with-different-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution_2078 {

    public int maxDistance(int[] colors) {
        int result=0;
        for (int i = 0,j=colors.length-1; j>=0;) {
            if (colors[i]!=colors[j]){
                result=Math.abs(i-j);
                break;
            }else {
                j--;
            }
        }
        for (int i = 0,j=colors.length-1; i < colors.length;) {
            if (colors[i]!=colors[j]){
                result=Math.max(result,Math.abs(i-j));
                break;
            }else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        solution_2078 solution_2078 = new solution_2078();
        System.out.println(solution_2078.maxDistance(new int[]{1,1,1, 6, 1,1,1}));
    }
}
