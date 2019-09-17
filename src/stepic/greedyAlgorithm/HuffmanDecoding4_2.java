package stepic.greedyAlgorithm;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HuffmanDecoding4_2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int k = in.nextInt();
    int l = in.nextInt();

//     code -> letter
    Map<String, String> dic = new TreeMap<>();
    String letter;
    String code;
    for (int i = 0; i < k; i++) {
      letter = in.next();
      code = in.next();
      dic.put(code, letter.replace(":", ""));
    }
    String encodedStr = in.next();
    in.close();

    StringBuilder sb = new StringBuilder();
    StringBuilder decodedStr = new StringBuilder();

    for (int i = 0; i < encodedStr.length(); i++) {
      sb.append(encodedStr.charAt(i));
      if (dic.containsKey(sb.toString())){
        decodedStr.append(dic.get(sb.toString()));
        sb.setLength(0);
      }
    }
    System.out.println(decodedStr.toString());
  }

}
