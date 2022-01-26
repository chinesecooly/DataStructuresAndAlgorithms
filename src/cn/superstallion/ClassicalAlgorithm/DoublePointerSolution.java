package cn.superstallion.ClassicalAlgorithm;

import com.sun.xml.internal.ws.handler.HandlerException;

import java.util.*;

/**
 * 双指针技巧
 */
public class DoublePointerSolution {

    //字符串是否是回文串
    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            char iChar = s.charAt(i), jChar = s.charAt(j);
            while (i < s.length() - 1 && (iChar < '0' || iChar > '9') && (iChar < 'a' || iChar > 'z') && (iChar < 'A' || iChar > 'Z')) {
                iChar = s.charAt(++i);
            }
            while (j > 0 && (jChar < '0' || jChar > '9') && (jChar < 'a' || jChar > 'z') && (jChar < 'A' || jChar > 'Z')) {
                jChar = s.charAt(--j);
            }
            if (i > j) {
                return true;
            } else {
                if (iChar >= 'a' && jChar < 'a') {
                    if (iChar - 32 != jChar) {
                        return false;
                    }
                } else if (iChar < 'a' && jChar >= 'a') {
                    if (jChar - 32 != iChar) {
                        return false;
                    }
                } else {
                    if (iChar != jChar) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //从非递减数组中找出两个数满足相加之和等于目标数
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, j = numbers.length - 1; j < numbers.length; ) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    //移动零
    public static void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (zeroIndex != -1 && nums[i] != 0) {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                zeroIndex++;
            }
            if (nums[i] == 0 && zeroIndex == -1) {
                zeroIndex = i;
            }
        }
    }

    //反转字符串
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    //反转字符串中的元音字母
    public String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (isVowel(Character.toLowerCase(s.charAt(i))) && isVowel(Character.toLowerCase(s.charAt(j)))) {
                char temp = stringBuilder.charAt(i);
                stringBuilder.setCharAt(i, s.charAt(j));
                stringBuilder.setCharAt(j, temp);
                i++;
                j--;

            } else if (isVowel(Character.toLowerCase(s.charAt(i))) && !isVowel(Character.toLowerCase(s.charAt(j)))) {
                j--;
            } else if (!isVowel(Character.toLowerCase(s.charAt(i))) && isVowel(Character.toLowerCase(s.charAt(j)))) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    //350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length) {
            nums1 = Arrays.stream(nums1)
                    .distinct()
                    .toArray();
            int[] finalNums1 = nums2;
            nums1 = Arrays.stream(nums1)
                    .filter((num1) -> {
                        return Arrays.stream(finalNums1)
                                .anyMatch((num2) -> {
                                    return num2 == num1;
                                });
                    })
                    .toArray();
            return nums1;
        } else {
            nums2 = Arrays.stream(nums2)
                    .distinct()
                    .toArray();
            int[] finalNums = nums1;
            nums2 = Arrays.stream(nums2)
                    .filter((num2) -> {
                        return Arrays.stream(finalNums)
                                .anyMatch((num1) -> {
                                    return num1 == num2;
                                });
                    })
                    .toArray();
            return nums2;
        }
    }

    //15. 三数之和
    public static ArrayList<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int i1 = Arrays.binarySearch(nums, j + 1, nums.length, -nums[i] - nums[j]);
                if (i1 >= 0) {
                    ArrayList<Integer> result = new ArrayList<>();
                    Collections.addAll(result, nums[i], nums[j], nums[i1]);
                    results.add(result);
                }
            }
        }
        return results;
    }

    //16. 最接近的三数之和
    static public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = (nums[0] + nums[1] + nums[2]) - target;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result)) {
                        result = nums[i] + nums[j] + nums[k] - target;
                    }
                }
            }
        }
        return result + target;
    }

    //18. 四数之和
    static public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int i1 = Arrays.binarySearch(nums, k + 1, nums.length, target - nums[i] - nums[j] - nums[k]);
                    if (i1 >= 0) {
                        ArrayList<Integer> result = new ArrayList<>();
                        Collections.addAll(result, nums[i], nums[k], nums[j], nums[i1]);
                        results.add(result);
                    }
                }
            }
        }
        return results;
    }

    //42. 接雨水
    static public int trap(int[] height) {
        int sum = 0;
        for (int i = 0, j = i + 1; j < height.length; j++) {
            if (height[j] >= height[i]) {
                if (j - i == 1) {
                    i++;
                } else {
                    for (int k = i + 1; k < j; k++) {
                        sum += height[i] - height[k];
                    }
                    i = j;
                }
            } else {
                if (j == height.length - 1) {
                    int max = height.length - 1;
                    for (int k = height.length - 1; k > i; k--) {
                        if (height[k] > height[max]) {
                            max = k;
                        }
                    }
                    if (max - i != 1) {
                        for (int k = i + 1; k < max; k++) {
                            sum += height[max] - height[k];
                        }
                    }
                    j = i = max;
                }
            }
        }
        return sum;
    }

    //75. 颜色分类
    public static void sortColors(int[] nums) {
        int[] colors = {0, 1, 2};
        int i = 0;
        for (int color : colors) {
            for (; i < nums.length; i++) {
                if (nums[i] != color) {
                    break;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == color) {
                    nums[j] = nums[i];
                    nums[i] = color;
                    i++;
                }
            }
        }
    }

    //80. 删除有序数组中的重复项 II
    static public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        System.out.println(slow);
        return slow;
    }


    public static void main(String[] args) {
        int[] ints = {1,2,2,3,3,3};
        removeDuplicates(ints);
        System.out.println(Arrays.toString(ints));
    }
}
