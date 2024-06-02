package arrays.dp;

public class Equalpartitionwithmemo {
    int totalSum = 0;
    Boolean[][] memo;
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
        memo= new Boolean[nums.length+1][totalSum+1];
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

        //recall the memo
        if(memo[currIndex][currSum]!=null){
            return memo[currIndex][currSum];
        }

        //have two choices we can include current element
        //Choice 1 : include curr element
        currSum = currSum + nums[currIndex];
        boolean choice1 = recursiveHelper(nums,currIndex + 1,currSum,subTarget);
        currSum = currSum - nums[currIndex];
        //Choice 2 : do not include curr element
        boolean choice2 = recursiveHelper(nums,currIndex + 1, currSum,subTarget);
        memo[currIndex][currSum] = (choice1||choice2);
        return memo[currIndex][currSum] ;

    }
}
