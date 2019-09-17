package sedgewick.sorting.testData;

import static sedgewick.sorting.Sort.FILE_NAME;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {

  public void run(int n) {
    try (PrintWriter printWriter = new PrintWriter(FILE_NAME)) {
      Random random = new Random();
      for (int i = 0; i < n; i++) {
        printWriter.print((char) ('a' + (random.nextInt(26))));
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
