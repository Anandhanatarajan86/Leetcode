package LinkedLists;

public class RemoveNthNodeFromList {

        int size = 0;

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode headPointer = head;
            while (headPointer != null) {
                size++;
                headPointer = headPointer.next;
            }
            int predessorIndex = size - n;
            ListNode predecessor = null;
            ListNode currPointer = head;
            int currIndex = 0;
            if (predessorIndex == 0 && head.next != null) {
                return head.next;
            }
            while (currPointer != null && currIndex < predessorIndex) {
                predecessor = currPointer;
                currPointer = currPointer.next;
                currIndex++;
            }
            if (predecessor == null) {
                return null;
            }

            // link predecessor with curr next node since curr node is going to be deleted
            predecessor.next = (currPointer != null) ? currPointer.next : null;

            return head;
        }
    }

