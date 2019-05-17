public class Euler49 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    final int N = 10000;
    boolean primes[] = new boolean[N];
    for (int i = 0; i < N; i++) primes[i] = true;
    for (int i = 2; i < N; i++) {
      if (primes[i]) {
        for (int j = i*i; j < N; j+= i) {
          primes[j] = false;
        }
      }
    }
    int j;
    for (int i = 1009; i < 4000; i++) {
      // 1009 is the first prime over 1000, might as well start there lol
      if (primes[i]) {
        j = 100;
        while (i + (2*j) < N) {
          if (primes[i + j] && primes[i + (j*2)] && isPerm(i, i+j, i+j+j)) {
            System.out.println(i + ", " + (i + j) + ", " + (i + j + j));
          }
          j++;
        }
      }
    }
    long endTime = System.nanoTime();
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isPerm(int a, int b, int c) {
    return isPerm(Integer.toString(a), Integer.toString(b), Integer.toString(c));
  }
  public static boolean isPerm(String a, String b, String c) {
    if (a.equals("") && b.equals("") && c.equals("")) return true;
    if (a.length() != b.length() || b.length() != c.length()) return false;
    if (b.indexOf(a.charAt(0)) < 0 || c.indexOf(a.charAt(0)) < 0) return false;
    return isPerm(a.substring(1), b.replaceFirst(a.charAt(0) + "", ""), c.replaceFirst(a.charAt(0) + "", ""));
  }
}