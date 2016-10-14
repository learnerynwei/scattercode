public class ld154 {
  
  public static int findMin(int[] nums) {
    int min = 0;
    int max = nums.length - 1;
    while( min < max){
      int mid = min + (max - min)/2;
      if( nums[min] == nums[mid]){
        if( min == mid ) return nums[min] < nums[max] ? nums[min]:nums[max];
        else if ( nums[mid] < nums[max] ) return nums[mid];
        else if ( nums[mid] > nums[max] ) min = mid + 1;
        else {
          min++;
          max--;
        }
      } else if( nums[min] < nums[mid] ){
        if( nums[mid] > nums[max] ) min = mid + 1;
        else return nums[min];
      } else {
        max = mid;
      }
    }
    return nums[min];
  }
  
  //超时
  public static int findMin1(int[] nums) {
    int min = 0;
    int max = nums.length - 1;
    while( min < max){
      int mid = min + (max - min)/2;
      if( nums[min] == nums[mid]){
        if( min == mid ) return nums[min] < nums[max] ? nums[min]:nums[max];
        else if ( nums[mid] < nums[max] ) return nums[mid];
        else if ( nums[mid] > nums[max] ) min = mid + 1;
        else {
          while( min < mid && nums[min] == nums[min+1]) min++;
        }
      } else if( nums[min] < nums[mid] ){
        if( nums[mid] > nums[max] ) min = mid + 1;
        else return nums[min];
      } else {
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
        nums[(i+j)%7] = tmp%7;
        if( j != 2) tmp++;
      }
      for(int j=0; j < 7; j++)
        System.out.print(nums[j]);
      System.out.print(" ");
      System.out.println(findMin(nums));
      for(int j=0; j < 7; j++){
        nums[j] = 4;
      }
      for(int j=0; j < 7; j++){
        nums[j] = 1;
        for(int p=0; p < 7; p++)
          System.out.print(nums[p]);
        System.out.print(" ");
        System.out.println(findMin(nums));
      }
    }
    
  }
}
