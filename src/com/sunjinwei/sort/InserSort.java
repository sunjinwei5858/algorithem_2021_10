package com.sunjinwei.sort;

/**
 * 插入排序
 * 思想：内循环从右往左 进行两两比较 ，插入一个，进行从右往左比较
 */
public class InserSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 外层循环：从1开始即可
        // 内存循环：不断从后往前看 第一个元素无需看了
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                // 从后往前进行比较 两两比较
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
