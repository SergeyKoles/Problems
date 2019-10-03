package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ���� ����� ����� 1?n?10^5 � ������ A[1�n], ���������� ��������������� ����� �����, �� ������������� 10^9.
 * ������� ���������� �������������� ��������������������� � A.
 * � ������ ������ �������� � ����� k, �� ������ � � ������� 1?i1<i2<�<ik?n (����� �������, A[i1]?A[i2]?�?A[in]).
 *
 * Sample Input: *
 * 5
 * 5 3 4 4 2
 * Sample Output: *
 * 4
 * 1 3 4 5
 */
public class LNonIS {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      int[] A = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      System.out.println(lNonIs(A));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int[] lNonIs(int[] A){
    return A;
  }
}
