package Arrays.sorting;

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