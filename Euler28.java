import java.util.Scanner;

public class Euler28 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    final int N = in.nextInt(); // N MUST BE ODD
    if (N % 2 == 0) {
      System.out.println("Error: N cannot be even!");
      System.exit(0);
    }
    int sum = 1, index = 1;
    for (int i = 1; i <= N/2; i++) {
      for (int j = 0; j < 4; j++) {
        index+= 2*i;
        sum+= index;
      }
    }
    System.out.println("Sum for N = " + N + ": " + sum);
  }
}
