package arrays.sorting;

import java.util.ArrayList;

public class Merge {
    public void mergeSort(ArrayList<Integer> arr, int left, int right) {
        //Base Case
        helper(arr,left,right,arr);

    }

    private ArrayList<Integer> helper(ArrayList<Integer> arr, int left, int right, ArrayList<Integer> res){
        //Base Case
        if(left>=right){
             new ArrayList<>(arr.get(left));

        }
        int middle = left + (right-left)/2;
        ArrayList<Integer> leftSubList  = helper(arr,left,middle-1,res);
        ArrayList<Integer> rightSubList = helper(arr,middle+1,right,res);
        merge(arr,leftSubList,rightSubList,res);


        return leftSubList;
    }

    private void merge(ArrayList<Integer> arr,ArrayList<Integer> leftList, ArrayList<Integer> rightList,ArrayList<Integer> res){
        int index1 =0; int index2 = 0;
        while(index1<leftList.size() && index2 < rightList.size()){
            int firstElement   = leftList.get(index1);
            int secondElement  = rightList.get(index2);
            if(firstElement <= secondElement){
                res.add(firstElement);
                index1++;
            }
            else{
                res.add(secondElement);
                index2++;
            }
        }
        while(index1<leftList.size()){
            res.add(leftList.get(index1++));
        }
        while(index2<rightList.size()){
            res.add(rightList.get(index2++));
        }
        arr = res;
    }

}
