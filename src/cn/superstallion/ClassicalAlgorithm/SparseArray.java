package cn.superstallion.ClassicalAlgorithm;

import java.util.Arrays;

public class SparseArray {
//    public static void main(String[] args) {
//        //原数组
//        int[][] originalArray = new int[][]{
//                {1, 0, 0, 0, 0},
//                {0, 2, 0, 0, 0},
//                {0, 0, 3, 0, 0},
//                {0, 0, 0, 4, 0},
//                {0, 0, 0, 0, 0}
//        };
//        //遍历原始二维数组,得到有效数据的个数sum
//        int sum = 0;
//        for (int[] items : originalArray) {
//            for (int item : items) {
//                if (item != 0) {
//                    sum++;
//                }
//            }
//        }
//        //根据sum创建稀疏数组sparseArray=int[sum+1][3]
//        int[][] sparseArray = new int[sum + 1][3];
//        sparseArray[0] = new int[]{originalArray.length, originalArray[0].length, sum};
//        //将二维数组有效数据存入到稀疏数组.
//        for (int i = 1; i < originalArray.length + 1; i++) {
//            for (int j = 1; j < originalArray[0].length + 1; j++) {
//                if (originalArray[i - 1][j - 1] != 0) {
//                    sparseArray[sparseArray.length - sum][0] = i;
//                    sparseArray[sparseArray.length - sum][1] = j;
//                    sparseArray[sparseArray.length - sum][2] = originalArray[i - 1][j - 1];
//                    sum--;
//                }
//            }
//        }
//        //输出测试结果
//        for (int[] items : sparseArray) {
//            System.out.println(Arrays.toString(items));
//        }
//    }
    public static void main(String[] args) {
        //稀疏数组
        int[][] sparseArray={
                {5,5,4},
                {1,1,1},
                {2,2,2},
                {3,3,3},
                {4,4,4}
        };
        //读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
        int[][] originalArray=new int[sparseArray[0][0]][sparseArray[0][1]];

        //读取稀疏数组后几行的数据,并赋值给原始数组.
        int[][] ints = Arrays.copyOfRange(sparseArray, 1, originalArray.length);
        for (int[]items:ints){
            originalArray[items[0]-1][items[1]-1]=items[2];
        }

        //输出测试结果
        for (int[] items : originalArray ){
            System.out.println(Arrays.toString(items));
        }

    }
}
