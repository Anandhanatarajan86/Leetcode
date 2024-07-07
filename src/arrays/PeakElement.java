package arrays;

import java.util.List;

public class PeakElement {
    public int findPeakElement(List<Integer> nums) {
        for(int index = 0; index < nums.size(); index++){
            if(index==0){
                if(nums.get(index)>=nums.get(index+1)){
                    return nums.get(index);
                }
            }
            else if(index == nums.size()-1){
                if(nums.get(index)>=nums.get(index-1)){
                    return nums.get(index);
                }
            }
            else if(nums.get(index)>=nums.get(index-1) && nums.get(index)>=nums.get(index+1)){
                return nums.get(index);
            }
        }
        return -1;
    }
    public static  void main(String[] agrs){
        PeakElement peakElement = new PeakElement();
        peakElement.findPeakElement(List.of(1, 2, 3, 1));
    }
}
