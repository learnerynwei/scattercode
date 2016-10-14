package leetcode.binarysearch;

public class ld34 {

  public int[] searchRange(int[] A, int target){
    int[] res = new int[2];
    res[0] = searchLeft(A, target);
    res[1]= searchRight(A, target); 
    return res;
  }

  
  public int searchLeft(int[] A, int target ){
    int l = 0, r = A.length - 1;
    boolean isHas = false;
    while(l <= r){
      int m = l + (r - l)/2;
      if(A[m] == target){
        isHas = true;
        r = m - 1;
      }else if(A[m] > target){
        r = m - 1;
      }else{
        l = m + 1;
      }
    }
    return isHas ? l : -1;
  }
  
  public int searchRight(int[] A, int target ){
    int l = 0, r = A.length - 1;
    boolean isHas = false;
    while(l <= r){
      int m = l + (r - l)/2;
      if(A[m] == target){
        isHas = true;
        l = m + 1;
      }else if(A[m] > target){
        r = m - 1;
      }else{
        l = m + 1;
      }
    }
    return isHas ? l - 1 : -1;
  }
  
  public static void main(String[] args) {
    ld34 l209 = new ld34();
    int[]  b = {2, 3, 3, 3, 4, 4};
    for (int i = 0; i < 5; i++) {
      System.out.println(i + " is :" + l209.searchRange(b, i)[0] +", "+ l209.searchRange(b, i)[1]);     
    }
    int[]  c = {1, 2, 3 , 5, 5, 7,7,7,7,7};
    
    for (int i = 0; i < 8; i++) {
      System.out.println(i + " is :" + l209.searchRange(c, i)[0] +", "+ l209.searchRange(c, i)[1]);     
    }
//    for(int i = 1; i < 20; ++i)
//      System.out.println("sum is " + i + ", result is " + l209.minSubArrayLen(i, b));
//    
  }

}
