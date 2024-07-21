package stack;

import java.util.ArrayList;
import java.util.List;

public class StackOperations {

    List<String> arrayOperations  = new ArrayList<>();
    int targetIndex = 0;
    public List<String> buildArray(int[] target, int n) {

        for(int element = 1; element <= n; element++){ //fetch the elements from Stream
            if(target[targetIndex]==element){ //if element at top is equal to target element
                arrayOperations.add("push");
                targetIndex++;//just we need to push
            }  //if the element at top is not equal then we need to push and pop to match with desired array
            else{
                arrayOperations.add("push");
                arrayOperations.add("pop");
            }
            //Base Case when we build entire target array
            if(targetIndex>target.length-1){
                return  arrayOperations;
            }

        }
    return arrayOperations;
    }

    public  static  void  main(String[] args){
        StackOperations stackOperations = new StackOperations();
        stackOperations.buildArray(new int[]{1,3},3);
    }

}
