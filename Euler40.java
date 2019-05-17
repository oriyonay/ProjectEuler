public class Euler40 {
  public static void main(String[] args) {
    for (int i = 10; i < 20; i++) {
      System.out.print(digit(i));
    }
  }
  public static int digit(int n) {
    int numDigits = 1;
    while (9*numDigits*Math.pow(10, numDigits-1) < n) {
      System.out.println("DEBUG: " + numDigits + ", " + 9*numDigits*Math.pow(10, numDigits-1) + ", " + n);
      n-= 9*numDigits*Math.pow(10, numDigits-1);
      numDigits++;
    }
    int q = ((int)Math.pow(10, numDigits-1) + (n/numDigits) - 1);
    System.out.println(q);
    try {
      return Integer.toString(q).charAt(n - (n/numDigits) - 1) - 48;
    } catch (Exception e) {
      System.out.println("Error: " + q + ", " + n + ", " + numDigits);
    }
    return -1;
  }
}
