package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
    //edge case if nums.length == 1
    if(nums.length==1){
        return new int[]{-1};
    }
    int[] nextGreaterElement = new int[nums.length];
    int[] modifiedCircularArray = new int[(2* nums.length)-1];
    //fill the circular array
    for(int index = 0; index < modifiedCircularArray.length; index++){
        modifiedCircularArray[index] = nums[index%nums.length];
    }

    Stack<Integer> numStack = new Stack<>();
    for(int index = modifiedCircularArray.length-1; index >=0; index--){
        int currentElement = modifiedCircularArray[index];
        if(numStack.isEmpty()){
            nextGreaterElement[index%nums.length]=-1;
        }
        while(!numStack.isEmpty() && numStack.peek() <= currentElement){
            numStack.pop();
        }
        nextGreaterElement[index%nums.length] =(numStack.isEmpty())?-1:numStack.peek();
        numStack.push(currentElement);


    }
    System.out.println(Arrays.toString(nextGreaterElement));
    return nextGreaterElement;
    }
    public  static  void main(String[] args){
        NextGreaterElement2 nextGreaterElement2 = new NextGreaterElement2();
        nextGreaterElement2.nextGreaterElements(new int[]{1});
        nextGreaterElement2.nextGreaterElements(new int[]{1,2,1});
        nextGreaterElement2.nextGreaterElements(new int[]{1,2,3,4,3});

    }
}
