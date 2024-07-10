package Heap;

import java.util.*;
import java.util.stream.Collectors;

public class KlargestSum {
    int kSum(int[] v, int N, int K) {
        int sum = 0;
        Comparator<Integer> numValueComparator = (a, b)->(b-a);
        List<Integer> numList = Arrays.stream(v).boxed().collect(Collectors.toList());
       // Collections.sort(numList,numValueComparator);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(numValueComparator);
        //add all elements to maxHeap
        for(Integer current : v){
            maxHeap.offer(current);
        }
        int count = 1;
        while(count <= K && !maxHeap.isEmpty()){
            sum+=maxHeap.poll();
            count++;
        }
        return sum;
    }
}
