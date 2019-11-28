package stepic.priorityQueue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HeapBuilding {

  private static int[] A;
  private static List<String> result = new ArrayList<>();
  private static int size;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      size = Integer.parseInt(br.readLine());
      A = new int[size];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < size; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      buildHeap();
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void buildHeap() {
    for (int i = size / 2; i >= 0; i--) {
      siftDown(i);
    }
    System.out.println(result.size());
    result.forEach(System.out::println);
  }

  private static void siftDown(int i) {
    int max = i;
    int l = left(i);
    int r = right(i);
    if (l < size && A[l] < A[max]) max = l;
    if (r < size && A[r] < A[max]) max = r;
    if (i != max) {
      result.add(i + " " + max);
      swap(i, max);
      siftDown(max);
    }
  }

  private static void swap(int i1, int i2) {
    int tmp = A[i1];
    A[i1] = A[i2];
    A[i2] = tmp;
  }

  private static int left(int i) {
    return 2 * i + 1;
  }

  private static int right(int i) {
    return 2 * i + 2;
  }
}
