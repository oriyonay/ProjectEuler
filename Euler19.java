public class Euler19 {
  private static int[] months = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5}, years = {6, 4, 2, 0};
  public static void main(String[] args) {
    int sumSundays = 0;
    for (int year = 1901; year <= 2000; year++) {
      for (int month = 1; month <= 12; month++) {
        if (isSunday(1, month, year)) sumSundays++;
      }
    }
    System.out.println(sumSundays);
  }
  public static boolean isSunday(int day, int month, int year) {
    int c = (day + months[month-1] + (year % 100) + (int)((year % 100) / 4) + years[(int)(year/100) % 4]);
    if (year % 4 == 0 && month <= 2) c--;
    return c % 7 == 0;
  }
}