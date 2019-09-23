package sedgewick.sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import sedgewick.sorting.testData.Generate;

public abstract class Sort {

  public static final String FILE_NAME = "src\\sedgewick\\sorting\\testData\\input.txt";

  static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]);
    }
    System.out.println();
  }

  static String[] initArray(String size) {
    String[] a = null;
    switch (size) {
      case ("small"):
        new Generate().run(15);
        break;
      case ("middle"):
        new Generate().run(10_000);
        break;
      case ("large"):
        new Generate().run(100_000);
        break;
    }
    try (BufferedReader in = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
      a = in.readLine().split("");
    } catch (IOException e) {
    }
    return a;
  }

  static boolean isSorted(Comparable[] a) {
    Comparable[] b = Arrays.copyOf(a, a.length);
    Arrays.sort(b);
    return Arrays.equals(a, b);
  }
}
