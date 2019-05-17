import java.util.ArrayList;
import java.math.BigInteger;

public class Euler10 {
  public static void main(String[] args) {
    final int N = 2000000;
    ArrayList<Integer> primes = new ArrayList<Integer>();
    primes.add(2);
    int i = 3;
    boolean isPrime = true;
    while (i < N) {
      isPrime = true;
      for (int j: primes) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) primes.add(i);
      i+= 2;
    }
    BigInteger sum = BigInteger.ZERO;
    for (int a: primes) sum = sum.add(BigInteger.valueOf(a));
    System.out.println("Sum: " + sum);
  }
}
