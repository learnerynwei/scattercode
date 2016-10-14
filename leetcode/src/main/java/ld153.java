
public class ld153 {
  
  public static int findMin(int[] nums) {
    int min = 0;
    int max = nums.length - 1;
    while( min < max){
      int mid = min + (max - min)/2;
      if( nums[min] == nums[mid]) return nums[min] < nums[max] ? nums[min]:nums[max];
      else if( nums[min] < nums[mid] ){
        if( nums[mid] > nums[max] ) min = mid + 1;
        else return nums[min];
      }else{
        max = mid;
      }
    }
    return nums[min];
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int nums[] = new int[7];
    for( int i=0;i < 7; i++){
      int tmp = 0;
      for(int j=0; j < 7; j++){
        nums[(i+j)%7] = (tmp++)%7;
      }
      for(int j=0; j < 7; j++)
        System.out.print(nums[j]);
      System.out.print(" ");
      System.out.println(findMin(nums));
    }
  }
}
