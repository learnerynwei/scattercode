/**
 * Created by wyn on 2016/9/17.
 */
public class CreateMaximunNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(k <= 0) return new int[0];
        int[] res = new int[k];
        maxNumber(nums1, 0, nums2, 0, k, res);
        return res;
    }

    public void maxNumber(int[] nums1, int step1, int[] nums2, int step2, int k, int[] res){
         if(k <= 0) return ;
        int max = -1, ind = -1;
        boolean isFirst = false;
        int up1 = Math.min(nums1.length - k + nums2.length - step2 + 1 , nums1.length);
        int up2 = Math.min(nums2.length - k + nums1.length - step1 + 1, nums2.length);
        for(int i = step1;i < up1; ++i){
            if(max < nums1[i]){
                max = nums1[i];
                ind = i;
                isFirst = true;
            }
        }
        for(int i = step2;i < up2; ++i){
            if(max < nums2[i]){
                max = nums2[i];
                ind = i;
                isFirst = false;
            }
        }
        res[res.length - k] = max;
        if(isFirst){
            maxNumber(nums1, ind + 1, nums2, step2, k - 1, res);
        }else{
            maxNumber(nums1, step1, nums2, ind + 1, k - 1, res);
        }
    }

    public static void main(String[] args) {
        CreateMaximunNumber l209 = new CreateMaximunNumber();
        // for (int i = 0; i < 30; i++) {
        // TreeNode root = TreeUtils.createCBT(i);
        // System.out.println(l209.countNodes(root));
        // }

        int[] a = {6, 7};//{ 3, 4, 6, 5 };
        int[] b = {6, 0, 4};//{ 9, 1, 2, 5, 8, 3 };
        l209.maxNumber(a, b, 5);
    }
}
