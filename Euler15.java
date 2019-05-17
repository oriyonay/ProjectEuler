public class Euler15 {
  public static void main(String[] args) {
    final int size = 20;
    long[][] grid = new long[size][size];
    for (int i = 0; i < size; i++) {
      grid[0][i] = i+2;
      grid[i][0] = i+2;
    }
    for (int i = 1; i < size; i++) {
      for (int j = 1; j < size; j++) {
        grid[i][j] = grid[i][j-1] + grid[i-1][j];
      }
    }
    System.out.println(grid[size-1][size-1]);
  }
}