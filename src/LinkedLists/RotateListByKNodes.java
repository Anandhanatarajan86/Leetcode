package LinkedLists;

public class RotateListByKNodes {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        // Compute the size of the list
        int size = 0;
        ListNode headPointer = head;
        while (headPointer != null) {
            size++;
            headPointer = headPointer.next;
        }

        // Normalize k to be within the bounds of the list length
        k = k % size;
        if (k == 0) {
            return head;
        }

        // Find the split point
        int firstPartSize = size - k;
        ListNode firstPartPointer = head;
        ListNode firstHalfTailPointer = null;
        int currIndex = 0;
        while (currIndex < firstPartSize - 1) {
            firstPartPointer = firstPartPointer.next;
            currIndex++;
        }
        firstHalfTailPointer = firstPartPointer;

        // Get the second part head
        ListNode secondPartHead = firstPartPointer.next;
        ListNode resHead = secondPartHead;

        // Break the first part
        firstPartPointer.next = null;

        // Find tail pointer of the second part
        ListNode tailPointer = secondPartHead;
        while (tailPointer.next != null) {
            tailPointer = tailPointer.next;
        }

        // Attach the end of the second part to the head
        tailPointer.next = head;

        return resHead;
    }
}
