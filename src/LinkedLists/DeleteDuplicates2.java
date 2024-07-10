package LinkedLists;

public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode predecessor = dummyHead;
        predecessor.next     = head;
        ListNode headPointer  = head;
        while(headPointer!=null){
            ListNode tempNextNode = headPointer.next;
            if(tempNextNode!=null && headPointer.val==tempNextNode.val){
                while(tempNextNode!=null && tempNextNode.val == headPointer.val){
                    tempNextNode = tempNextNode.next;
                }
                predecessor.next = tempNextNode; // Skip all duplicates
                headPointer = tempNextNode; // Move headPointer to next unique node

            }
            else{
                predecessor = predecessor.next; // Move predecessor only if no duplicates
                headPointer = headPointer.next; // Move headPointer to next node
            }
            //  headPointer = headPointer.next;
        }
        return dummyHead.next;
    }
}
