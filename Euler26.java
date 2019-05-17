import java.util.Set;
import java.util.HashSet;

public class Euler26 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int maxRepeating = 1, maxIndex = 1, temp;
    for (int i = 1; i < 1000; i++) {
      temp = numRepeating(i);
      if (temp > maxRepeating) {
        maxRepeating = temp;
        maxIndex = i;
      }
    }
    long endTime = System.nanoTime();
    System.out.println("Largest repeating sequence is 1/" + maxIndex + ", containing " + maxRepeating + " digits.");
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static int numRepeating(int n) {
    // number of repeating digits for 1/n:
    int a = 10, repeat = 0;
    Set<Integer> divisors = new HashSet<Integer>();
    while (divisors.size() == repeat) {
      divisors.add(a);
      a %= n;
      a*= 10;
      repeat++;
    }
    return repeat-1;
  }
}
