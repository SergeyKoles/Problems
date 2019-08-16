package leetCode.array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of
 * A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be
 * accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{3, 1, 2, 4})));
  }

  public int[] sortArrayByParity(int[] A) {
    int head = 0;
    int tail = A.length - 1;
    int[] B = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      if ((A[i] & 1) == 0) {
        B[head] = A[i];
        head++;
      } else {
        B[tail] = A[i];
        tail--;
      }
    }
    return B;
  }
}
