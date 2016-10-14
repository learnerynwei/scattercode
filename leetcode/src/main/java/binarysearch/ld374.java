package leetcode.binarysearch;

public class ld374 {

  //attention the number out of Integer.MAX_VALUE
  public boolean isPerfectSquare(int num) {
    if (num == 1)
      return true;
    long l = 1, r = num / 2;
    while (l <= r) {
      long mid = l + (r - l) / 2;
      long square = mid * mid;
      if (square == num)
        return true;
      else if (square > num)
        r = mid - 1;
      else
        l = mid + 1;
    }
    return false;
  }

  public static void main(String[] args) {
    ld374 ld = new ld374();
    System.out.println(ld.isPerfectSquare(808201));//808201
  }

}
