import java.util.ArrayList;

public class Euler37 {
  public static ArrayList<Integer> primes = new ArrayList<Integer>();
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    final int MAX = 1000000;
    int sum = 0;
    primes.add(2);
    boolean isprime = true;
    for (int i = 3; i < MAX; i+= 2) {
      isprime = true;
      for (int j: primes) {
        if (i % j == 0) {
          isprime = false;
          break;
        }
      }
      if (isprime) primes.add(i);
    }
    for (int i: primes) {
      int temp = i/10, temp2 = i % (int)Math.pow(10, (int)Math.log10(i));
      boolean good = true;
      while (temp != 0 && temp2 != 0) {
        if (!find(temp) || !find(temp2)) {
          good = false;
          break;
        }
        temp/= 10;
        temp2 %= (int) Math.pow(10, (int) Math.log10(temp2));
      }
      if (good && i > 10) sum+= i;
    }
    long endTime = System.nanoTime();
    System.out.println(sum);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
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
