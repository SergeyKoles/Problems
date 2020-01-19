package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

  private static String[] table;
  private static int tableSize;
  private static long[] auxiliaryArray;


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      tableSize = m;
      table = new String[m];
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
    String chain = table[index];
    if (chain != null && chain.contains(str)) {
      chain = chain.replace(str, "");
      table[index] = chain.replace("  ", " ");
    }
  }

  private static String check(int index) {
    String chain = table[index];
    if (chain == null || "".equals(chain)) {
      return "";
    }
    return chain;
  }

  private static void find(String str) {
    int index = (int) getHash(str);
    String chain = table[index];
    if (chain == null || !chain.contains(str))
      System.out.println(NO);
    else
      System.out.println(YES);
  }

  private static void add(String str) {
    int index = (int) getHash(str);
    String chain = check(index);
    if (chain.equals("")) {
      table[index] = str;
    } else
      table[index] = str + " " + chain;
  }

  private static long getHash(String str) {
    char[] chars = str.toCharArray();
    long sum = 0;
    long m = table.length;
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

/*
const long long MOD = 1e9 + 7;

//base ^ p
long long bin_pow(long long base, long long p) {
    if (p == 1) {
        return base;    //Выход из рекурсии.
    }

    if (p % 2 == 0) {
        long long t = bin_pow(base, p / 2);
        return t * t % MOD;
    } else {
        return bin_pow(base, p - 1) * base % MOD;
    }
}
 */

/*
5
12
add world
add HellO
check 4
find World
find world
del world
check 4
del HellO
add luck
add GooD
check 2
del good

 */

/*
[0] => 1
[1] => 263
[2] => 69169
[3] => 18191447
[4] => 784350533
[5] => 284188737
[6] => 741637313
[7] => 50611954
[8] => 310943811
[9] => 778221726
[10] => 672312510
[11] => 818188898
[12] => 183678669
[13] => 307489611
[14] => 869767133
[15] => 748754383
 */
