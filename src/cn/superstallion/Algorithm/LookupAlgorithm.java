package cn.superstallion.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LookupAlgorithm {

    public static void main(String[] args) {
        Random random = new Random();
//        int [] ints=new int[]{1, 1, 7, 0, 5, 2, 6, 5, 6, 8};
        int[] ints = random.ints(10, 0, 10).toArray();
        System.out.println(Arrays.toString(ints));
        SortAlgorithm.quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
        System.out.println(LookupAlgorithm.binarySearch(ints, 2));
    }

    public static <T extends Comparable<T>> ArrayList<Integer> linearSearch(T[] dataStructure, T findValue) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < dataStructure.length; i++) {
            if (dataStructure[i].compareTo(findValue) == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static int linearSearch(int[]data,int target){
        for (int i = 0; i < data.length; i++) {
            if (data[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> ArrayList<Integer> binarySearch(T[] dataStructure, int left, int right, T findValue) {
        int midIndex = (left + right) / 2 + left;
        ArrayList<Integer> results = new ArrayList<>();
        if (left<right){
            return results;
        }
        if (dataStructure[midIndex].compareTo(findValue) > 0) {
            return binarySearch(dataStructure, left, midIndex - 1, findValue);
        } else if (dataStructure[midIndex].compareTo(findValue) < 0) {
            return binarySearch(dataStructure, midIndex + 1, right, findValue);
        } else {
            results.add(midIndex);
            for (int temp=midIndex-1;temp>=left;temp--){
                if (dataStructure[temp].compareTo(findValue)==0){
                    results.add(temp);
                }else {
                    break;
                }
            }
            for (int temp=midIndex+1;temp<=right;temp++){
                if (dataStructure[temp].compareTo(findValue)==0){
                    results.add(temp);
                }else {
                    break;
                }
            }
            return results;
        }
    }

    public static int binarySearch(int []data,int target){
        int lower=0;
        int upper=data.length-1;
        while (true){
            int middle=lower+(upper-lower)/2;
            if (lower<=upper){
                if (data[middle]>target){
                    upper=middle-1;
                }else if (data[middle]<target){
                    lower=middle+1;
                }else{
                    return middle;
                }
            } else {
                return -1;
            }
        }
    }
}
