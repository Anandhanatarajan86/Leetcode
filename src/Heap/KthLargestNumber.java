package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumber {
    public String kthLargestElement(String[] arr, int k) {
        Comparator<String> numStringComparator = (a,b)->(Integer.parseInt(b)-Integer.parseInt(a));

        Arrays.sort(arr,numStringComparator);
        PriorityQueue<String> maxHeap = new PriorityQueue<>(numStringComparator);
        //add all elements to maxHeap
        for(String current : arr){
            maxHeap.offer(current);
        }
        int count = 1;
        while(count < k && !maxHeap.isEmpty()){
            maxHeap.poll();
            count++;
        }
        return  maxHeap.isEmpty()?"":maxHeap.poll();
    }
    public  static  void  main(String[] args){
        KthLargestNumber kthLargestNumber = new KthLargestNumber();
        kthLargestNumber.kthLargestElement(new String[]{"1", "2", "3"},2);
    }
}
