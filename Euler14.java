public class Euler14 {
  private static final int MAX_N = 1000000;
  private static int[] nums = new int[MAX_N];
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int max = 1, maxIndex = 1;
    for (int i = 1; i < MAX_N; i++) {
      if ((nums[i] = collatz(i)) > max) {
        max = nums[i];
        maxIndex = i;
      }
    }
    long endTime = System.nanoTime();
    System.out.println(maxIndex);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + " milliseconds");
  }
  public static int collatz(long n) {
    int ct = 0;
    while (n != 1) {
      if (n < MAX_N && nums[(int)n] != 0) return ct + nums[(int)n];
      if (n % 2 == 0) {
        n /= 2;
      } else {
        n*= 3;
        n++;
      }
      ct++;
    }
    return ct;
  }
}
