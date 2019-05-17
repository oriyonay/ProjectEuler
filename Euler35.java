import java.util.ArrayList;

public class Euler35 {
  public static ArrayList<Integer> primes = new ArrayList<Integer>();
  public static void main(String [] args) {
    long startTime = System.nanoTime();
    primes.add(2);
    boolean isprime = true;
    for (int i = 3; i < 1000000; i+= 2) {
      isprime = true;
      for (int j: primes) {
        if (i % j == 0) {
          isprime = false;
          break;
        }
      }
      if (isprime) primes.add(i);
    }
    int numCircular = 0;
    int digitCeil = 10;
    int numDigits = 1;
    for (int i: primes) {
      if (i > digitCeil) {
        digitCeil*= 10;
        numDigits++;
      }
      int temp = i;
      boolean isCircular = true;
      for (int j = 0; j < numDigits-1; j++) {
        temp = rotate(temp);
        if (!find(temp)) {
          isCircular = false;
          break;
        }
      }
      if (isCircular) numCircular++;
    }
    long endTime = System.nanoTime();
    System.out.println(numCircular);
    System.out.println("Execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static int rotate(int n) {
    if (n < 10) return n; // no need for this?
    return Integer.parseInt((n%10) + "" + n/10);
  }
  public static boolean find(int n) {
    // binary search through ArrayList primes
    int begin = 0;
    int end = primes.size() - 1;
    int mid = 0;
    while (begin <= end) {
      mid = (begin + end) / 2;
      if (primes.get(mid) < n) begin = mid + 1;
      else if (primes.get(mid) > n) end = mid - 1;
      else return true;
    }
    return false;
  }
}
