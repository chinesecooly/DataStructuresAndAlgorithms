package cn.superstallion.ClassicalAlgorithm;

import com.sun.org.apache.bcel.internal.generic.IFNULL;

import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.util.*;

public class Solution {

    //整数反转
    static public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if ((rev == Integer.MIN_VALUE / 10 && digit > 8) || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    //回文数
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
            if (x == rev) {
                return true;
            }
            if (x < rev) {
                break;
            }
        }
        return rev / 10 == x;
    }

    //罗马数字转整数
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == 'I') {
                if (chars[i + 1] == 'V') {
                    sum += 4;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'X') {
                    sum += 9;
                    i++;
                    continue;
                }
            }
            if (i + 1 < chars.length && chars[i] == 'X') {
                if (chars[i + 1] == 'L') {
                    sum += 40;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'C') {
                    sum += 90;
                    i++;
                    continue;
                }
            }
            if (i + 1 < chars.length && chars[i] == 'C') {
                if (chars[i + 1] == 'D') {
                    sum += 400;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'M') {
                    sum += 900;
                    i++;
                    continue;
                }
            }
            switch (chars[i]) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
        }
        return sum;
    }

    //寻找最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        String str = "123";
        Arrays.sort(strs, (str1, str2) -> {
            if (str1.length() > str2.length()) {
                return 1;
            } else if (str1.length() < str2.length()) {
                return -1;
            } else {
                return 0;
            }
        });
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return ints;
    }

    //删除有序数组中重复的元素
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int fast;
        int slow;
        for (slow = 1, fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //删除数组内与指定元素重复的元素
    public static int removeElement(int[] nums, int val) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == val) {
                        continue;
                    }
                    nums[i] = nums[j];
                    i++;
                }
                break;
            }
        }
        return i;
    }

    //寻找子串
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = new int[needle.length()];
        for (int i = 0, j = 2; j < needle.length(); j++) {
            for (; ; ) {
                if (needle.charAt(i) == needle.charAt(j - 1)) {
                    i++;
                    break;
                } else {
                    if (i == 0) {
                        break;
                    } else {
                        i = next[i];
                    }
                }
            }
            next[j] = i;
        }
        for (int i = 0, j = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return -1;
    }

    //最大子序和
    public int maxSubArrays(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                sum = Math.max(sum, temp);
            }
        }
        return sum;
    }

    //最后一个单词的长度
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        int i = trim.lastIndexOf(" ");
        return trim.length() - 1 - i;
    }

    //加一
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && digits[0] == 9) {
                int[] ints = new int[digits.length + 1];
                ints[0] = 1;
                return ints;
            }
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            } else {
                digits[i] = 0;
            }

        }
        return digits;
    }

    //二进制求和
    public static String addBinary(String a, String b) {
        int temp = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int aa = i >= 0 ? a.charAt(i) - '0' : 0;
            int bb = j >= 0 ? b.charAt(j) - '0' : 0;
            if (aa + bb + temp == 0) {
                temp = 0;
                stringBuilder.append(0);
            } else if (aa + bb + temp == 1) {
                temp = 0;
                stringBuilder.append(1);
            } else if (aa + bb + temp == 2) {
                temp = 1;
                stringBuilder.append(0);
            } else {
                temp = 1;
                stringBuilder.append(1);
            }
        }
        if (temp == 1) {
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();
    }

    //计算x的平方根
    public static int mySqrt(int x) {
        long temp = x / 2;
        for (; ; ) {
            if (temp * temp == x) {
                return (int) temp;
            } else if (temp * temp > x) {
                temp /= 2;
            } else {
                for (; ; temp++) {
                    if (temp * temp == x) {
                        return (int) temp;
                    }
                    if (temp * temp > x) {
                        break;
                    }
                }
                break;
            }
        }
        return (int) temp - 1;
    }

    //爬楼梯
    //todo
    public int climbStairs(int n) {
        return -1;
    }

    //相同的二叉树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return true;
        } else {
            queue.offer(root.left);
            queue.offer(root.right);
            for (; !queue.isEmpty(); ) {
                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();
                if (node1 == null && node2 == null) {
                    continue;
                } else if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
                    return false;
                } else if (node1.val != node2.val) {
                    return false;
                } else {
                    queue.offer(node1.left);
                    queue.offer(node2.right);
                    queue.offer(node1.right);
                    queue.offer(node2.left);
                }
            }
        }
        return true;
    }

    //将有序数组转换为二叉搜索树
    //todo
    public static TreeNode sortedArrayToBST(int[] nums) {
        int i = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[i]);
        for (int num : nums) {
            treeNode = insert(treeNode, num);
        }
        return treeNode;
    }

    //插入
    private static TreeNode insert(TreeNode node, Integer key) {
        if (node == null) {
            node = new TreeNode(key);
        } else {
            if (key < node.val) {
                node.left = insert(node.left, key);
            } else if (key == node.val) {
            } else {
                node.right = insert(node.right, key);
            }
        }
        return node;
    }


    //合并两个有序数组
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1, m);
        for (int i = 0, j = 0, k = 0; ; k++) {
            if (i >= m) {
                for (int l = j; l < n; l++, k++) {
                    nums1[k] = nums2[l];
                }
                break;
            }
            if (j >= n) {
                for (int l = i; l < m; l++, k++) {
                    nums1[k] = temp[l];
                }
                break;
            }
            if (temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    //缺失的空间
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> list = new ArrayList<>();
        int temp = lower;
        if (nums.length == 0) {
            if (lower == upper) {
                list.add(lower + "");
            } else {
                list.add(lower + "->" + upper);
            }
            return list;
        }
        for (int num : nums) {
            if (num > temp) {
                if (num - temp == 1) {
                    list.add(temp + "");
                } else {
                    list.add(temp + "->" + (num - 1));
                }
                temp = num + 1;
            } else {
                temp++;
            }
        }
        temp = nums[nums.length - 1];
        if (temp < upper) {
            if (upper - temp == 1) {
                list.add(upper + "");
            } else {
                list.add((temp + 1) + "->" + upper);
            }
        }
        return list;
    }

    //两数之和
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode node1 = l1, node2 = l2;
        for (; ; ) {
            int innerTemp = temp;
            if (node1 != null && node2 != null) {
                if (node1.val + node2.val + temp >= 10) {
                    temp = (node1.val + node2.val + temp) / 10;
                    node1.val = (node1.val + node2.val + innerTemp) % 10;
                } else {
                    node1.val = node1.val + node2.val + temp;
                    temp = 0;
                }
                if (node1.next == null && node2.next == null) {
                    if (temp != 0) {
                        node1.next = new ListNode();
                    } else {
                        break;
                    }
                }
                node1.next = node1.next == null ? new ListNode() : node1.next;
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1 != null) {
                if (node1.val + temp >= 10) {
                    temp = (node1.val + temp) / 10;
                    node1.val = (node1.val + innerTemp) % 10;
                } else {
                    node1.val = node1.val + temp;
                    temp = 0;
                }
                if (node1.next == null && temp != 0) {
                    node1.next = new ListNode();
                }
                node1 = node1.next;
            } else {
                break;
            }
        }
        return l1;
    }

    // 寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 != 0) {
            int medianIndex = (nums1.length + nums2.length) / 2;
            int index = 0;
            for (int i = 0, j = 0; index <= medianIndex; ) {
                if (i == nums1.length) {
                    for (; ; j++, index++) {
                        if (index == medianIndex) {
                            return nums2[j];
                        }
                    }
                }
                if (j == nums2.length) {
                    for (; ; i++, index++) {
                        if (index == medianIndex) {
                            return nums1[i];
                        }
                    }
                }
                if (nums1[i] >= nums2[j]) {
                    if (index == medianIndex) {
                        return nums2[j];
                    }
                    j++;
                } else {
                    if (index == medianIndex) {
                        return nums1[i];
                    }
                    i++;
                }
                index++;
            }
            return 0;
        } else {
            int medianIndex1 = (nums1.length + nums2.length) / 2 - 1, medianIndex2 = (nums1.length + nums2.length) / 2;
            int index = 0, median = 0;
            for (int i = 0, j = 0; index <= medianIndex2; ) {
                if (i == nums1.length) {
                    for (; ; j++, index++) {
                        if (index == medianIndex1) {
                            median += nums2[j];
                        }
                        if (index == medianIndex2) {
                            median += nums2[j];
                            break;
                        }
                    }
                    break;
                }
                if (j == nums2.length) {
                    for (; ; i++, index++) {
                        if (index == medianIndex1) {
                            median += nums1[i];
                        }
                        if (index == medianIndex2) {
                            median += nums1[i];
                            break;
                        }
                    }
                    break;
                }
                if (nums1[i] >= nums2[j]) {
                    if (index == medianIndex1) {
                        median += nums2[j];
                    }
                    if (index == medianIndex2) {
                        median += nums2[j];
                        break;
                    }
                    j++;
                } else {
                    if (index == medianIndex1) {
                        median += nums1[i];
                    }
                    if (index == medianIndex2) {
                        median += nums1[i];
                        break;
                    }
                    i++;
                }
                index++;
            }
            return median / 2.0d;
        }
    }

    public static int myAtoi(String s) {
        int result = 0;
        int symbol = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == ' ') {
                if (symbol != 0) {
                    break;
                }
            } else {
                if (symbol == 0 && ch == '+') {
                    if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                        symbol = 1;
                    } else {
                        break;
                    }
                } else if (symbol == 0 && ch == '-') {
                    if (i + 1 < chars.length && (chars[i + 1] >= '0' && chars[i + 1] <= '9')) {
                        symbol = -1;
                    } else {
                        break;
                    }
                } else if (ch < '0' || ch > '9') {
                    break;
                } else {
                    if (symbol == 0) {
                        symbol = 1;
                    }
                    if ((result > Integer.MAX_VALUE / 10) || ((result == Integer.MAX_VALUE / 10) && (ch > '7'))) {
                        if (symbol == -1) {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        result = result * 10 + ch - '0';
                    }
                }
            }
        }
        return symbol == -1 ? result * symbol : result;
    }

    // 盛最多水的容器
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0, j = height.length - 1; j > i; ) {
            if ((j - i) * Math.min(height[i], height[j]) > area) {
                area = (j - i) * Math.min(height[i], height[j]);
            }
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    //两数想除
    public int divide(int dividend, int divisor) {
        int dividendSign = 0;
        int divisorSign = 0;
        if (dividend > 0) {
            dividendSign = 1;
        } else {
            dividendSign = -1;
        }
        if (divisor > 0) {
            divisorSign = 1;
        } else {
            divisorSign = -1;
        }
        int sum = 0;
        int step = 0;
        for (int i = 0; ; i++) {
            if (sum + Math.abs(divisor) > Math.abs(dividend)) {
                break;
            }
            sum += Math.abs(divisor);
            step++;
        }
        return step & dividendSign & divisorSign;
    }

    //BF算法
    static public boolean BF(String source, String target) {
        if (target.length() > source.length()) {
            return false;
        }
        for (int i = 0; i < source.length(); i++) {
            boolean isContain = true;
            for (int j = 0; j < target.length(); j++) {
                if ((i + j) >= source.length() || source.charAt(i + j) != target.charAt(j)) {
                    isContain = false;
                    break;
                }
            }
            if (isContain) {
                return true;
            }
        }
        return false;
    }

    //KMP算法
    static public boolean KMP(String source, String target) {
        if (target.length() == 0) {
            return true;
        }
        int[] next = new int[target.length()];
        for (int i = 0, j = 2; j < target.length(); j++) {
            for (; ; ) {
                if (target.charAt(i) == target.charAt(j - 1)) {
                    i++;
                    break;
                } else {
                    if (i == 0) {
                        break;
                    } else {
                        i = next[i];
                    }
                }
            }
            next[j] = i;
        }
        for (int i = 0, j = 0; i < source.length(); ) {
            if (source.charAt(i) == target.charAt(j)) {
                j++;
                i++;
                if (j == target.length()) {
                    return true;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j];
                }
            }
        }
        return false;
    }

    //无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0, j = 1; j < s.length(); j++) {
            if (s.length() - i + 1 < max) {
                break;
            }
            for (int k = i; k < j; k++) {
                if (s.charAt(k) == s.charAt(j)) {
                    i = k + 1;
                    break;
                }
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    //最长回文串
    public static String longestPalindrome(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (s.length() == 0) {
            return s;
        }
        String str = s.substring(0, 1);
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j = s.length() - 1) {
            int k, v;
            for (k = i, v = j; k < v; ) {
                if (s.charAt(k) == s.charAt(v)) {
                    k++;
                    v--;
                } else {
                    if (k != i) {
                        map.put(k, v);
                    }
                    j--;
                    k = i;
                    v = j;
                }
            }
            if (k != i) {
                if (k == v) {
                    str = str.length() >= (k - i + 1) * 2 - 1 ? str : s.substring(i, (k - i + 1) * 2 - 1 + i);
                } else {
                    str = str.length() >= 2 * (k - i) ? str : s.substring(i, 2 * (k - i) + i);
                }
            }
        }
        return str;
    }

    //最长递增子序列
    public static int lengthOfLIS(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f(nums, i, results);
        }
        System.out.println(Arrays.toString(results));
        return Arrays.stream(results).max().getAsInt();
    }
    static int f(int[] nums, int i, int[] results) {
        if (results[i] != 0) {
            return results[i];
        }
        int a = 0;
        for (int j = 0; j < i; ++j) {
            if (nums[j] < nums[i]) {
                a = Math.max(a, f(nums, j, results));
            }
        }
        results[i] = a+1;
        return results[i];
    }

    //z字变换
    public static String convert(String s, int numRows) {
        StringBuilder stringBuilder = new StringBuilder();
        int length=2*numRows-2;
        if (s.length()<=1||numRows>=s.length()||length==0){
            return s;
        }
        for (int j = 0; j < numRows; j++) {
            int next=j;
            stringBuilder.append(s.charAt(next));
            for (; ;) {
                next+=length;
                if (j!=0&&j!=numRows-1){
                    if (next-2*j>=s.length()){
                        break;
                    }
                    stringBuilder.append(s.charAt(next-2*j));
                    if (next>=s.length()){
                        break;
                    }
                    stringBuilder.append(s.charAt(next));
                }else {
                    if (next>=s.length()){
                        break;
                    }
                    stringBuilder.append(s.charAt(next));
                }
            }
        }
        return stringBuilder.toString();
    }

    //正则表达式匹配
    public boolean isMatch(String s, String p) {
        return false;
    }

    public static int sameSum(int []nums){
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0,j=1; j<nums.length ; ) {
            if (nums[i] != nums[j]) {
                if (j - i == 2) {
                    sum += nums[i];
                }
                i = j;
            }
            j++;
        }
        return sum;
    }





    public static void main(String[] args) {

    }
}

