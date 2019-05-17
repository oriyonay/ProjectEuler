public class Euler47 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    final int N = 4;
    int numConsecutive = 0, i = (int)Math.pow(10, N-1);
    while (numConsecutive < N) {
      if (numPrimeFactors(i) == N) numConsecutive++;
      else numConsecutive = 0;
      i++;
    }
    long endTime = System.nanoTime();
    System.out.println(i-N);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static int numPrimeFactors(int n) {
    int numPrimeFactors = (n % 2 == 0) ? 1 : 0;
    for (int i = 3; i <= n; i+=2) {
      if (n % i == 0) {
        while (n % i == 0) n/= i;
        numPrimeFactors++;
      }
    }
    return numPrimeFactors;
  }
}