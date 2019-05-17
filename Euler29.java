import java.math.BigInteger;
import java.util.Set;
import java.util.HashSet;

public class Euler29 {
  public static void main(String[] args) {
    Set<BigInteger> powers = new HashSet<BigInteger>();
    for (int i = 2; i <= 100; i++) {
      for (int j = 2; j <= 100; j++) {
        BigInteger num = BigInteger.valueOf(i);
        powers.add(num.pow(j));
      }
    }
    System.out.println(powers.size());
  }
}
