package com.sunjinwei.sort;

import java.util.Arrays;

/**
 * 经典快排
 * 思想：基于分治思想，
 * 1选出一个基准值pivot，自己一般喜欢选取最右边的数为基准值
 * 2将小于基准值pivot的放左边，大于基准值pivot的放右边，这就是所谓的分区
 */
public class QuickSort {

    public void sort(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 使用递归处理，类似前序遍历
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 打乱
        int index = (int) (left + (Math.random() * (right - left - 1)));
        swap(arr, right, index);
        // partition处理 分界点pivot
        // 快排的思想就是 小于pivot的在左边 大于pivot的在右边
        int pivot = partition(arr, left, right);
        // 递归
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    /**
     * 原理：把小于分界点的放左边，把大于分界点的放右边，默认分界点为arr[right]
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] arr, int left, int right) {
        int index = left;
        int less = left - 1;
        while (index < right) {
            if (arr[index] <= arr[right]) {
                // 如果小于分界点 将index调整到less区
                less++;
                swap(arr, less, index);
            }
            index++;
        }
        swap(arr, less + 1, right);
        return less + 1;
    }

    private void swap(int[] arr, int left, int right) {
        int tem = arr[left];
        arr[left] = arr[right];
        arr[right] = tem;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] arr = new int[]{5, 4, 8, 1, 3, 2, 7};

        quickSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
