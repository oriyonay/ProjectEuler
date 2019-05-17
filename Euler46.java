import java.util.ArrayList;

public class Euler46 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    ArrayList<Integer> primes = new ArrayList<Integer>();
    ArrayList<Integer> squareDoubles = new ArrayList<Integer>();
    primes.add(2);
    squareDoubles.add(2);
    int index = 3, nextSquareDouble = 6, nums = 0;
    boolean isPrime = true, canBeExpressed = false; // definitions don't matter here
    while (true) {
      for (int i = 0; i < nextSquareDouble; i++) {
          if (index % 10000 == 0) System.out.println("\t" + index);
        // check if index is prime:
        isPrime = true;
      	for (int j = 0; j < primes.size(); j++) {
          if (index % primes.get(j) == 0) {
          	isPrime = false;
          	break;
          }
      	}
      	if (isPrime) {
          //System.out.println("Debug: prime = " + index);
          primes.add(index);
      	} else {
          if ((index & 1) == 1) {
            // if composite number:
            canBeExpressed = false;
            for (int a = 0; a < primes.size(); a++) {
              for (int b = 0; b < squareDoubles.size(); b++) {
                if (primes.get(a) + squareDoubles.get(b) == index) {
                  //System.out.println("Debug: " + index + " = " + primes.get(a) + " + " + squareDoubles.get(b));
                  canBeExpressed = true;
                  break; // change this
                }
              }
              if (canBeExpressed) break;
            }
            if (!canBeExpressed) {
              System.out.println("FOUND IT: " + index);
              nums++;
              if (nums > 2) {
                long endTime = System.nanoTime();
              	System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
                return;
              }
            }
          }
      	}
        index++;
      }
      squareDoubles.add(index-1);
      nextSquareDouble+= 4;
    }
  }
}
