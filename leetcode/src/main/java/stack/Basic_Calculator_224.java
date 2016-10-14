package stack;

import java.util.Stack;

/**
 * Created by wyn on 2016/9/28.
 */
public class Basic_Calculator_224 {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i++);
            if( c >= '0' && c <= '9'){
                int num = 0;
                boolean hasNum = false;
                while( c >= '0' && c <= '9'){
                    hasNum = true;
                    num = num * 10 + c - '0';
                    if( i < s.length() )
                        c = s.charAt(i++);
                    else
                        break;
                }
                if(hasNum){
                    while( !ops.empty() && (ops.peek() == '+' || ops.peek() =='-')){
                        if(ops.peek() == '+'){
                            num = nums.pop() + num;
                        }else{
                            num = nums.pop() - num;
                        }
                        ops.pop();
                    }
                    nums.push(num);
                }
                if( i == s.length() && c >= '0' && c <= '9') return nums.pop();
                else i--;
//                i--;
                continue;
            }else if( c == ')'){
                ops.pop();
                while (!ops.empty() && (ops.peek() == '+' || ops.peek() == '-')) {
                    int num = nums.pop();
                    if (ops.peek() == '+') {
                        nums.push(nums.pop() + num);
                    } else {
                        nums.push(nums.pop() - num);
                    }
                    ops.pop();
                }
            }else if( c != ' '){
                ops.push(c);
            }
        }
        return nums.pop();
    }

    public static void main(String[] argc){
        Basic_Calculator_224 bc = new Basic_Calculator_224();
        System.out.println(bc.calculate("0"));
        System.out.println(bc.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(bc.calculate(" 2-1 + 2 "));
        System.out.println(bc.calculate("1 + 1"));
        System.out.println(bc.calculate("0 +  2 - 3 + 4 - 5"));
    }
}
