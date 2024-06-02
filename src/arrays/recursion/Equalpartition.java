package arrays.recursion;

public class Equalpartition {

    int totalSum = 0;
    public boolean canPartition(int[] nums) {
        //calculate totalSum
        for(int element : nums){
            totalSum+=element;
        }
        //if the totalSum is ODD return false since ODD can not be divided
        if(totalSum %2 ==1){
            return false;
        }
        int subsetTarget = totalSum / 2;
        return recursiveHelper(nums,0,0,subsetTarget);
    }

    private boolean recursiveHelper(int[] nums, int currIndex, int currSum, int subTarget){
        //Base Case
        if(currSum == subTarget){
            return true;
        }
        if(currIndex == nums.length){
            return false;
        }
        //have two choices we can include current element
        //Choice 1 : include curr element
        currSum += nums[currIndex];
        boolean choice1 = recursiveHelper(nums,currIndex + 1,currSum,subTarget);
        currSum = currSum - nums[currIndex];

        //Choice 2 : do not include curr element
        boolean choice2 = recursiveHelper(nums,currIndex + 1, currSum,subTarget);

        return (choice1||choice2);

    }
}
