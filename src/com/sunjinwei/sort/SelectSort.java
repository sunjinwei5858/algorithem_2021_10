package com.sunjinwei.sort;

/**
 * 选择排序
 * 思想：每次把最小值放到左边第一个位置
 */
public class SelectSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 假设外层循环的第i个元素就是最小值
            int minIndex = i;
            // 内存循环从i+1开始
            for (int j = i + 1; j < nums.length; j++) {
                // 将i和内层循环进行比较
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
