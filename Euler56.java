import java.math.BigInteger;

public class Euler56 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int sum, maxSum = 0;
    for (int i = 0; i < 100; i++) {
      BigInteger cur = BigInteger.valueOf(i);
      for (int j = 0; j < 100; j++) {
        if ((sum = sumDigits(cur.pow(j).toString())) > maxSum) maxSum = sum;
      }
    }
    long endTime = System.nanoTime();
    System.out.println(maxSum);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static int sumDigits(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum+= s.charAt(i) - 48;
    }
    return sum;
  }
}