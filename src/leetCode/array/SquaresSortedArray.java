package leetCode.array;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of
 * each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10] Output: [0,1,9,16,100] Example 2:
 *
 * Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000 -10000 <= A[i] <= 10000 A is sorted in non-decreasing order.
 */

public class SquaresSortedArray {

  public static void main(String[] args) {
    int A[] = {-4,-1,0,3,10};
    System.out.println(Arrays.toString(new SquaresSortedArray().sortedSquares(A)));
  }

  public int[] sortedSquares(int[] A) {
    int n = 0;
    int k = A.length - 1;
    int[] result = new int[A.length];
    for (int i = A.length - 1; i >= 0; i--) {
      result[i] = Math.abs(A[n]) > Math.abs(A[k]) ? A[n] * A[n++] : A[k] * A[k--];
    }
    return result;
  }
}
