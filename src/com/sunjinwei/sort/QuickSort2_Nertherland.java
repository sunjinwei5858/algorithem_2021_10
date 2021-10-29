package com.sunjinwei.sort;

import com.sunjinwei.linkedlist.Is_Loop;

public class QuickSort2_Nertherland {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left + (int) (Math.random() * (right - left + 1));
        swap(nums, i, right);

        int[] pivot = partition(nums, left, right);

        quickSort(nums, left, pivot[0] - 1);
        quickSort(nums, pivot[1] + 1, right);
    }

    /**
     * 返回partition数组
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int[] partition(int[] nums, int left, int right) {
        // 声明遍历的索引
        int i = left;
        // 小于区的结束位置 left-1 因为可能不存在
        int less = left - 1;
        // 大于区的开始位置
        int more = right;

        while (i < right) {
            if (nums[i] < nums[right]) {
                less++;
                swap(nums, less, i);
                i++;
            } else if (nums[i] > nums[right]) {
                more--;
                swap(nums, more, i);
            } else {
                i++;
            }
        }
        // 将分界点置换到正确的位置
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
