import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ld39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (candidates.length <= 0)
      return res;
    List<Integer> cur = new ArrayList<Integer>();
    // Arrays.sort(candidates);
    dfs(candidates, 0, target, cur, res);
    return res;
  }

  public void dfs(int[] candidates, int index, int target, List<Integer> cur,
      List<List<Integer>> res) {
    if (0 == target) {
      res.add(new ArrayList<Integer>(cur));
      return;
    }
    if (target < 0) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      cur.add(candidates[i]);
      dfs(candidates, i, target - candidates[i], cur, res);
      cur.remove(cur.size() - 1);
    }
  }

  public List<String> findRepeatedDnaSequences(String s) {
    List<String> res = new LinkedList<String>();
    if (s == null || s.length() <= 10)
      return res;
    Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
    int cur = 0;
    for (int i = 0; i < 10; ++i) {
      cur = (cur << 3) + (s.charAt(i) & 7);
    }
    mem.put(cur, 1);
    for (int i = 10; i < s.length(); i++) {
      cur = ((cur << 3) & 0x3fffffff) | (s.charAt(i) & 7);
      if (mem.get(cur) == null) {
        mem.put(cur, 1);
      } else if (mem.get(cur) == 1) {
        res.add(s.substring(i - 9, i + 1));
        mem.put(cur, 2);
      }
    }
    return res;
  }

  public int missingNumber(int[] nums) {
    if (nums == null || nums.length == 0)
      return -1;
    for (int i = 0; i < nums.length; ++i) {
      if( nums[i] != i){
        int j = nums[i];
        while(j < nums.length && nums[j] != j){
          int next = nums[j];
          nums[j] = j;
          j = next;
        }
      }
    }
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != i)
        return i;
    }
    return nums.length;
  }

  public int maxProduct(String[] words) {
    if(words == null || words.length == 0) return 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i < words.length; ++i){
        int cur = 0;
        for(int j=0; j < words[i].length();++j)
            cur |= (1 << (words[i].charAt(j)));
        if(map.get(cur) == null){
            map.put(cur, words[i].length());
        }else if(map.containsKey(cur)){
            map.put(cur, Math.max(words[i].length(), map.get(cur) ) );
        }
    }
    
    
    int max = 0;
    Set<Integer> keys = map.keySet();
    Iterator iterator = keys.iterator();
    while (iterator.hasNext()) { 
        //遍历Set集合
        Integer key = (Integer)iterator.next();
        Iterator iteratorInner = keys.iterator();
        while (iteratorInner.hasNext()) {
            Integer keyInner = (Integer)iteratorInner.next();
            if( ( key.intValue() & keyInner.intValue() ) == 0 &&
                map.get(key) * map.get(keyInner) > max)
                max = map.get(key) * map.get(keyInner) ;
        }
    }
    return max;
}
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ld39 ld = new ld39();
    int c[] = { 5, 4, 2, 0, 1 };
    System.out.println(ld.missingNumber(c));
    // int a[] = { 3, 2, 6, 7 };
    // int b[] = { 1 };
    // List<List<Integer>> res = ld.combinationSum(a, 7);
    // System.out.println(res);
    // System.out.println(ld.combinationSum(b, 2));
//    System.out.println(ld.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
  }
}
