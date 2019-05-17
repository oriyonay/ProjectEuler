public class Euler6 {
  public static void main(String[] args) {
    final int N = 100;
    int sumSquares = 0;
    for (int i = 0; i <= N; i++) sumSquares+= (i*i);
    int squareSums = (N+1)*(N/2);
    squareSums *= squareSums;
    System.out.println(sumSquares + " - " + squareSums + ": " + Math.abs(sumSquares - squareSums));
  }
}
