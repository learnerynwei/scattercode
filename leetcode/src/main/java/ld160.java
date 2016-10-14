

public class ld160 {

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null)
      return null;
    ListNode p1 = headA;
    ListNode p2 = headB;

    while (p1.next != null)
      p1 = p1.next;
    p1.next = headA;

    ListNode dumy = new ListNode(-1);
    dumy.next = headB;
    p1 = dumy;
    p2 = dumy;
    while (p1 != null && p1.next != null) {
      p1 = p1.next.next;
      p2 = p2.next;
      if( p1 == p2) break;
    }

    if (p1 == null || p1.next == null)
      return null;
    p1 = dumy;
    while (p1 != p2) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
  }
  
  public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if( headA == null || headB == null) return null;
    int lenA = 0;
    int lenB = 0;
    ListNode pA = headA;
    ListNode pB = headB;
    while(pA != null){
      lenA++;
      pA = pA.next;
    }
    while(pB != null){
      lenB++;
      pB = pB.next;
    }
    
    pA = headA;
    int i = 0;
    while(pA != null && i < (lenA - lenB)){
      pA = pA.next;
      i++;
    }
    
    i=0;
    pB = headB;
    while(pB != null && i < (lenB - lenA)){
      pB = pB.next;
      i++;
    }
    
    while( pA != null && pB != null && pA != pB ){
      pA = pA.next;
      pB = pB.next;
    }
    
    if( pA == pB ) return pA;
    else return null;
  }

  
  public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    ListNode pa = headA;
    ListNode pb = headB;
    while( pa != pb){
      pa = pa == null ? headB : pa.next;
      pb = pb == null ? headA : pb.next;
    }
    return pa;
  }
  
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

  private static int random() {
    return (int) (Math.random() * 10);
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
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // ListNode headA = new ListNode(-1);
    int i = 5;
    while (i-- > 0) {
      int a = random();
      int b = random();
      int c = random();
      System.out.println("a:" + a);
      ListNode headA = createListNode(a);
      printList(headA);
      System.out.println("b:" + b);
      ListNode headB = createListNode(b);
      printList(headB);
      System.out.println("c:" + c);
      ListNode headC = createListNode(c);
      printList(headC);
      ListNode p = headA;
      concatList(headA, headC);
      printList(headA);
      concatList(headB, headC);
      printList(headB);
      p = getIntersectionNode3(headA, headB);
      if( p == null)
        System.out.println("-----false----");
      else
        System.out.println("-----" + p.val + "-----");
    }
  }
}
/*
 * No intersection: [1,3,5,7,9,11,13,15,17,19,21]
[2,4]
 */


