package arrays.binarysearch;


public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int pivotIndex = -1;
        if(nums.length==1){
            pivotIndex =0;
        }

        //check the pivot index or transition point in the array
        for (int index = 0; index < nums.length-1; index++) {
            if (nums[index] <= nums[index + 1]) {
                continue;
            } else {
                pivotIndex = index + 1;
                break;
            }
        }
        //if there is no rotation
        if(pivotIndex==-1){
            return findByBinarySearch(nums,0,nums.length-1,target);
        }
        //Search left subarray using Binary Search
        int targetIndex = findByBinarySearch(nums, 0, pivotIndex - 1, target);
        if (targetIndex != -1) {
            return targetIndex;
        }
        return findByBinarySearch(nums, pivotIndex, nums.length - 1, target);

    }

    private int findByBinarySearch(int[] nums, int left, int right, int target) {
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
    return answer;

    }
public static void main(String[] args){
    SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
    System.out.println(searchInRotatedArray.search(new int[]{4,5,6,7,0,1,2},0));
    System.out.println(searchInRotatedArray.search(new int[]{4,5,6,7,0,1,2},3));
    System.out.println(searchInRotatedArray.search(new int[]{1},0));
}

}
