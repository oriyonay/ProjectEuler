public class Euler45 {
  public static void main(String[] args) {
    // Every hexagonal number is a triangular number, so no need to calculate that ;)
    long startTime = System.nanoTime();
    int hIndex = 200, pIndex = 200;
    long currHex = 1, currPentagon = 1;
    while (true) {
      currPentagon = ((long)pIndex*((3*pIndex)-1))/2;
      pIndex++;
      while (currPentagon > currHex) {
        currHex = ((long)hIndex*((2*hIndex)-1));
        hIndex++;
      }
      if (currPentagon == currHex) break;
    }
    long endTime = System.nanoTime();
    System.out.println(currHex);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
}