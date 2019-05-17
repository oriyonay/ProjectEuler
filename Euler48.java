import java.math.BigInteger;

public class Euler48 {
  public static void main(String[] args) {
    BigInteger sum = BigInteger.ZERO;
    long startTime = System.nanoTime();
    for (int i = 1; i < 1000; i++) {
      sum = sum.add(BigInteger.valueOf(i).pow(i));
    }
    long endTime = System.nanoTime();
    System.out.println("Execution took " + (endTime - startTime)/1000000 + "ms");
    System.out.println(sum.toString().substring(sum.toString().length()-10));
  }
}
