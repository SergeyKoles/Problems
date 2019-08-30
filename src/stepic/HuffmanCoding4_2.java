package stepic;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

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
 * abacabad
 * zzzzaaazzzaattttrufffklllllq
 * Sample Output 2:
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */
public class HuffmanCoding4_2 {
  private Map<Character, Integer> table = new TreeMap<>();
  private Map<String, Integer> codeTable = new TreeMap<>();
  private TreeMap<Integer, TreeSet<String>> sortByValue = new TreeMap<>();
  private int numOfLeters;
  private int lengthOfEncodedString;

  public static void main(String[] args) {
    HuffmanCoding4_2 cod = new HuffmanCoding4_2();

    Scanner in = new Scanner(System.in);
    String s = in.next();

//    System.out.println(cod.numOfLeters + " " + cod.lengthOfEncodedString);
//    cod.codeTable.forEach((key, value) -> System.out.println(key + ": " + value));
    System.out.println(cod.encode(s));
  }

  private String encode(String s) {
    for (int i = 0; i < s.length(); i++) {
      table.merge(s.charAt(i), 1, Integer::sum);
    }
    numOfLeters = table.size();
    table.forEach((key, value) -> sortByValue.computeIfAbsent(value, k -> new TreeSet<>()).add(key.toString()));
//    table.forEach((key, value) -> System.out.println(key + ": " + value));
    sortByValue.forEach((key, value) -> System.out.println(key + ": " + value));

    StringBuilder sb = new StringBuilder();
    while (sortByValue.size() > 2) {
      Map.Entry<Integer, TreeSet<String>> entry = sortByValue.firstEntry();
      TreeSet<String> val = entry.getValue();
      Integer key = entry.getKey();
      if (val.size() == 1) {
        // get the lowest value of the entry
        sb.append(val.first());
        // remove entry because it's empty now
        sortByValue.remove(key);
        // get the second lowest entry
        entry = sortByValue.firstEntry();
        val = entry.getValue();
        sb.append(val.pollFirst());
        Integer newKey = key + entry.getKey();
        if (val.isEmpty())
          sortByValue.remove(entry.getKey());
//        TreeSet<String> newValue = new TreeSet<>();
//        newValue.add(sb.toString());
        sortByValue.computeIfAbsent(newKey, k -> new TreeSet<>()).add(sb.toString());
        sb.setLength(0);
      } else if (val.size() > 1) {
        sb.append(val.pollFirst());
        sb.append(val.pollFirst());
        if (val.isEmpty())
          sortByValue.remove(key);
//        TreeSet<String> newValue = new TreeSet<>();
//        newValue.add(sb.toString());
//        sortByValue.put(key * 2, newValue);
        sortByValue.computeIfAbsent(key * 2, k -> new TreeSet<>()).add(sb.toString());
        sb.setLength(0);
      }
    }
    sortByValue.forEach((key, value) -> System.out.println(key + ": " + value));
    sb.append(sortByValue.pollFirstEntry().getValue().first());
    sb.append(sortByValue.pollFirstEntry().getValue().first());
    System.out.println(sb.toString());
    return "";
  }
}


//    LinkedHashMap<Character, Integer> sortByValueTable   = table.entrySet().stream()
//            .sorted(Map.Entry.<Character, Integer>comparingByValue()
//                    .reversed())
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));
//    sortByValueTable.forEach((key, value) -> System.out.println(key + ": " + value));