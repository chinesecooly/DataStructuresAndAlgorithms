package com.chinesecooly.stack.easy;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 */

public class solution_496 {

    static public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int []results=new int[nums1.length];
        boolean flag=false;

        for (int i = 0; i < nums1.length; i++) {
            results[i]=-1;
            flag=false;
            for (int i1 : nums2) {
                if (i1==nums1[i]){
                    flag=true;
                }
                if (flag){
                    if (i1>nums1[i]){
                        results[i]=i1;
                        break;
                    }
                }
            }
        }
        return  results;
    }

    public static void main(String[] args) {
        int[] ints = nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(ints));
    }

}
