package sedgewick.sorting;

public class SelectionSort extends Frame {

  public static long sort(Comparable[] a) { // Sort a[] into increasing order.
    long start = System.currentTimeMillis();
    int N = a.length; // array length
    for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in a[i+1...N).
      int min = i; // index of minimal entr.
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
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
