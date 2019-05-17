public class Euler52 {
  public static void main(String[] args) {
    int i = 100;
    while (true) {
      if (sameDigits(Integer.toString(i), Integer.toString(2*i), Integer.toString(3*i), Integer.toString(4*i), Integer.toString(5*i), Integer.toString(6*i))) break;
      i++;
    }
    System.out.println(i + ", " + (2*i) + ", " + (3*i) + ", " + (4*i) + ", " + (5*i) + ", " + (6*i));
  }
  /*public static boolean sameDigits(String a, String b) {
    if (a.equals("") && b.equals("")) return true;
    if (a.length() != b.length()) return false;
    if (b.indexOf(a.charAt(0)) < 0) return false;
    return sameDigits(a.substring(1), b.replaceFirst(a.charAt(0) + "", ""));
  }*/
  public static boolean sameDigits(String... n) {
    boolean all = true;
    for (int a = 0; a < n.length - 1; a++) {
      if (!n[a].equals("")) {
        all = false;
        break;
      }
      if (n[a].length() != n[a+1].length()) return false;
    }
    if (!n[n.length-1].equals("")) all = false;
    if (all) return true;
    String c = n[0].charAt(0) + "";
    for (int i = 0; i < n.length; i++) {
      n[i] = n[i].replaceFirst(c, "");
    }
    return sameDigits(n);
  }
}