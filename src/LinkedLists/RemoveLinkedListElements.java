package LinkedLists;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null || head.val == val&& head.next==null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode predecessor = dummyHead;
        dummyHead.next = head;
        ListNode headPointer = head;
        while (headPointer != null) {
            if (headPointer.val == val) {
                predecessor.next = predecessor.next.next;

            } else {
                predecessor = predecessor.next;
            }
            headPointer = headPointer.next;

        }
        return dummyHead.next;
    }

}
