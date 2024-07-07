package backtracking;

public class SubsetEqualsK {

    boolean isSubsetSum(int[] arr, int n, int k) {
        return dfsHelper(arr, 0, 0, k);
    }
    //Helper method for check subset equals k

    private boolean dfsHelper(int[] arr, int currIndex, int currSum, int k) {
        //Base Case when currIndex reaches end of array
        if (currIndex == arr.length) {
            return false;
        }
        //Check current sum equals K
        if (currSum == k) {
            return true;
        }
        //explore all choices
        boolean pathSumFromHere = false;
        for (int choice = currIndex; choice < arr.length; choice++) {
            // Strategy 1: PICK STRATEGY
            //Pick current choice to currSum
            boolean possibleOne = dfsHelper(arr, 1 + currIndex, currSum + arr[choice], k);
            //Strategy 2 : SKIP STRATEGY
            boolean possibleTwo = pathSumFromHere = dfsHelper(arr, 1 + currIndex, currSum, k);
            //check if any of the possibility
            if (possibleOne || possibleTwo) {
                pathSumFromHere = true;
                return pathSumFromHere;
            }

        }
        return pathSumFromHere;

    }
    public  static  void  main(String[] args){
        SubsetEqualsK subsetEqualsK = new SubsetEqualsK();
        boolean result = subsetEqualsK.isSubsetSum(new int[]{1, 4, 4, 5},4,5);
        System.out.println(result);
    }


}
