public class Euler39 {
  public static void main(String[] args) {
    long startTime = System.nanoTime();
    int maxSolutions = 0, maxNum = 1, currSolutions = 0;
    for (int p = 1; p <= 1000; p++) {
      currSolutions = getSolutions(p);
      if (currSolutions > maxSolutions) {
        maxSolutions = currSolutions;
        maxNum = p;
      }
    }
    System.out.println(maxNum);
    long endTime = System.nanoTime();
    System.out.println("Program took " + (endTime - startTime)/1000000 + "ms");
  }
  public static int getSolutions(int p) {
    int numSolutions = 0;
    for (int a = 1; a < p/2; a++) {
      for (int b = a; b < p/2; b++) {
        int c = (int)Math.sqrt((a*a) + (b*b));
        if ((a+b+c == p) && (a*a) + (b*b) == c*c) numSolutions++;
      }
    }
    return numSolutions;
  }
}
