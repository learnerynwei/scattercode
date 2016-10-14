
public class ListUtils {
  public static ListNode createListNode(int n) {
    if (n <= 0)
      return null;

    ListNode head = new ListNode(random());
    ListNode p = head;
    while (--n > 0) {
      p.next = new ListNode(random());
      p = p.next;
    }
    return head;
  }

  public static int random() {
    return (int) (Math.random() * 10);
  }

  public static int random(int min, int max) {
    return (int) (Math.random() * (max - min)) + min;
  }
  
  public static ListNode concatList(ListNode headA, ListNode headB) {
    if (headA == null)
      return headB;
    if (headB == null)
      return headA;

    ListNode p = headA;
    while (p.next != null) {
      p = p.next;
    }
    p.next = headB;
    return headA;
  }

  public static void printList(ListNode head){
    if( head == null ){
      System.out.println("NULL");
      return ;
    }
    ListNode p = head;
    while( p != null){
      System.out.print(p.val + "-->");
      p = p.next;
    }
    System.out.println("NULL");
  }
}

class ListNode {
  int      val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}