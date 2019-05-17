import java.util.ArrayList;

public class Euler7 {
  public static void main(String[] args) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    primes.add(2);
    int i = 3;
    boolean isPrime = true;
    while (primes.size() < 10001) {
      isPrime = true;
      for (int j: primes) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) primes.add(i);
      i+=2;
    }
    System.out.println(primes.get(primes.size()-1));
  }
}
