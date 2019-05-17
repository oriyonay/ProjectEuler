public class Euler41 {
  public static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    final int N = 7654321;
    boolean[] primes = new boolean[N+1];
    for (int i = 0; i < N; i++) primes[i] = true;
    for (int i = 2; i*i < N; i++) {
        if (primes[i]) {
            for (int j = i*i; j < N; j+= i) primes[j] = false;
        }
    }
    for (int i = N-1; i >= 2; i--) {
        if (primes[i] && isPandigital(Integer.toString(i))) {
            System.out.println(i);
            break;
        }
    }
    long endTime = System.nanoTime();
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isPandigital(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.indexOf(digits[i]) < 0) return false;
    }
    return true;
  }
}