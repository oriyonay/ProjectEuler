public class Euler2 {
  public static void main(String[] args) {
    int sum = 0, a = 0, b = 1, c = 0;
    while (b + c < 4000000) {
      a = b;
      b = c;
      c = a+b;
      if (c % 2 == 0) sum+= c;
    }
    System.out.println(sum);
  }
}
