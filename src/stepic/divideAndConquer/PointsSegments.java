package stepic.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на прямой, соответственно.
 * Следующие n строк содержат по два целых числа ai и bi (ai≤bi) — координаты концов отрезков.
 * Последняя строка содержит m целых чисел — координаты точек. Все координаты не превышают 10^8 по модулю.
 * Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
 * Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 * <p>
 * <p>
 * Sample Input:
 * 2 3
 * 0 5
 * 7 10
 * 1 6 11
 * Sample Output:
 * 1 0 0
 */

public class PointsSegments {

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      Segment[] lp = new Segment[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        lp[i] = new Segment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }
      quickSortLP(lp, 0, lp.length - 1);

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        System.out.print(segmentCounter(lp, Integer.parseInt(st.nextToken())) + " ");
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int segmentCounter(Segment[] lp, int p) {
    int indexL = searchL(lp, p);

    if (indexL > -1) {
      Segment[] rp = Arrays.copyOfRange(lp, 0, indexL + 1);
      quickSortRP(rp, 0, rp.length - 1);
      int indexR = searchR(rp, p);
      if (indexR > -1) {
        return indexL - indexR + 1;
      }
    }
    return 0;
  }

  private static void quickSortLP(Segment[] s, int l, int r) {
    if (r <= l) return;
    int j = partitionLP(s, l, r);
    quickSortLP(s, l, j - 1);
    quickSortLP(s, j + 1, r);
  }

  private static int partitionLP(Segment[] s, int l, int r) {
    int i = l;
    int j = r + 1;

    int pivot = s[l].l;
    while (true) {
      while (s[++i].l < pivot) {
        if (i == r) break;
      }
      while (pivot < s[--j].l) {
        if (j == l) break;
      }
      if (i >= j) break;
      swap(s, i, j);
    }
    swap(s, l, j);
    return j;
  }

  private static void quickSortRP(Segment[] s, int l, int r) {
    if (r <= l) return;
    int j = partitionRP(s, l, r);
    quickSortRP(s, l, j - 1);
    quickSortRP(s, j + 1, r);
  }

  private static int partitionRP(Segment[] s, int l, int r) {
    int i = l;
    int j = r + 1;

    int pivot = s[l].r;
    while (true) {
      while (s[++i].r < pivot) {
        if (i == r) break;
      }
      while (pivot < s[--j].r) {
        if (j == l) break;
      }
      if (i >= j) break;
      swap(s, i, j);
    }
    swap(s, l, j);
    return j;
  }

  private static void swap(Segment[] s, int l, int r) {
    Segment tmp = s[l];
    s[l] = s[r];
    s[r] = tmp;
  }

  private static int searchL(Segment[] s, int p) {
    int l = 0;
    int r = s.length - 1;
    int index = -1;

    while (l <= r) {
      int mid = (l + r) >>> 1;
      if (s[mid].l > p) {
        r = mid - 1;
      } else if (s[mid].l <= p) {
        l = mid + 1;
        index = mid;
      }
    }
    return index;
  }

  private static int searchR(Segment[] s, int p) {
    int l = 0;
    int r = s.length - 1;
    int index = -1;
    while (l <= r) {
      int mid = (l + r) >>> 1;
      if (s[mid].r < p) {
        l = mid + 1;
      } else if (s[mid].r >= p) {
        r = mid - 1;
        index = mid;
      }
    }
    return index;
  }

  private static class Segment {

    int l;
    int r;

    public Segment(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public String toString() {
      return "{" + l + " - " + r + "}";
    }
  }
}
