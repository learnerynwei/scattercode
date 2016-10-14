/**
 * Created by wyn on 2016/9/18.
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    class MyComparator implements  Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            if( (Integer)o1 < (Integer)o2) return 1;
            else if( o1 == o2) return 0;
            else return -1;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums == null || nums.length <= 0 || nums.length < k) return new int[0];

        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new MyComparator());
        for(int i=0;i < k;++i){
            pq.add(nums[i]);
        }

        int count = 0;
        res[count++] = pq.peek();
        for(int i=k; i < nums.length; ++i){
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            res[count++] = pq.peek();
        }
        return res;
    }

    public static void main(String[] argv){
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1};//{1,3,-1,-3,5,3,6,7};
        swm.maxSlidingWindow(nums, 1);
    }
}
