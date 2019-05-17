import java.util.ArrayList;

public class Euler24 {
  public static void main(String[] args) {
    ArrayList<Integer> digits = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) digits.add(i);
    System.out.println(permutation("", digits, 1000000));
  }
  public static String permutation(String s, ArrayList<Integer> digits, int p) {
    if (p == 1) {
      for (int i: digits) s+= i;
      return s;
    }
    int fact = factorial(digits.size() - 1);
    int n = (p % fact == 0) ? (p / fact) - 1 : p / fact;
    s+= digits.get(n);
    digits.remove(n);
    return permutation(s, digits, p - (n*fact));
  }
  public static int factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n-1);
  }
}