package stepic;


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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PriorityQueue4_3 {

  private List<Integer> a = new ArrayList<>();
  private static final String INSERT = "Insert";
  private int n = 0;

  public static void main(String[] args) {

    PriorityQueue4_3 pq = new PriorityQueue4_3();
    pq.a.add(Integer.MAX_VALUE);

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){

    int m = Integer.parseInt(br.readLine());

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
    a.add(n, v);
    siftUp(n);
  }

  public int extractMax() {
    int e = a.get(n);
    int max = a.remove(1);
    a.add(1, e);
    n--;
    siftDown(1);
    return max;
  }

  private void siftDown(int i) {
    int j;
    while ((2 * i) <= n) {
      j = i;
      if (a.get(2 * i) > a.get(j)) {
        j = 2 * j;
      }
      if ((2 * i + 1) <= n && (a.get(2 * i + 1) > a.get(j))) {
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
    while (i > 1 && a.get(i / 2) < a.get(i)) {
      exch(i);
      i = i / 2;
    }
  }

  private void exch(int i) {
    int tmp = a.remove(i);
    a.add(i, a.get(i / 2));
    a.remove(i / 2);
    a.add(i / 2, tmp);
  }

  private void exch(int i, int j) {
    int tmp = a.get(i);
    int e = a.get(j);
    a.remove(i);
    a.add(i, e);
    a.remove(j);
    a.add(j, tmp);
  }
}
