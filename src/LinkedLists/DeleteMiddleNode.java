package LinkedLists;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No middle node to delete
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode prev = null; // To track the previous node of slowPointer

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            prev = slowPointer;
            slowPointer = slowPointer.next;
        }

        // Now slowPointer is pointing to the middle node
        if (prev != null) {
            // Update the previous node's next pointer to skip the middle node
            prev.next =  prev.next.next;
        } else {
            // If the middle node is the head, update head to the next node
            head = head.next;
        }

        return head;
    }
}
