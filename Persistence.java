public class Persistence {
  public static void main(String [] args) {
    int i = 10;
    while (persistence(i, 0) < 5) i++;
    System.out.println(i);
  }
  public static int persistence(int n, int t) {
    if (n < 10) return t;
    int f = 1;
    while (n > 1) {
      f*= (n % 10);
      n/= 10;
    }
    return persistence(f, t + 1);
  }
}