package com.sunjinwei.sort;

/**
 * 冒泡排序：
 * 思想：
 * 每次从左往右 两两比较，那么最右边的位置就是最大值；
 * 以此类推 倒数第二个位置就是第二大的
 */
public class BubbleSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
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
