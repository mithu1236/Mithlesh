package com.kumar.fhn;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of nums1 and nums2 arrays
        int i = m - 1; // pointer for nums1
        int j = n - 1; // pointer for nums2
        int k = m + n - 1; // pointer for merged array in nums1

        // While there are elements to be checked in both arrays
        while (i >= 0 && j >= 0) {
            // Compare the current elements of nums1 and nums2
            // and put the larger one at the end of nums1
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // If there are remaining elements in nums1, they are already in place
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 2, 2, 3, 5, 6]

        // Example 2
        int[] nums1_2 = {1};
        int[] nums2_2 = {};
        m = 1;
        n = 0;
        solution.merge(nums1_2, m, nums2_2, n);
        System.out.println(Arrays.toString(nums1_2)); // Output: [1]

        // Example 3
        int[] nums1_3 = {0};
        int[] nums2_3 = {1};
        m = 0;
        n = 1;
        solution.merge(nums1_3, m, nums2_3, n);
        System.out.println(Arrays.toString(nums1_3)); // Output: [1]
    }
}

