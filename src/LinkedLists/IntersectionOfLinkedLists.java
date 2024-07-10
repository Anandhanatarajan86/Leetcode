package LinkedLists;

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode headPointer1 = headA;
        ListNode headPointer2 = headB;
        while (headPointer1 != headPointer2) {
            headPointer1 = (headPointer1 == null) ? headB : headPointer1.next;
            headPointer2 = (headPointer2 == null) ? headA : headPointer2.next;

        }
        return headPointer1;
    }
}
