package com.sunjinwei.sort;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 2);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] tem = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                tem[i] = nums[p1];
                p1++;
            } else {
                tem[i] = nums[p2];
                p2++;
            }
            i++;
        }
        while (p1 <= mid) {
            tem[i] = nums[p1];
            i++;
            p1++;
        }
        while (p2 <= right) {
            tem[i] = nums[p2];
            i++;
            p2++;
        }

        for (int j = 0; j < tem.length; j++) {
            nums[left + j] = tem[j];
        }
    }

}
