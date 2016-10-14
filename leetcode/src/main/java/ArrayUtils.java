
import java.util.TreeSet;

public class ArrayUtils {
  public static void createArray(int nums[]) {
    if (nums == null || nums.length == 0)
      return;
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) Math.round(Math.random() * 10) - 5;
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static void createArray(int nums[], int min, int max, boolean allowRep) {
    if (nums == null || nums.length == 0)
      return;
    TreeSet<Integer> tempSet = new TreeSet<Integer>();
    int range = max - min;
    for (int i = 0; i < nums.length; i++) {
      int tmp = (int) Math.round(Math.random() * range) + min;
      if (!allowRep)
        while (tempSet.contains(tmp))
          tmp = (int) Math.round(Math.random() * range) + min;
      nums[i] = tmp;
      tempSet.add(tmp);
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static void printArray(int nums[]) {
    if (nums.length == 0)
      System.out.println("NULL");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static String createVersion() {
    int len = ListUtils.random(1, 10);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      builder.append(ListUtils.random(1, 1000));
      if (i != len - 1)
        builder.append('.');
    }
    return builder.toString();
  }
}
