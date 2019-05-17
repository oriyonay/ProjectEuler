public class Euler36 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int sum = 0;
    for (int i  = 1; i < 1000000; i++) {
      if (isPal(i) && isPal(Integer.toBinaryString(i))) sum+= i;
    }
    long endTime = System.nanoTime();
    System.out.println(sum);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isPal(int n) {
    int m = 0, temp = n;
    while (temp != 0) {
      m*= 10;
      m+= temp % 10;
      temp /= 10;
    }
    return m == n;
  }
  public static boolean isPal(String s) {
    int len = s.length();
    while (len > 1) {
      if (s.charAt(0) != s.charAt(len-1)) return false;
      s = s.substring(1, len - 1);
      len-= 2;
    }
    return true;
  }
}
