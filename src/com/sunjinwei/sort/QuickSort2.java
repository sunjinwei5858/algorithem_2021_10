package com.sunjinwei.sort;

public class QuickSort2 {

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

        int pivot = partition(nums, left, right);

        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        int less = left - 1;

        while (i < right) {
            if (nums[i] <= nums[right]) {
                less++;
                swap(nums, less, i);
            }
            i++;
        }
        // 将分界点置换到正确的位置
        swap(nums, less + 1, right);
        return less + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
