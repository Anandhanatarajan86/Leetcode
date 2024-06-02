package arrays.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Intuition behind this problem is we need to divide
 *  the list/array in such a way first portion
 * of partitioned array will contain non 2's element while second
 * partition wil contain only 2's
 *
 */


public class Move2s {
    int nonTwoElementIndex = -1;
    List<Integer> modifiedList = new ArrayList<>();
    public void moveTwos(List<Integer> nums) {
        for(Integer element : nums){
            if(element!=2){
                //incrementnonTwoElementIndex
                nonTwoElementIndex++;
                modifiedList.add(nonTwoElementIndex,element);//assign them
            }
        }
        //find the patition divide or starting point of 2 index
        Integer twoStartIndex = nonTwoElementIndex + 1;
        while(twoStartIndex < nums.size()){
            modifiedList.add(twoStartIndex++,2);
        }
        //clear original list
        nums.clear();
        nums.addAll(modifiedList);

    }
}
