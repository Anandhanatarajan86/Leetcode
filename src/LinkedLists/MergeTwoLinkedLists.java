package LinkedLists;

public class MergeTwoLinkedLists {
    ListNode predecessor = new ListNode();
    ListNode dummyHead = predecessor;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Edge case when either of list is null
        if (list1 == null || list2 == null) return list1 != null ? list1 : list2;
        while (list1 != null || list2 != null) {
            //check both nodes are available
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    dummyHead.next = list1;
                    dummyHead = dummyHead.next;
                    list1 = list1.next;

                } else {
                    dummyHead.next = list2;
                    dummyHead = dummyHead.next;
                    list2 = list2.next;
                }
            } else {

                dummyHead.next = (list1 != null) ? list1 : list2;
                break;

            }

        }
        return predecessor.next;
    }

}
