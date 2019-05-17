import java.util.ArrayList;

public class Euler44 {
  public static ArrayList<Long> pentagons = new ArrayList<Long>();
  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
      pentagons.add((long)(i*((3*i)-1))/2);
    }
    for (int i = 1; i < pentagons.size(); i++) {
      for (int j = i+1; j < pentagons.size(); j++) {
        if (find(pentagons.get(i) + pentagons.get(j)) && find(pentagons.get(j) - pentagons.get(i))) {
        	System.out.println(pentagons.get(j) + " - " + pentagons.get(i) + " = " + (pentagons.get(j) - pentagons.get(i)));
        }
      }
    }
  }
  public static boolean find(long n) {
    int low = 0;
    int high = pentagons.size()-1;
    int mid = 0;
    while (low <= high) {
      mid = (low + high)/2;
      if (pentagons.get(mid) > n) high = mid - 1;
      else if (pentagons.get(mid) < n) low = mid + 1;
      else return true;
    }
    return false;
  }
}