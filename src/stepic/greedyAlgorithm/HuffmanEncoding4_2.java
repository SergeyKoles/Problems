package stepic.greedyAlgorithm;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ѕо данной непустой строке s длины не более 10^4, состо€щей из строчных букв латинского алфавита, постройте оптимальный беспрефиксный код.
 * ¬ первой строке выведите количество различных букв k, встречающихс€ в строке, и размер получившейс€ закодированной строки.
 * ¬ следующих k строках запишите коды букв в формате "letter: code".
 * ¬ последней строке выведите закодированную строку.
 * <p>
 * Sample Input 1:
 * a
 * Sample Output 1:
 * 1 1
 * a: 0
 * 0
 * Sample Input 2:
 * <p>
 * abacabad
 * Sample Output 2:
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */
//zzzzaaazzzaattttrufffklllllq
// accepted  6 20
// bbbeeeepp  oor!
public class HuffmanEncoding4_2 {

  private Map<Character, Integer> table = new TreeMap<>();
  private Map<Character, String> dictionary = new TreeMap<>();

  public static void main(String[] args) {
    HuffmanEncoding4_2 cod = new HuffmanEncoding4_2();

    Scanner in = new Scanner(System.in);
    String s = in.next();

    String encodedStr = cod.encode(s);
    int lengthOfEncodedString = encodedStr.length();
    System.out.println(cod.dictionary.size() + " " + lengthOfEncodedString);
    cod.dictionary.forEach((key, value) -> System.out.println(key + ": " + value));
    System.out.println(encodedStr);
  }

  public String encode(String s) {
    PriorityQueue<Simbol> queue = new PriorityQueue<>(
        (o1, o2) -> o2.frequency.compareTo(o1.frequency));

    for (int i = 0; i < s.length(); i++) {
      table.merge(s.charAt(i), 1, Integer::sum);
    }
    table.forEach((k, v) -> queue.add(new Simbol(k, -v)));

    if (queue.size() == 1) {
      dictionary.put(s.charAt(0), "0");
      return generateEncodedString(s);
    }
    StringBuilder sb = new StringBuilder();
    while (queue.size() > 2) {
      Simbol s1 = queue.poll();
      Simbol s2 = queue.poll();
      // the first has to be the shortest tree
      if(s1.ch.length() < s2.ch.length()){
        sb.append(s1.ch);
        sb.append(s2.ch);
      }else{
        sb.append(s2.ch);
        sb.append(s1.ch);
      }
      queue.offer(new Simbol(sb.toString(), s1.frequency + s2.frequency));
      sb.setLength(0);
      if (queue.size() == 1) {
        generateDictionary(queue.poll().ch, 0);
        return generateEncodedString(s);
      }
    }
    generateDictionary(queue.poll().ch, 0);
    generateDictionary(queue.poll().ch, 1);
    return generateEncodedString(s);
  }

  private void generateDictionary(String s, int prefix) {
    int p = prefix ^ 1;
    int j = 0;
    StringBuilder sb = new StringBuilder();
    sb.append(prefix);
    String str = s;
    while (true) {
      if (str.length() == 1) {
        dictionary.put(str.charAt(0), sb.toString());
        break;
      }
      dictionary.put(str.charAt(0), sb.append(p).toString());
      sb.deleteCharAt(++j);
      sb.append(prefix);
      str = str.substring(1);
    }
  }

  private String generateEncodedString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append(dictionary.get(s.charAt(i)));
    }
    return sb.toString();
  }

  private class Simbol {

    private String ch;
    private Integer frequency = 0;

    public Simbol(char ch, Integer frequency) {
      this.ch = String.valueOf(ch);
      this.frequency = frequency;
    }

    public Simbol(String str, Integer frequency) {
      this.ch = str;
      this.frequency = frequency;
    }

    @Override
    public String toString() {
      return ch + " : " + frequency;
    }
  }
}