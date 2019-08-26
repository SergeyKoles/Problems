package leetCode.array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */

public class MergeSortedArray {
//  merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
//  merge(new int[]{1, 2, 3, 8, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
//  merge(new int[]{4, 5, 6, 8, 0, 0, 0}, 4, new int[]{1, 2, 3}, 3);
//  merge(new int[]{7, 7, 7, 7, 0, 0, 0}, 4, new int[]{2, 5, 6}, 3);
//  merge(new int[]{1, 3, 5, 7, 0, 0, 0}, 4, new int[]{2, 4, 6}, 3);
//  merge(new int[]{1, 3, 5, 7, 0, 0, 0}, 4, new int[]{8, 8, 8}, 3);
//  merge(new int[]{1, 3, 5, 7, 0, 0, 0}, 4, new int[]{4, 4, 4}, 3);
//  merge(new int[]{1, 3, 5, 7, 0, 0, 0}, 4, new int[]{6, 6, 6}, 3);
//  merge(new int[]{1, 1}, 2, new int[]{}, 0);
//  merge(new int[]{1}, 1, new int[]{}, 0);
//  merge(new int[]{1, 0}, 1, new int[]{2}, 1);
//  merge(new int[]{0}, 0, new int[]{1}, 1);
//  merge(new int[]{0, 0, 0, 0, 0}, 0, new int[]{1, 2, 3, 4, 5}, 5);

  public static void main(String[] args) {
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    new MergeSortedArray().merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }

// Two pointers
  private void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = m + n - 1;
    while (n > 0) {
      nums1[k--] = (m == 0 || nums2[n - 1] > nums1[m - 1]) ? nums2[--n] : nums1[--m];
    }
  }
}