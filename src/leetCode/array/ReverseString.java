package leetCode.array;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters
 * char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"] Example 2:
 *
 * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {

  public static void main(String[] args) {
    char[] s1 = "Hello".toCharArray();
    char[] s2 = "Hannah".toCharArray();

    new ReverseString().reverseString(s1);
    new ReverseString().reverseString(s2);

    System.out.println(Arrays.toString(s1));
    System.out.println(Arrays.toString(s2));
  }

  public void reverseString(char[] s) {
    int i = 0;
    int j = s.length - 1;
    while (i < j) {
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
      i++;
      j--;
    }
  }
}
