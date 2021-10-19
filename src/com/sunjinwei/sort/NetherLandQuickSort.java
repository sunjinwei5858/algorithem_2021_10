package com.sunjinwei.sort;

/**
 * 荷兰国旗思路实现快排
 */
public class NetherLandQuickSort {

    public void sort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 打乱
        int i = left + (int) (Math.random() * (right - left + 1));
        swap(nums, i, right);

        // 荷兰国旗partition 返回等于区索引数组
        int[] pivot = partition(nums, left, right);

        quickSort(nums, left, pivot[0] - 1);
        quickSort(nums, pivot[1] + 1, right);
    }

    private int[] partition(int[] nums, int left, int right) {
        // 小于区开始索引
        int less = left - 1;
        // 遍历开始索引
        int i = left;
        // 大于区索引
        int more = right;
        // 处理
        while (i < right) {
            // 小于区：[left, less] 左闭右闭
            if (nums[i] < nums[right]) {
                less++;
                swap(nums, i, less);
                i++;
            } else if (nums[i] > nums[right]) {
                // 大于区[more, right]
                more--;
                swap(nums, i, more);
            } else {
                i++;
            }
        }
        // 此时将right放到正确的pivot等于区位置
        swap(nums, left + 1, right);
        return new int[]{left + 1, more};
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
