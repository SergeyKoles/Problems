package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChainHashing {

  private static final String ADD = "add";
  private static final String DEL = "del";
  private static final String FIND = "find";
  private static final String CHECK = "check";
  private static final String YES = "yes";
  private static final String NO = "no";
  private static int MOD = 1_000_000_007;
  private static int x = 263;
  private static int maxStringLength = 15;

  private static Map<Integer, LinkedList<String>> table;
  private static int tableSize;
  private static long[] auxiliaryArray;


  public static void main(String[] args) {
//    testInput(args);
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      tableSize = m;
      table = new HashMap<>();
      auxiliaryArray = getAuxiliaryArray();
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        String requestCode = st.nextToken();
        String string = st.nextToken();
        process(requestCode, string);
      }
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void testInput(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int m = Integer.parseInt(st.nextToken());
      tableSize = m;
      auxiliaryArray = getAuxiliaryArray();
      System.out.println(testHash(s));
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static int testHash(String s) {
    return (int) getHash(s);
  }

  private static void process(String req, String str) {
    switch (req) {
      case (ADD):
        add(str);
        break;
      case (DEL):
        delete(str);
        break;
      case (FIND):
        find(str);
        break;
      case (CHECK):
        System.out.println(check(Integer.parseInt(str)));
        break;
    }
  }

  private static void delete(String str) {
    int index = (int) getHash(str);
    LinkedList<String> values = table.get(index);
    if (values != null) {
      values.remove(str);
    }
  }

  private static String check(int index) {
    LinkedList<String> values = table.get(index);
    if (values != null && !values.isEmpty()) {
      return listToString(values);
    }
    return "";
  }

  private static String listToString(List<String> strs) {
    if (strs != null && !strs.isEmpty())
      return String.join(" ", strs);
    else return "";
  }

  private static void find(String str) {
    int index = (int) getHash(str);
    LinkedList<String> values = table.get(index);
    if (values == null || !values.contains(str))
      System.out.println(NO);
    else
      System.out.println(YES);
  }

  private static void add(String str) {
    int index = (int) getHash(str);
    LinkedList<String> values = table.computeIfAbsent(index, k -> new LinkedList<>());
    if (!values.contains(str)) {
      values.addFirst(str);
    }
  }

  private static long getHash(String str) {
    char[] chars = str.toCharArray();
    long sum = 0;
    long m = tableSize;
    for (int i = 0; i < chars.length; i++) {
      sum += ((chars[i] % MOD) * (auxiliaryArray[i] % MOD)) % MOD;
    }
    return sum % MOD % m;
  }

  private static long[] getAuxiliaryArray() {
    long[] indexes = new long[maxStringLength];
    for (int i = 0; i < maxStringLength; i++) {
      indexes[i] = binPow(x, i);
    }
    return indexes;
  }

  private static long binPow(long base, long p) {
    long pow = p;
    if (pow == 0)
      return 1;
    if (pow == 1)
      return base;
    if (pow % 2 == 0) {
      long t = binPow(base, pow / 2);
      return t * t % MOD;
    } else
      return binPow(base, --pow) * base % MOD;
  }
}