import java.util.Set;
import java.util.HashSet;

public class Euler32 {
  public static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int sum = 0;
    Set<Integer> products = new HashSet<Integer>();
    for (int i = 1; i < 1000; i++) {
      for (int j = i; j < 10000; j++) {
        if (isPandigital(i + "" + j + "" + (i*j))) products.add(i*j);
      }
    }
    for (int i: products) sum+= i;
    long endTime = System.nanoTime();
    System.out.println(sum);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isPandigital(String n) {
    // checks for 1-9 pandigital
    if (n.length() != 9) return false;
    for (char i: digits) if (n.indexOf(i) < 0) return false;
    return true;
  }
}