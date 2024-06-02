package arrays.sorting;

/**
 * This problem can be solved using two pointers
 * (i.e) 0 are grouped under index redIndex
 * 2 are grouped under index blueIndex
 * 1 are stacked in between
 * we have  to keep both pointers at extreme places(front,end)
 * and increment /decrement them
 * Note : when we are swapping current index value with right pointer(that is when 2 is found),
 * then we should not increment current index since there is not guaranteed that is sorted(i.e 0,0,1,1,0,2,2,0,0,2)
 */
class DutchNationalFlag {
    public void sortColors(int[] nums) {
        int redIndex = -1;
        int blueIndex = nums.length;
        int currentIndex = 0;

        while (currentIndex < blueIndex) {
            if (nums[currentIndex] == 0) {
                redIndex++;
                swap(nums, redIndex, currentIndex);
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                blueIndex--;
                swap(nums, blueIndex, currentIndex);
                //  currentIndex++;
            } else {
                currentIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}