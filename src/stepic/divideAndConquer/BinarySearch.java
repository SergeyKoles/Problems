package stepic.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

  private static int[] A;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer a = new StringTokenizer(br.readLine());
      StringTokenizer b = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(a.nextToken());
      int k = Integer.parseInt(b.nextToken());
      A = new int[n];
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(a.nextToken());
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < k; i++) {
        sb.append(binarySearch(A, Integer.parseInt(b.nextToken()))).append(" ");
      }
    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  public static int binarySearch(int[] A, int e) {
    int n = A.length;
    return binarySearch(e, 0, n - 1, A);
  }

  // like in java.util.Arrays.binarySearch
  private static int binarySearch(int e, int fromIndex, int toIndex, int[] array) {
    int l = fromIndex;
    int h = toIndex - 1;

    while (l <= h) {
      int mid = (fromIndex + toIndex) >>> 1;
      int val = array[mid];
      if (val < e)
        l = mid + 1;

      else if (val > e)
        h = mid - 1;
      else
        return mid;
    }
    return -1;
  }

  // too slow
  private static int binarySearchRecursion(int e, int fromIndex, int toIndex, int[] array) {
    if (fromIndex > toIndex) {
      return -1;
    }
    int index = (fromIndex + toIndex) >>> 1;
    if (array[index] == e) {
      return index + 1;
    }
    return array[index] < e ?
            binarySearchRecursion(e, fromIndex + 1, toIndex, array) :
            binarySearchRecursion(e, fromIndex, toIndex - 1, array);
  }
}
