package arrays.sorting;

import java.util.HashSet;
import java.util.Set;

public class MaximumGap {
    Set<Integer> numsSet = new HashSet<>();
    int maxGap = 0;

    public int maximumGap(int[] arr) {
        // edge case if the number of elements are less than 2
        if (arr.length < 2) {
            return maxGap;
        }

        // find the Min/Max Value for the given arr elements
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            // add to HashSet
            numsSet.add(value);
        }
        // start from lowest value to highest value and search for each immediate next
        // in Hashset
        // and if it is found update MaxGap
        for (int value = min; value < max; ) {
            if (numsSet.contains(value)) {
                int immediateNext = value + 1;
                while (!numsSet.contains(immediateNext) && immediateNext <= max) {
                    immediateNext++;
                }
                // calculate the difference
                int difference = immediateNext - value;
                maxGap = Math.max(maxGap, difference);
                //optimization
                value = immediateNext;

            }
            else{
                value++;
            }

        }
        System.out.println("pritnign maxGap::" + maxGap);
        return maxGap;
    }
    public  static  void main(String[] args){
        MaximumGap maximumGap = new MaximumGap();
        maximumGap.maximumGap(new int[]{1,3,100});
    }
}
