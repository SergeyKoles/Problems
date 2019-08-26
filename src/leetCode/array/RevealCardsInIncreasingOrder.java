package leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
 * <p>
 * Initially, all the cards start face down (unrevealed) in one deck.
 * <p>
 * Now, you do the following steps repeatedly, until all cards are revealed:
 * <p>
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * <p>
 * The first entry in the answer is considered to be the top of the deck.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [17,13,11,2,3,5,7]
 * Output: [2,13,3,11,5,17,7]
 * Explanation:
 * We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
 * After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
 * We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
 * We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
 * We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
 * We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
 * We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
 * We reveal 13, and move 17 to the bottom.  The deck is now [17].
 * We reveal 17.
 * Since all the cards revealed are in increasing order, the answer is correct.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[i] <= 10^6
 * A[i] != A[j] for all i != j
 * <p>
 * (Medium)
 */

public class RevealCardsInIncreasingOrder {
  public static void main(String[] args) {
    RevealCardsInIncreasingOrder deck = new RevealCardsInIncreasingOrder();
    int[] array = new int[]{1, 2, 3, 4};
    int[] test = new int[]{0, 0, 0, 0};
    int l = array.length;

    test[0] = array[0];
    int tmp = array[1];
    System.arraycopy(array, 1, array, 0, array.length - 2);
    array[array.length - 1] = tmp;

//    System.arraycopy(array, 2, test, 0, array.length - 2);
//    System.out.println(Arrays.toString(array));
//    System.out.println(Arrays.toString(test));

//    System.out.println(deck.test(new Integer[]{1, 3, 2, 4}));
    System.out.println(deck.testDeckRevealedIncreasing(new Integer[]{1, 6, 2, 10, 3, 7, 4, 9, 5, 8}));

//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3})));

//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4}))); // [1, 3, 2, 4]
//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5}))); // [1, 5, 2, 4, 3]
//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6}))); // [1, 4, 2, 6, 3, 5]
//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7}))); // [1, 6, 2, 5, 3, 7, 4]

//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))); // [1, 6, 2, 10, 3, 7, 4, 9, 5, 8]
//    System.out.println(Arrays.toString(deck.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
//    System.out.println(Arrays.toString(Arrays.copyOfRange(array, (l / 2) + 1, l)));
//    System.out.println(3/2);
  }

  private boolean testDeckRevealedIncreasing(Integer[] array) {
    int n = array.length;

    LinkedList<Integer> la = new LinkedList<>(Arrays.asList(array));
    ArrayList<Integer> test = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      test.add(la.getFirst());
      la.removeFirst();
      if (la.isEmpty())
        break;
      Integer tmp = la.removeFirst();
      la.addLast(tmp);
    }
    System.out.println(test.toString());
    Arrays.sort(array);
    return Arrays.equals(test.toArray(), array);
  }

  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int[] secPart = choose(deck);
    return cycle(deck, secPart);
  }

  private int[] odd(int[] subArray) {
    if (subArray.length == 3) {
      return swapOdd(subArray);
    }
    if (subArray.length == 2) {
      return new int[]{subArray[1], subArray[0]};
    }
    int[] secPart = choose(subArray);
    return cycle(subArray, secPart);
  }

  private int[] even(int[] subArray) {
    if (subArray.length == 2)
      return subArray;
    if (subArray.length == 3)
      return swapEven(subArray);

    int[] secPart = choose(subArray);
    return cycle(subArray, secPart);
  }

  private int[] choose(int[] subArray) {
    int l = subArray.length;
    return (l & 1) == 0 ? even(Arrays.copyOfRange(subArray, l / 2, l)) : odd(Arrays.copyOfRange(subArray, (l / 2) + 1, l));
  }

  private int[] cycle(int[] subArray, int[] secPart) {
    int[] result = new int[subArray.length];
    int i = 0, j = 0;
    int l = subArray.length;
    if ((l & 1) == 1) {
      while (true) {
        result[j++] = subArray[i];
        if (i >= secPart.length)
          break;
        result[j++] = secPart[i++];
      }
    } else {
      while (true) {
        result[j++] = subArray[i];
        result[j++] = secPart[i++];
        if (i == secPart.length)
          break;
      }
    }
    return result;
  }

  private int[] swapEven(int[] array) {
    int tmp = array[1];
    array[1] = array[2];
    array[2] = tmp;
    return array;
  }

  private int[] swapOdd(int[] array) {
    int tmp = array[0];
    array[0] = array[1];
    array[1] = tmp;
    return array;
  }

}
