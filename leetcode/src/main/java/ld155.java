
import java.math.*;
import java.util.Stack;

public class ld155 {
  // Runtime error
  //
  // class StackNode {
  // int value;
  // StackNode pre;
  // StackNode next;
  //
  // public StackNode(int v) {
  // value = v;
  // this.pre = null;
  // this.next = null;
  // }
  //
  // public StackNode(int v, StackNode pre, StackNode next) {
  // value = v;
  // this.pre = pre;
  // this.next = next;
  // }
  // }
  //
  // class ArrayNode {
  // StackNode node;
  // ArrayNode next;
  //
  // public ArrayNode(StackNode n, ArrayNode top) {
  // this.node = n;
  // this.next = top;
  // }
  // }
  //
  // StackNode min;
  // ArrayNode top;
  //
  // /** initialize your data structure here. */
  // public ld155() {
  // min = new StackNode(Integer.MIN_VALUE);
  // top = null;
  // }
  //
  // public void push(int x) {
  //// System.out.println("push :" + x);
  // StackNode newNode = new StackNode(x);
  // StackNode tmpNode = min;
  // while (tmpNode.next != null && tmpNode.value < x) {
  // tmpNode = tmpNode.next;
  // }
  // if (tmpNode.next == null && tmpNode.value < x) {
  // tmpNode.next = newNode;
  // newNode.pre = tmpNode;
  // } else {
  // newNode.pre = tmpNode.pre;
  // tmpNode.pre = newNode;
  // newNode.pre.next = newNode;
  // newNode.next = tmpNode;
  // }
  //
  // top = new ArrayNode(newNode, top);
  // }
  //
  // public void pop() {
  // if (top == null) {
  //// System.out.println("pop: null");
  // return;
  // }
  //// System.out.println("pop :" + top.node.value);
  // StackNode tmpNode = top.node;
  // top = top.next;
  //
  // if (tmpNode.next != null) {
  // tmpNode.next.pre = tmpNode.pre;
  // tmpNode.pre.next = tmpNode.next;
  // } else {
  // tmpNode.pre.next = null;
  // }
  // }
  //
  // public int top() {
  // if (top != null)
  // return top.node.value;
  // return Integer.MIN_VALUE;
  // }
  //
  // public int getMin() {
  // if (min.next != null)
  // return min.next.value;
  // return min.value;
  // }

  private static int random(int max) {
    return (int) (Math.random() * max);
  }

  Stack<Integer> stack;
  int            min;

  public ld155() {
    stack = new Stack<Integer>();
    min = Integer.MAX_VALUE;
  }

  // x == min  0 1 0--> max010 pop一次后 min = 1
  public void push(int x) {
    System.out.println("Push: " + x);
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    System.out.println("Pop: " + stack.peek());
    if (min == stack.peek()) {
      stack.pop();
      min = stack.pop();
    }else{
      stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ld155 test = new ld155();
    for (int i = 0; i < 5; i++) {
      test.push(random(20));
    }
    for (int i = 0; i < 30; i++) {

      switch (random(4)) {
      case 0:
        test.push(random(20));
        break;
      case 1:
        test.pop();
        break;
      case 2:
        System.out.println("top: " + test.top());
        break;
      case 3:
        System.out.println("getMin: " + test.getMin());
        break;
      }

    }
  }
}
