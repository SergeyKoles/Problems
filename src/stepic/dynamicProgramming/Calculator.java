package stepic.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * � ��� ���� ����������� �����������, ������� ����� ��������� ����� ��� �������� � ������� ������ x: �������� x �� 2x, 3x ��� x+1.
 * �� ������� ������ ����� 1<=n<=105 ���������� ����������� ����� �������� k, �����������, ����� �������� n �� 1.
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

    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }
}
