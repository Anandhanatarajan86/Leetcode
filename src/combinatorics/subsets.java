package combinatorics;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    List<List<Integer>> allSubsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //Edge case when nums.length is zero or empty
        if(nums.length==0){
            return allSubsets;
        }
        dfsHelper(nums, 0,new ArrayList<>());
        return allSubsets;
    }

    //Dfs Helper
    private void dfsHelper(int[] nums, int currIndex, List<Integer> currSubset){
        //Base Case when reached nums.length
        if(currIndex == nums.length && !allSubsets.contains(currSubset)){
            allSubsets.add(new ArrayList<>(currSubset));
        }
        //explore all choices for current Index
        for(int choice = currIndex; choice < nums.length; choice++){
            //for every choice i have again two options
            //pick the choice
            currSubset.add(nums[choice]);
            dfsHelper(nums,1+choice,currSubset);
            //backtrack
            currSubset.remove(currSubset.size()-1);
            //skip the choice
            dfsHelper(nums,1+choice,currSubset);

        }

    }
}
