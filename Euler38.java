public class Euler38 {
  public static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    for (int i = 2; i < 10000; i++) {
      // NOTE: Could be done backwards but there is no guarantee of correctness
      // (well, we know it's correct but there's no proof)
      String cat = Integer.toString(i);
      for (int j = 2; j < 9; j++) {
        cat+= i*j;
        if (isPandigital(cat)) {
          System.out.println(i + ", " + j + ": " + cat);
          break;
        }
      }
    }
    long endTime = System.nanoTime();
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isPandigital(String s) {
    if (s.length() != 9) return false;
    for (char c: digits) if (s.indexOf(c) < 0) return false;
    return true;
  }
}
