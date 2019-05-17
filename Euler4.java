public class Euler4 {
  public static void main(String[] args) {
    int largest = 0;
    for (int i = 999; i > 0; i--) {
      for (int j = 999; j > 0; j--) {
        if (isPal(i*j) && (i*j) > largest) {
          System.out.println(i*j);
          largest = i*j;
        }
      }
    }
  }
  public static boolean isPal(int n) {
    int m = 0, n2 = n;
    while (n2 != 0) {
      m*= 10;
      m+= n2%10;
      n2/= 10;
    }
    return m == n;
  }
}
