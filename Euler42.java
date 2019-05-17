import java.io.FileReader;
import java.io.BufferedReader;

public class Euler42 {
  public static void main(String[] args) throws Exception {
    long startTime = System.nanoTime();
    BufferedReader br = new BufferedReader(new FileReader("Euler42.txt"));
    String line = br.readLine(); // no need for while loop as the file is one line long
    String[] words = line.split("\"./*\"");
    // fix parsing mistakes on second and last words, and adding "A" for correctness' sake
    words[0] = "A";
    words[1] = words[1].substring(2);
    words[words.length-1] = words[words.length-1].substring(0, words[words.length-1].length()-1); // blehhhh this line is so ugly
    // there's probably a better way to parse this, but this does the trick quite well
    int numTriangles = 0, wordValue;
    for (String w: words) {
      wordValue = 0;
      for (int i = 0; i < w.length(); i++) {
        wordValue+= (w.charAt(i) - 64);
      }
      if (isTriangle(wordValue)) numTriangles++;
    }
    long endTime = System.nanoTime();
    System.out.println("Number of triangle words: " + numTriangles);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
  public static boolean isTriangle(int n) {
    int a = (int)Math.sqrt(2*n);
    return (a*(a+1))/2 == n;
  }
}
