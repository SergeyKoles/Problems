package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Максимум в скользящем окне
 * Найти максимум в каждом окне размера m данного массива чисел
 * A[1 . . . n].
 * Вход. Массив чисел A[1 . . . n] и число 1 ≤ m ≤ n.
 * Выход. Максимум подмассива A[i . . . i + m − 1] для всех 1 ≤
 * i ≤ n − m + 1.
 */
public class MaxInSlidingWindow {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      int m = Integer.parseInt(br.readLine());
      new MaxInSlidingWindow().run(n, m, A);
      System.out.println();
      new MaxInSlidingWindow().run2(n, m, A);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  // using Tree
  private void run(int n, int m, int[] A) {
    TreeSet<Integer> wind = new TreeSet<>();
    for (int i = 0; i < m; i++) {
      wind.add(A[i]);
    }
    System.out.print(wind.last() + " ");
    for (int i = m, j = 0; i < n; i++, j++) {
      wind.remove(A[j]);
      wind.add(A[i]);
      System.out.print(wind.last() + " ");
    }
  }

  // using Deque
  private void run2(int n, int m, int[] A) {
    Deque<Integer> q = new LinkedList<>();
    int i = 0;
    for (; i < m; i++) {
      while (!q.isEmpty() && A[q.peekLast()] < A[i])
        q.removeLast();
      q.add(i);
    }
    for (; i < n; i++) {
      System.out.print(A[q.peek()] + " ");
      while (!q.isEmpty() && q.peek() <= i - m)
        q.removeFirst();
      while (!q.isEmpty() && A[q.peekLast()] < A[i])
        q.removeLast();
      q.add(i);
    }
    System.out.print(A[q.peek()] + " ");
  }
}
