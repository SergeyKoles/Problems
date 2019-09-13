package sedgewick.sorting;

public class SelectionSort extends Frame {
  public static void sort(Comparable[] a) {
  }


  public static void main(String[] args) {
    String[] a = initArray("small");
    sort(a);
//      assert isSorted(a);
    show(a);
  }
}
