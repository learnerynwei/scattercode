import java.util.PriorityQueue;

/**
 * Created by wyn on 2016/9/17.
 */
public class KthLargestElement_in_anArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) return -1;
        creatHeap(nums,k);
        for(int i=k;i < nums.length;++i){
            if(nums[i] > nums[0]){
                swap(nums, 0, i);
                adjust(nums, 0, k);
            }
        }
        return nums[0];
    }

    public void creatHeap(int[] nums, int k){
        for(int i=k/2; i >= 0; --i)
            adjust(nums, i, k);
    }

    public void adjust(int[] nums, int start,  int k){
        int i=start;
        while(i < k){
            int left = (i << 1) + 1;
            if(left >= k) break;
            int right = (i << 1) + 2;
            if(right >= k){
                if(nums[left] < nums[i]){
                    swap(nums, i, left);
                }
                break;
            }
            if(nums[left] < nums[right] ){
                if( nums[left] < nums[i]){
                    swap(nums,i,left);
                    i = left;
                }else break;
            }else{
                if( nums[right] < nums[i] ){
                    swap(nums, i, right);
                    i = right;
                }else break;
            }
        }
    }

    public void swap(int[] nums, int first, int second){
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }

    public static void main(String[] argc){
        KthLargestElement_in_anArray ins = new KthLargestElement_in_anArray();
        int[] a = {7,6,5,4,3,2,1};
        System.out.println(ins.findKthLargest(a, 5));
    }
}
