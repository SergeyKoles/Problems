package stepic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityQueue4_3 {

  private List<Integer> a = new ArrayList<>();

  private int n = a.size();

  public static void main(String[] args) {

    PriorityQueue4_3 pq = new PriorityQueue4_3();

    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    String oper;
    while (m-->0){
      oper = in.next();
      pq.insert(Integer.parseInt(oper));
    }

    pq.a.forEach(e-> System.out.print(e + ", "));
  }

  private void insert(int v) {
    n++;
    a.add(v);
    siftUp(n-1);
  }

  private int exctractMax() {
    int max = a.get(0);
    a.add(0, a.get(n));
    n--;
    siftDown(0);
    return max;
  }

  private void siftDown(int i) {

    int j;
    while ((2 * i) <= n) {
      j = i;
      if (a.get(2 * i) < a.get(j)) {
        j = 2 * j;
      }
      if ((2 * i + 1) <= n && (a.get(2 * i + 1) < a.get(j))) {
        j = 2 * i + 1;
      }
      if (j == i) {
        break;
      } else {
        exch(i, j);
        i = j;
      }
    }

    /*    int j;
    while ((2 * i) <= n) {
      j = i;
      if (a[2 * i] < a[j]) {
        j = 2 * j;
      }
      if ((2 * i + 1) <= n && (a[2 * i + 1] < a[j])) {
        j = 2 * i + 1;
      }
      if (j == i) {
        break;
      } else {
        exch(i, j);
        i = j;
      }
    }*/
  }

  private void siftUp(int i) {

    while (i > 0 && a.get(i / 2) > a.get(i)) {
      exch(i);
      i = i / 2;
    }

    /*    while (i > 1 && a[i / 2] > a[i]) {
      exch(i);
      i = i / 2;
    }*/
  }

  private void exch(int i) {
    int tmp = a.get(i);
    a.add(i, a.get(i / 2));
    a.add(i / 2, tmp);
  }

  private void exch(int i, int j) {
    int tmp = a.get(i);
    a.add(i, a.get(j));
    a.add(j, tmp);
  }
}
