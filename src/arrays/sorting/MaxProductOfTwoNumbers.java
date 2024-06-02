package arrays.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProductOfTwoNumbers {
    public int maxProduct(int[] nums) {
     Comparator<Integer> maxComparator = Comparator.reverseOrder();

        PriorityQueue<Integer> maxPqueue = new PriorityQueue<>(maxComparator);
        for(int element : nums){
            maxPqueue.offer(element);
        }
        System.out.println(maxPqueue.peek());
        System.out.println(maxPqueue.poll());
        System.out.println(maxPqueue.peek());
        System.out.println(maxPqueue.poll());
        System.out.println(maxPqueue.peek());
      //  System.out.println(maxPqueue.poll());
        return (maxPqueue.poll()-1)* (maxPqueue.poll()-1);
    }
    public  static  void  main(String[] args){
        MaxProductOfTwoNumbers maxProductOfTwoNumbers = new MaxProductOfTwoNumbers();
        maxProductOfTwoNumbers.maxProduct(new int[]{1,5,4,5});
    }
}
