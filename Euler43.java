import java.math.BigInteger;

public class Euler43 {
  public static BigInteger sum = BigInteger.ZERO;
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int digits[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    testPermutations(0, digits);
    long endTime = System.nanoTime();
    System.out.println(sum);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isLegal(String s) {
    // assumes pandigitality and that d2...d4 | 2 and that d4...d6 | 5
    if (Integer.parseInt(s.substring(2, 5)) % 3 != 0) return false;
    if (Integer.parseInt(s.substring(4, 7)) % 7 != 0) return false;
    if (Integer.parseInt(s.substring(5, 8)) % 11 != 0) return false;
    if (Integer.parseInt(s.substring(6, 9)) % 13 != 0) return false;
    return Integer.parseInt(s.substring(7, 10)) % 17 == 0;
  }
  public static void testPermutations(int index, int[] digits) {
    if (index == digits.length) {
      String s = "";
      for (int i: digits) s+= i;
      if (isLegal(s)) sum = sum.add(new BigInteger(s));
      return;
    }
    for (int i = index; i < digits.length; i++) {
      if (index == 3 && digits[i] % 2 != 0) continue;
      if (index == 5 && digits[i] % 5 != 0) continue;
      int temp = digits[i];
      digits[i] = digits[index];
      digits[index] = temp;
      testPermutations(index + 1, digits);
      digits[index] = digits[i];
      digits[i] = temp;
    }
    return;
  }
}