package stepic.baseDataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringSearching {

  private static long[] auxiliaryArray;

  private static final int X = 263;
  private static final int MOD = 1_000_000_007;
  private static final long INVERSE_ELEMENT = inverseElement(X);


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      String pattern = br.readLine();
      String text = br.readLine();
      auxiliaryArray = getAuxiliaryArray(pattern.length());
      long patternHash = getPatternHash(pattern);
      search(text, pattern, patternHash);
    } catch (IOException e) {
      System.out.println("-------- Oops!!! --------");
    }
  }

  private static void search(String text, String pattern, long patternHash) {
    int patternLength = pattern.length();
    char[] chars = text.toCharArray();
    if (chars.length < patternLength) return;
    StringBuilder ans = new StringBuilder();

    long subTextHash = countHash(text.substring(0, patternLength).toCharArray());
    for (int i = 0; i < chars.length - patternLength; i++) {
      int index = patternLength + i;

      if (patternHash == subTextHash) {
        if (text.substring(i, index).equals(pattern))
          ans.append(i).append(" ");
      }

      long hashWithoutFirstElement = divideByMod(subTextHash - chars[i]);

      subTextHash = (hashWithoutFirstElement + ((chars[index] * auxiliaryArray[patternLength - 1]) % MOD)) % MOD;
    }
    if (patternHash == subTextHash) {
      int beginIndex = text.length() - patternLength;
      if (text.substring(beginIndex).equals(pattern))
        ans.append(beginIndex);
    }
    System.out.println(ans.toString());
  }

  private static long inverseElement(long n) {
    return binPow(n, MOD - 2);
  }

  private static long divideByMod(long n) {
    return n * INVERSE_ELEMENT % MOD;
  }

  private static long getPatternHash(String pattern) {
    char[] chars = pattern.toCharArray();
    return countHash(chars);
  }

  private static long countHash(char[] chars) {
    long sum = 0;
    for (int i = 0; i < chars.length; i++) {
      sum += ((chars[i] % MOD) * (auxiliaryArray[i] % MOD)) % MOD;
    }
    return sum % MOD;
  }

  private static long[] getAuxiliaryArray(int size) {
    long[] indexes = new long[size];
    for (int i = 0; i < size; i++) {
      indexes[i] = binPow(X, i);
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
