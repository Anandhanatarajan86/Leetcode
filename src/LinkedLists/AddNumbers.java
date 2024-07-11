package LinkedLists;

import java.util.LinkedList;
import java.util.List;

public class AddNumbers {
    Integer carry   = 0;
    ListNode nodePointer1 = null;
    ListNode nodePointer2  = null;
    List<Integer> sumDigitsList= new LinkedList<>();
    ListNode        predecessor     = null;
    ListNode         resHead        = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //edge case when either l1 or l2 is null
        if(l1==null ||l2==null)
            return l1!=null?l1:l2;
        //initialize node pointers for l1 & l2
        nodePointer1 = l1;
        nodePointer2 = l2;
        predecessor = new ListNode();
        resHead     = predecessor;
        while(nodePointer1!=null || nodePointer2!=null){

            Integer digit1 = (nodePointer1!=null)?nodePointer1.val : 0;
            Integer digit2 = (nodePointer2!=null)?nodePointer2.val : 0;

            Integer sum    = (digit1 + digit2) + carry;
            //calculate carry
            carry           = sum / 10;//(e.g 14/10 = 1)

            Integer sumDigit        = sum %10;//(e.g 14%10  = 4)
            sumDigitsList.add(sumDigit);

            //move the nodePointers
            if(nodePointer1!=null)
                nodePointer1 = nodePointer1.next;

            if(nodePointer2!=null)
                nodePointer2 = nodePointer2.next;
        }

        for(Integer sumDigit : sumDigitsList){
            resHead.next = new ListNode(sumDigit);
            resHead      = resHead.next;

        }

        //check the finaly Carray
        if(carry!=0)
            resHead.next = new ListNode(carry);
        //resHead      = resHead.next;
        return predecessor.next;
    }
}
