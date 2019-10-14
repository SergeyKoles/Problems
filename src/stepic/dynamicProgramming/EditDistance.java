package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10^2,
 * содержащих строчные буквы латинского алфавита.
 * <p>
 * Sample Input 1:
 * <p>
 * ab
 * ab
 * Sample Output 1:
 * <p>
 * 0
 * Sample Input 2:
 * <p>
 * short
 * ports
 * Sample Output 2:
 * <p>
 * 3
 */
public class EditDistance {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String s1 = br.readLine();
      String s2 = br.readLine();
      System.out.println(editDistanceBU(s1, s2));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int editDistanceBU(String s1, String s2) {
    char[] A = s1.toCharArray();
    char[] B = s2.toCharArray();
    int[][] D = new int[A.length + 1][B.length + 1];
    for (int i = 0; i <= A.length; i++) {
      D[i][0] = i;
    }
    for (int i = 0; i <= B.length; i++) {
      D[0][i] = i;
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; ) {
        int c = A[i] == B[j++] ? 0 : 1;
        D[i + 1][j] = min(D[i][j] + 1, D[i + 1][j - 1] + 1, D[i][j - 1] + c);
      }
    }
    return D[A.length][B.length];
  }

  private static int min(int n1, int n2, int n3) {
    return n1 > n2 ? Math.min(n2, n3) : Math.min(n1, n3);
  }
}
