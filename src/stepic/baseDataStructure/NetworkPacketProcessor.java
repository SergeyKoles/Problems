package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Обработка сетевых пакетов
 * Реализовать обработчик сетевых пакетов.
 * Вход. Размер буфера size и число пакетов n, а также две последовательности arrival1, . . . , arrivaln и
 * duration1, . . . , durationn, обозначающих время поступления и длительность обработки n пакетов.
 * Выход. Для каждого из данных n пакетов необходимо
 * вывести время начала его обработки или -1, если пакет
 * не был обработан (это происходит в случае, когда пакет
 * поступает в момент, когда в буфере компьютера уже
 * находится size пакетов).
 * <p>
 * Формат входа. Первая строка входа содержит размер буфера size и
 * число пакетов n. Каждая из следующих n строк содержит два
 * числа: время arrivali прибытия i-го пакета и время durationi
 * ,
 * необходимое на его обработку. Гарантируется, что arrival1 <=
 * arrival2 <= · · · <= arrivaln. При этом может оказаться, что
 * arrivali-1 = arrivali
 * . В таком случае считаем, что пакет i - 1 поступил раньше пакета i.
 * Формат выхода. Для каждого из n пакетов выведите время, когда
 * процессор начал его обрабатывать, или -1, если пакет был отброшен.
 * Ограничения. Все числа во входе целые. 1 <= size <= 10^5
 * ; 0 <= n <= 10^5
 * ;
 * 0 <= arrivali <= 10^6
 * ; 0 <= durationi <= 10^3
 * ; arrivali <= arrivali+1 для всех
 * 1 <= i <= n - 1.
 * <p>
 * Пример.
 * Вход:
 * 1 0
 * Выход:
 * Если пакетов нет, выводить ничего не нужно.
 * Пример.
 * Вход:
 * 1 1
 * 0 0
 * Выход:
 * 0
 * Пакет поступил в момент времени 0, и компьютер тут же начал
 * его обрабатывать.
 * Пример.
 * Вход:
 * 1 2
 * 0 1
 * 0 1
 * Выход:
 * 0
 * -1
 * Первый пакет поступил в момент времени 0, второй пакет поступил также в момент времени 0, но был отброшен,
 * поскольку буфер в этот момент полностью заполнен (первым пакетом).
 * Первый пакет начал обрабатываться в момент времени 0, второй был отброшен.
 * Пример.
 * Вход:
 * 1 2
 * 0 1
 * 1 1
 * Выход:
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
