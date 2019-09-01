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
public class HuffmanCoding4_2 {
  private Map<Character, Integer> table = new TreeMap<>();
  private Map<Character, String> dictionary = new TreeMap<>();
  private TreeMap<Integer, TreeSet<String>> sortedByValue = new TreeMap<>();
  private int numOfLeters;


  public static void main(String[] args) {
    HuffmanCoding4_2 cod = new HuffmanCoding4_2();

    Scanner in = new Scanner(System.in);
    String s = in.next();

    String encodedStr = cod.encode(s);
    int lengthOfEncodedString = encodedStr.length();
    System.out.println(cod.dictionary.size() + " " + lengthOfEncodedString);
    cod.dictionary.forEach((key, value) -> System.out.println(key + ": " + value));
    System.out.println(encodedStr);

  }

  public String encode(String s) {
    for (int i = 0; i < s.length(); i++) {
      table.merge(s.charAt(i), 1, Integer::sum);
    }
    numOfLeters = table.size();
    table.forEach((key, value) -> sortedByValue.computeIfAbsent(value, k -> new TreeSet<>()).add(key.toString()));
//    sortedByValue.forEach((key, value) -> System.out.println(key + ": " + value));

    StringBuilder sb = new StringBuilder();
    while (true) {
      Map.Entry<Integer, TreeSet<String>> entry;
      if (sortedByValue.size() == 2) {
        if (sortedByValue.firstEntry().getValue().size() > 2) {
          entry = sortedByValue.firstEntry();
        } else if (sortedByValue.lastEntry().getValue().size() > 2) {
          entry = sortedByValue.lastEntry();
        } else
          break;
      }else
        entry = sortedByValue.firstEntry();
        TreeSet<String> val = entry.getValue();
        Integer key = entry.getKey();
        if (val.size() == 1) {
          // get the lowest value of the entry
          sb.append(val.first());
          // remove entry because it's empty now
          sortedByValue.remove(key);
          // get the second lowest entry
          entry = sortedByValue.firstEntry();
          val = entry.getValue();
          sb.append(val.pollFirst());
          Integer newKey = key + entry.getKey();
          if (val.isEmpty())
            sortedByValue.remove(entry.getKey());
          sortedByValue.computeIfAbsent(newKey, k -> new TreeSet<>()).add(sb.toString());
          sb.setLength(0);
        } else if (val.size() > 1) {
          sb.append(val.pollFirst());
          sb.append(val.pollFirst());
          sortedByValue.computeIfAbsent(key * 2, k -> new TreeSet<>()).add(sb.toString());
          if (val.isEmpty()) {
            sortedByValue.remove(key);
          }
          sb.setLength(0);
        }

    }
    sortedByValue.forEach((key, value) -> System.out.println(key + ": " + value));
    generateDictionary(sortedByValue.pollFirstEntry().getValue().first(), 0);
    generateDictionary(sortedByValue.pollFirstEntry().getValue().first(), 1);

//    System.out.println(sb.toString());
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
}


//    LinkedHashMap<Character, Integer> sortByValueTable   = table.entrySet().stream()
//            .sorted(Map.Entry.<Character, Integer>comparingByValue()
//                    .reversed())
//            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));
//    sortByValueTable.forEach((key, value) -> System.out.println(key + ": " + value));