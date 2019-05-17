public class what {
  public static void main(String[] args) {
    final long MAX = 1000000000;
    long startTime = System.nanoTime();
    long sum = 0;
    for (int i = 0; i < MAX; i++) {
      sum+= i;
    }
    System.out.println(sum);
    long endTime = System.nanoTime();
    long duration = (endTime - startTime);
    System.out.println("Program execution took " + duration + " nanoseconds or " + duration/1000000 + " milliseconds");
  }
}