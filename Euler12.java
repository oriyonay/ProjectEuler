public class Euler12 {
  public static void main(String[] args) {
    int n = 1;
    while (numDivisors(triangle(n)) < 500) n++;
    System.out.println(triangle(n));
  }
  public static int numDivisors(int n) {
    if (n == 1) return 1;
    int limit = n;
    int numDivisors = 0;
    for (int i = 1; i < limit; i++) {
      if (n % i == 0) {
        limit = n / i;
        if (limit != i) numDivisors++;
        numDivisors++;
      }
    }
    return numDivisors;
  }
  public static int triangle(int n) {
    // nth triangle
    return (n*(n+1))/2;
  }
}