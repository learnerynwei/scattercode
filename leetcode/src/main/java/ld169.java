

import java.util.Arrays;
import java.util.*;
import java.util.concurrent.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class ld169 {

  public static int majorityElement(int[] nums) {
    if( nums.length <= 0) return 0;
    int major = 0;
    int count = 0;
    for( int i : nums){
      if( count == 0 ){
        major = i;
        count++;
      }else if( major == i){
        count++;
      }else{
        count--;
      }
    }
    return major;
  }
  
  public static int majorityElement2(int[] nums) {
    Arrays.sort(nums);
//    ConcurrentLinkedDeque<Object>  ht;
    return nums[nums.length/2];
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for( int i=0; i < 10; ++i){
      int nums[] = new int[ListUtils.random(0,100)];
      Arrays.fill(nums, 5);
      int time = ListUtils.random(0, nums.length/2);
      for( int j = 0; j < time; ++j){
        nums[ListUtils.random(0, nums.length)] = ListUtils.random(-100, 100);
      }
      
      ArrayUtils.printArray(nums);
      System.out.println("Majority Ele: " + majorityElement(nums));
      System.out.println("Majority Ele2: " + majorityElement2(nums));
    }
  }
}
