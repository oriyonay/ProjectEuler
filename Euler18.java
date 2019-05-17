// NOTE: This is the same solution for Euler 67 ;)

import java.io.BufferedReader;
import java.io.FileReader;

public class Euler18 {
  public static void main(String[] args) throws Exception {
    long startTime = System.nanoTime();
    final int len = 15; // number of lines in file
    BufferedReader br = new BufferedReader(new FileReader("Euler18.txt"));
    int[][] tree = new int[len][len];
    String line;
    int lineNum = 0;
    while ((line = br.readLine()) != null && lineNum < len) {
      String[] nums = line.split(" ");
      for (int i = 0; i < nums.length; i++) {
        tree[lineNum][i] = Integer.parseInt(nums[i]);
      }
      lineNum++;
    }
    for (int i = len-2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        tree[i][j] += (tree[i+1][j] > tree[i+1][j+1]) ? tree[i+1][j] : tree[i+1][j+1];
      }
    }
    long endTime = System.nanoTime();
    System.out.println(tree[0][0]);
    System.out.println("Program execution took " + (endTime - startTime)/1000000 + "ms");
  }
}
