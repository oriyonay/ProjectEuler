public class Euler33 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int numerator = 1, denomenator = 1;
    for (int i = 10; i < 100; i++) {
      for (int j = i+1; j < 100; j++) {
        if (removeSharedDigit(i, j) == (double)i/j) {
          System.out.println(i + "/" + j + " = " + removeSharedDigit(i, j));
          numerator*= i;
          denomenator*= j;
        }
      }
    }
    // simplify the fraction:
    while (numerator % 2 == 0 && denomenator % 2 == 0) {
      numerator/= 2;
      denomenator/= 2;
    }
    for (int i = 3; i < denomenator; i+= 2) {
      while (numerator % i == 0 && denomenator % i == 0) {
        numerator/= i;
        denomenator/= i;
      }
    }
    System.out.println("Reduced fraction: " + numerator + "/" + denomenator);
    long endTime = System.nanoTime();
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static double removeSharedDigit(int a, int b) {
    // return a/b after removing the shared digit. if no shared digit, return -1
    if (a == b) return -1;
    if (a == (10*(b%10) + (b/10))) return -1;
    if (a%10 == b%10 && a%10 != 0) return (double)((int)a/10) / ((int)(b/10));
    if (a/10 == b/10) return (double)((int)a%10) / ((int)(b%10));
    if (a/10 == b%10) return (double)((int)a%10) / ((int)(b/10));
    if (a%10 == b/10) return (double)((int)a/10) / ((int)(b%10));
    return -1;
  }
}