import java.util.ArrayList;

public class Euler50 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    // Generate list of primes:
    final int N = 1000000;
    ArrayList<Integer> primes = new ArrayList<Integer>();
    boolean[] p = new boolean[N];
    for (int i = 0; i < N; i++) p[i] = true;
    for (int i = 2; i*i < N; i++) {
      if (p[i]) {
        for (int j = i*i; j < N; j+= i) {
          p[j] = false;
        }
      }
    }
    for (int i = 2; i < N; i++) {
      if (p[i]) primes.add(i);
    }
    // Find longest sequence of primes that adds up to a prime:
    int maxConsecutive = 0;
    int maxPrime = 0;
    for (int i = 0; i < primes.size(); i++) {
      int sum = 0, numConsecutive = 0, sumPrime = 0;
      for (int j = i; j < primes.size(); j++) {
        if ((sum += primes.get(j)) >= N) break;
        if (p[sum]) {
          numConsecutive = j-i+1;
          sumPrime = sum;
        }
      }
      if (numConsecutive > maxConsecutive) {
        maxConsecutive = numConsecutive;
        maxPrime = sumPrime;
      }
    }
    long endTime = System.nanoTime();
    System.out.println(maxPrime);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
}