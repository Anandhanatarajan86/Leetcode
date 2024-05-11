public class DutchNationalFlag {

    int zerosIndex = -1;
    int twosIndex  = -1;
    public void sort(int[] nums){
        calculateIndex(nums);
       // twosIndex = nums.length;
            for(int index = 0; index <=zerosIndex;index++){
                nums[index] =0;
            }
            for(int oneIndex = 1+zerosIndex;oneIndex<twosIndex;oneIndex++){
                nums[oneIndex] =1;
            }
            for(int twoIndex = twosIndex;twoIndex < nums.length;twoIndex++ ){
                nums[twoIndex]=2;
            }
        }
      private void   calculateIndex(int[] nums){
            //Write your code here
            twosIndex = nums.length;
            //just skim though 0's
            for(int element : nums){
                if(element==0){
                    zerosIndex++;
                }
                else if(element==2){
                    twosIndex--;
                }
                else continue;
            }
        }

    public static  void  main(String[] args){
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag();
        dutchNationalFlag.sort(new int[]{1,0,2,1,0,2,1,0});
    }
}


