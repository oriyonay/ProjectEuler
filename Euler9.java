public class Euler9 {
  public static void main(String[] args) {
    int c = 0;
    for (int a = 500; a > 0; a--) {
      for (int b = 500; b > 0; b--) {
        c = (int)Math.sqrt((a*a)+(b*b));
        if (c*c == (a*a)+(b*b) && a+b+c == 1000) {
          System.out.println(a*b*c);
          return;
        }
      }
    }
  }
}
