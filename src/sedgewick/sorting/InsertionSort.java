package sedgewick.sorting;

/**
 * Unlike that of selection sort, the running time of insertion sort depends on the initial
 * order of the items in the input. For example, if the array is large and its entries are
 * already in order (or nearly in order), then insertion sort is much, much faster than if
 * the entries are randomly ordered or in reverse order.
 *
 * Insertion sort works well for certain types of nonrandom arrays that often arise in
 * practice, even if they are huge.
 * Insertion sort is an excellent method for partially sorted arrays.
 *
 * Typical examples of partially sorted arrays are the
 * following:
 * - An array where each entry is not far from its final position
 * - A small array appended to a large sorted array
 * - An array with only a few entries that are not in place
 *
 * Insertion sort is an efficient method for such arrays
 *
 *
 * Insertion sort uses ~(N^2)/4 compares and ~(N^2)/4 exchanges to sort
 * a randomly ordered array of length N with distinct keys, on the average. The worst
 * case is ~N 2/2 compares and ~(N^2)/2 exchanges and the best case is N - 1 compares
 * and 0 exchanges.
 */

public class InsertionSort extends Sort {

  public static long sort(Comparable[] a) { // Sort a[] into increasing order.
    long start = System.currentTimeMillis();

    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) { // Insert a[i-1], a[i-2], a[i-3] ...
        exch(a, j, j - 1);
      }
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
