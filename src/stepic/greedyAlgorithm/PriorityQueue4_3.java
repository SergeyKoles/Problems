package stepic.greedyAlgorithm;

/**
   Insert
   200
   Insert
   10
   Insert
   5
   Insert
   500
   ExtractMax
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PriorityQueue4_3 {

  private int[] a;
  private static final String INSERT = "Insert";
  private int n = 0;

  public static void main(String[] args) {

    PriorityQueue4_3 pq = new PriorityQueue4_3();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

      int m = Integer.parseInt(br.readLine());
      pq.a = new int[m];

      StringTokenizer oper;
      while (m-- > 0) {
        oper = new StringTokenizer(br.readLine());
        if (oper.nextToken().equals(INSERT)) {
          pq.insert(Integer.parseInt(oper.nextToken()));
        } else {
          System.out.println(pq.extractMax());
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void insert(int v) {
    n++;
    a[n] = v;
    siftUp(n);
  }

  public int extractMax() {
    int max = a[1];
    a[1] = a[n];
    n--;
    siftDown(1);
    return max;
  }

  private void siftDown(int i) {
    int j;
    while ((2 * i) <= n) {
      j = i;
      if (a[2 * i] > a[j]) {
        j = 2 * j;
      }
      if ((2 * i + 1) <= n && (a[2 * i + 1] > a[j])) {
        j = 2 * i + 1;
      }
      if (j == i) {
        break;
      } else {
        exch(i, j);
        i = j;
      }
    }
  }

  private void siftUp(int i) {
    while (i > 1 && a[i / 2] < a[i]) {
      exch(i);
      i = i / 2;
    }
  }

  private void exch(int i) {
    int tmp = a[i];
    a[i] = a[i / 2];
    a[i / 2] = tmp;
  }

  private void exch(int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
