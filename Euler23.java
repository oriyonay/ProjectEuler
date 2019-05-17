import java.util.ArrayList;

public class Euler23 {
  private static ArrayList<Integer> abundantNums = new ArrayList<Integer>();
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i < 28123; i++) {
      if (isAbundant(i)) abundantNums.add(i);
      if (!canBeWrittenAsSum(i)) sum+= i;
    }
    System.out.println(sum);
  }
  public static boolean isAbundant(int n) {
    int s = 1;
    for (int i = 2; i <= Math.ceil(n/2); i++) {
      if (n % i == 0) s+= i;
    }
    return s > n;
  }
  public static boolean canBeWrittenAsSum(int n) {
    // assuming valid input
    for (int i = 0; i < abundantNums.size(); i++) {
      for (int j = i; j < abundantNums.size(); j++) {
        if (abundantNums.get(i) + abundantNums.get(j) == n) return true;
      }
      if (abundantNums.get(i) > Math.ceil(n/2)) return false;
    }
    return false;
  }
}