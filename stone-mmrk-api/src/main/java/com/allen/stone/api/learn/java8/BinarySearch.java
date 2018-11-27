package com.allen.stone.api.learn.java8;

/**
 * 二分法查找
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/19 11:25
 **/
public class BinarySearch {

    /**
     * @param
     * @return
     * @Description: 二分法查找
     */
    public int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;

        while (a < b) {
            int m = (a + b) / 2;
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }
}
