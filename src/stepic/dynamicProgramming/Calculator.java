package stepic.dynamicProgramming;

//import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * � ��� ���� ����������� �����������, ������� ����� ��������� ����� ��� �������� � ������� ������ x: �������� x �� 2x, 3x ��� x+1.
 * �� ������� ������ ����� 1<=n<=10^5 ���������� ����������� ����� �������� k, �����������, ����� �������� n �� 1.
 * �������� k � ������������������ ������������� �����.
 *
 * Sample Input 1:
 *
 * 1
 * Sample Output 1:
 *
 * 0
 * 1
 * Sample Input 2:
 *
 * 5
 * Sample Output 2:
 *
 * 3
 * 1 2 4 5
 * Sample Input 3:
 *
 * 96234
 * Sample Output 3:
 *
 * 14
 * 1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
 */
public class Calculator {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());
      List<Integer> seq = foundMinNumberOfMathOperation(n);
      System.out.println(seq.size() - 1);
      seq.forEach(r -> System.out.print(r + " "));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

//  @Test
  public void test() {
    test(1, 0);
    test(5, 3);
    test(863, 15);
    test(96234, 14);
    test(77759, 25);
    test(11809, 8); // test #8
    test(73409, 9); // test #9
    test(69006, 10); // test #10
    test(100000, 11); // test #11
  }

  private void test(int n, int k) {
    List<Integer> got = foundMinNumberOfMathOperation(n);
    System.out.println((got.size() - 1) == k ? "n: " + n + " + " : String.format("n: %d, got: {%s} - %d, \n expected: %d", n, Arrays.toString(got.toArray()), got.size(), k));
  }

  private static List<Integer> foundMinNumberOfMathOperation(int n) {
    ArrayList<Integer> seq = new ArrayList<>();
    seq.add(n);
    while (n > 1) {
      if (n == 11 || n == 10) {
        seq.add(--n);
      } else if (n % 3 == 0) {
        n /= 3;
        seq.add(n);
      } else if ((n - 1) % 3 == 0) {
        seq.add(--n);
        n/=3;
        seq.add(n);
      } else if (n % 2 == 0) {
        n /= 2;
        seq.add(n);
      } else {
        seq.add(--n);
      }
    }
    Collections.reverse(seq);
    return seq;
  }
}
