
import java.util.HashMap;
import java.util.TreeMap;

import sun.reflect.generics.tree.Tree;

public class ld166 {

  public static String fractionToDecimal_O(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    StringBuilder res = new StringBuilder();
    // "+" or "-"
    res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);

    // integral part
    res.append(num / den);
    num %= den;
    if (num == 0) {
      return res.toString();
    }

    // fractional part
    res.append(".");
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    map.put(num, res.length());
    while (num != 0) {
      num *= 10;
      res.append(num / den);
      num %= den;
      if (map.containsKey(num)) {
        int index = map.get(num);
        res.insert(index, "(");
        res.append(")");
        break;
      } else {
        map.put(num, res.length());
      }
    }
    return res.toString();
  }

  //注意边界问题，包括INT_MAX，INT_MIN处理
  //负数在java中测取模值
  public static String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0)
      return "-1";
    StringBuilder builder = new StringBuilder();
    if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
      builder.append('-');
    long _numerator = numerator < 0 ? -(long)numerator : numerator;
    long _denominator = denominator < 0 ? -(long)denominator : denominator;
    builder.append(_numerator / _denominator);
    long rem = _numerator % _denominator;
    if (rem != 0)
      builder.append('.');
    int curlen = builder.length();
    HashMap<Long, Integer> mem = new HashMap<>();
    rem *= 10;

    while (rem != 0) {
      if (mem.containsKey(rem)) {
        builder.insert(mem.get(rem), "(");
        builder.append(')');
        break;
      }
      mem.put(rem, curlen++);
      builder.append(rem / _denominator);
      rem = (rem % denominator) * 10;
    }
    return builder.toString();
  }

  /*
   * -1,-2147483648
   */
  public static void main(String[] args) {
    for (int i = 0; i < 10; ++i) {
      int numerator = ListUtils.random(-100, 100);
      int denominator = ListUtils.random(1, 100);
      System.out.println("num: " + numerator + " dem: " + denominator);
      String myres = fractionToDecimal(numerator, denominator);
      String otres = fractionToDecimal_O(numerator, denominator);
      System.out.println("My result: " + myres);
      System.out.println("Other result: " + otres);
      System.out.println("res: " + myres.equals(otres));
    }
    System.out.println(fractionToDecimal(-1, -2147483648));
  }
}
