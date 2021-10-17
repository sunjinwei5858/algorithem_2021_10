package com.sunjinwei.sort;

import java.util.Arrays;

/**
 * 快排使用荷兰国旗思路实现
 */
public class QuickSort_Nertherland {

    public void quickSortNerthreland(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortNerthreland(arr, 0, arr.length - 1);
    }

    private void quickSortNerthreland(int[] arr, int left, int right) {

        // 终止条件
        if (left >= right) {
            return;
        }

        // 打乱
        int i = left + (int) (Math.random() * (right - left + 1));
        swap(arr, i, right);

        // 荷兰国旗partition处理
        int[] pivot = partition(arr, left, right);

        quickSortNerthreland(arr, left, pivot[0] - 1);
        quickSortNerthreland(arr, pivot[1] + 1, right);
    }

    private int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int i = left;

        while (i < right) {
            // 小于区
            // 大于区
            // 等于区
            if (arr[i] < arr[right]) {
                less++;
                swap(arr, less, i);
                i++;
            } else if (arr[i] > arr[right]) {
                more--;
                swap(arr, more, i);
            } else {
                i++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
        QuickSort_Nertherland quickSort = new QuickSort_Nertherland();

        int[] arr = new int[]{5, 4, 8, 1, 3, 2, 7};

        quickSort.quickSortNerthreland(arr);

        System.out.println(Arrays.toString(arr));
    }
}
