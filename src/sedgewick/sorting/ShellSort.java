package sedgewick.sorting;

public class ShellSort extends Sort {
  public static long sort(Comparable[] a) { // Sort a[] into increasing order.
    long start = System.currentTimeMillis();

    int N = a.length;
    int h = 1;
    while (h < N / 3)
      h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
    while (h >= 1) { // h-sort the array
      for (int i = h; i < N; i++) { // insert a[i] among a[i-h], a[i-2*h], a[i-3*h] ...
        for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
          exch(a, j, j - h);
        }
      }
      h = h / 3;
    }

    long finish = System.currentTimeMillis();
    return finish - start;
  }

  public static void main(String[] args) {
    String[] s = initArray("small");
    System.out.println(sort(s) + " ms");
    if (!isSorted(s)) {
      throw new AssertionError();
    }
    show(s);

    String[] m = initArray("middle");
    System.out.println(sort(m) + " ms");
    if (!isSorted(m)) {
      throw new AssertionError();
    }
    show(m);

    String[] l = initArray("large");
    System.out.println(sort(l) + " ms");
    if (!isSorted(l)) {
      throw new AssertionError();
    }
    show(l);
  }
}
