package cn.superstallion.Algorithm;

import com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl;
import sun.reflect.generics.tree.FormalTypeParameter;
import sun.rmi.runtime.Log;

import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.beans.beancontext.BeanContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortAlgorithm {
    public static void main(String[] args) {
        Random random = new Random();
//        int[] ints = random.ints(10, 0, 10).toArray();
        int[] ints=new int[]{9,0,0,0,0,0,0,0,0,1};
        System.out.println(Arrays.toString(ints));
        SortAlgorithm.quickSort(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] dataStructure) {
        for (int i = dataStructure.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (dataStructure[j].compareTo(dataStructure[j + 1]) > 0) {
                    T temp = dataStructure[j];
                    dataStructure[j] = dataStructure[j + 1];
                    dataStructure[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(T[] dataStructure) {
        for (int i = 0; i < dataStructure.length - 1; i++) {
            int minIndex = i;
            T min = dataStructure[minIndex];
            for (int j = i + 1; j < dataStructure.length; j++) {
                if (min.compareTo(dataStructure[j]) > 0) {
                    minIndex = j;
                    min = dataStructure[j];
                }
            }
            dataStructure[minIndex] = dataStructure[i];
            dataStructure[i] = min;
        }
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] dataStructure) {
        for (int i = 1; i < dataStructure.length; i++) {
            T insertValue = dataStructure[i];
            int insertPos = i;
            for (int j = i - 1; j >= 0; j--) {
                if (insertValue.compareTo(dataStructure[j]) < 0) {
                    dataStructure[j + 1] = dataStructure[j];
                    insertPos = j;
                } else {
                    insertPos = j + 1;
                    break;
                }
            }
            dataStructure[insertPos] = insertValue;
        }
    }

    public static void insertionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j > 0 && j < data.length; j--) {
                if (data[j] < data[j - 1]) {
                    int temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void shellSort(T[] dataStructure) {
        int interval = dataStructure.length / 2;
        while (interval > 0) {
            for (int i = interval; i < dataStructure.length; i++) {
                T insertValue = dataStructure[i];
                int insertPos = i;
                for (int j = i - interval; j >= 0; j -= interval) {
                    if (insertValue.compareTo(dataStructure[j]) < 0) {
                        dataStructure[j + interval] = dataStructure[j];
                        insertPos = j;
                    } else {
                        insertPos = j + interval;
                        break;
                    }
                }
                dataStructure[insertPos] = insertValue;
            }
            interval /= 2;
        }
    }

    public static void shellSort(int[] data) {
        int interval = data.length / 2;
        while (interval > 0) {
            for (int i = 0; i < data.length - interval + 1; i++) {
                for (int j = i + interval; j >= interval && j < data.length; j -= interval) {
                    if (data[j] < data[j - interval]) {
                        int temp = data[j];
                        data[j] = data[j - interval];
                        data[j - interval] = temp;
                    } else {
                        break;
                    }
                }
            }
            interval /= 2;
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] dataStructure, int end, int top) {
        int tempEnd = end;
        int tempTop = top;
        T baseValue = dataStructure[(top - end) / 2 + end];
        while (end < top) {
            for (; end < top; end++) {
                if (dataStructure[end].compareTo(baseValue) >= 0) {
                    break;
                }
            }
            for (; top > end; top--) {
                if (dataStructure[top].compareTo(baseValue) <= 0) {
                    break;
                }
            }
            if (dataStructure[end] == dataStructure[top] && end != top) {
                if (end + 1 != dataStructure.length) {
                    end++;
                } else {
                    top--;
                }
            }
            T temp = dataStructure[top];
            dataStructure[top] = dataStructure[end];
            dataStructure[end] = temp;
        }
        if (end - tempEnd > 1) {
            quickSort(dataStructure, tempEnd, end - 1);
        }
        if (tempTop - top > 1) {
            quickSort(dataStructure, top + 1, tempTop);
        }
    }

    public static void quickSort(int[] data,int left,int right) {

        int lastLeft=left;
        int lastRight=right;
        int point =data[left];

        while (true){
            for (;left<right;left++){
                if (data[left]>=point){
                    break;
                }
            }
            for (;right>left;right--){
                if (data[right]<=point){
                    break;
                }
            }
            if (left>=right){
                if (left!=lastLeft){
                    quickSort(data,lastLeft,left-1);
                }
                if (right!=lastRight){
                    quickSort(data,right+1,lastRight);
                }
                break;
            }else {
                if (data[left]==point&& data[right]==point){
                    if (data[left+1]!=point){
                        int temp=data[left];
                        data[left]=data[left+1];
                        data[left+1]=temp;
                    }else {
                        left++;
                    }
                    if (data[right-1]!= point){
                        int temp=data[right];
                        data[right]=data[right-1];
                        data[right-1]=temp;
                    }else {
                        right--;
                    }
                    continue;
                }
                int temp=data[left];
                data[left]=data[right];
                data[right]=temp;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] dataStructure, int left, int right, Class<T> clazz) {
        int midIndex = (right - left) / 2 + left;
        if (right > left) {
            mergeSort(dataStructure, left, midIndex, clazz);
            mergeSort(dataStructure, midIndex + 1, right, clazz);
        }
        T[] tempArray = (T[]) Array.newInstance(clazz, dataStructure.length);
        for (int i = left, j = midIndex + 1, tempLeft = left; ; ) {
            if (i <= midIndex && j <= right && dataStructure[i].compareTo(dataStructure[j]) <= 0) {
                tempArray[tempLeft++] = dataStructure[i];
                i++;
                continue;
            }
            if (i <= midIndex && j <= right && dataStructure[i].compareTo(dataStructure[j]) >= 0) {
                tempArray[tempLeft++] = dataStructure[j];
                j++;
                continue;
            }
            if (i > midIndex && j <= right) {
                tempArray[tempLeft++] = dataStructure[j];
                j++;
                if (j > right) {
                    break;
                }
            } else if (i <= midIndex && j > right) {
                tempArray[tempLeft++] = dataStructure[i];
                i++;
                if (i > midIndex) {
                    break;
                }
            } else {
                break;
            }
        }
        for (; left <= right; left++) {
            dataStructure[left] = tempArray[left];
        }
    }

    public static void mergeSort(int[] data) {
        int[] mergeArray = new int[data.length];
        for (int i = 1; i < data.length; i *= 2) {
            for (int j = 0; j < data.length; j += 2 * i) {
                int mergeArrayStart = j;
                int startOne = j;
                int endOne = Math.min(j + i - 1, data.length - 1);
                int startTow = Math.min(startOne + i, data.length - 1);
                int endTow = Math.min(endOne + i, data.length - 1);

                while (startOne <= endOne && startTow <= endTow && mergeArrayStart < mergeArray.length) {
                    mergeArray[mergeArrayStart++] = data[startOne] < data[startTow] ? data[startOne++] : data[startTow++];
                }
                while (startOne <= endOne && mergeArrayStart < mergeArray.length) {
                    mergeArray[mergeArrayStart++] = data[startOne++];
                }
                while (startTow <= endTow && mergeArrayStart < mergeArray.length) {
                    mergeArray[mergeArrayStart++] = data[startTow++];
                }
            }
            int[] temp = data;
            data = mergeArray;
            mergeArray = temp;
        }
    }

}
