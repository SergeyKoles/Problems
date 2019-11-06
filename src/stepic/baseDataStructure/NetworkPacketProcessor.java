package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ��������� ������� �������
 * ����������� ���������� ������� �������.
 * ����. ������ ������ size � ����� ������� n, � ����� ��� ������������������ arrival1, . . . , arrivaln �
 * duration1, . . . , durationn, ������������ ����� ����������� � ������������ ��������� n �������.
 * �����. ��� ������� �� ������ n ������� ����������
 * ������� ����� ������ ��� ��������� ��� -1, ���� �����
 * �� ��� ��������� (��� ���������� � ������, ����� �����
 * ��������� � ������, ����� � ������ ���������� ���
 * ��������� size �������).
 * <p>
 * ������ �����. ������ ������ ����� �������� ������ ������ size �
 * ����� ������� n. ������ �� ��������� n ����� �������� ���
 * �����: ����� arrivali �������� i-�� ������ � ����� durationi
 * ,
 * ����������� �� ��� ���������. �������������, ��� arrival1 <=
 * arrival2 <= � � � <= arrivaln. ��� ���� ����� ���������, ���
 * arrivali-1 = arrivali
 * . � ����� ������ �������, ��� ����� i - 1 �������� ������ ������ i.
 * ������ ������. ��� ������� �� n ������� �������� �����, �����
 * ��������� ����� ��� ������������, ��� -1, ���� ����� ��� ��������.
 * �����������. ��� ����� �� ����� �����. 1 <= size <= 10^5
 * ; 0 <= n <= 10^5
 * ;
 * 0 <= arrivali <= 10^6
 * ; 0 <= durationi <= 10^3
 * ; arrivali <= arrivali+1 ��� ����
 * 1 <= i <= n - 1.
 * <p>
 * ������.
 * ����:
 * 1 0
 * �����:
 * ���� ������� ���, �������� ������ �� �����.
 * ������.
 * ����:
 * 1 1
 * 0 0
 * �����:
 * 0
 * ����� �������� � ������ ������� 0, � ��������� ��� �� �����
 * ��� ������������.
 * ������.
 * ����:
 * 1 2
 * 0 1
 * 0 1
 * �����:
 * 0
 * -1
 * ������ ����� �������� � ������ ������� 0, ������ ����� �������� ����� � ������ ������� 0, �� ��� ��������,
 * ��������� ����� � ���� ������ ��������� �������� (������ �������).
 * ������ ����� ����� �������������� � ������ ������� 0, ������ ��� ��������.
 * ������.
 * ����:
 * 1 2
 * 0 1
 * 1 1
 * �����:
 * 0
 * 1
 */

public class NetworkPacketProcessor {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int size = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      Packet[] packets = new Packet[n];
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        packets[i] = new Packet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }
      new NetworkPacketProcessor().process(packets, size);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private void process(Packet[] p, int buf) {

  }

  private static class Packet {
    private int arr; // arrival  0 <= arrivali <= 10^6
    private int dur; // duration 0 <= durationi <= 10^3

    private Packet(int arr, int dur) {
      this.arr = arr;
      this.dur = dur;
    }
  }
}
