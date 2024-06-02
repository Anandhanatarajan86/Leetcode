package arrays.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class FrequencySort {
    Map<Character,Integer> frequencySortMap = new HashMap<>();
    StringBuilder resBuilder = new StringBuilder();
    public String frequencySort(String s) {
        //Write your code here
        Character[] tempArray = new Character[s.length()];
        for(int index = 0; index < s.length();index++){
            tempArray[index] = s.charAt(index);
        }
        for(char temp : tempArray){
            frequencySortMap.put(temp,frequencySortMap.getOrDefault(temp,0)+1);

        }
        Comparator<Character> frequencyComparator = ((a, b)->(frequencySortMap.get(b)==frequencySortMap.get(a))?
                a-b:frequencySortMap.get(b)-frequencySortMap.get(a));

        Arrays.sort(tempArray,frequencyComparator);
       for(char temp: tempArray){
           resBuilder.append(temp);
       }
       System.out.println(resBuilder.toString());
        return  resBuilder.toString();

    }

    public  static  void  main(String[] args){
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.frequencySort("aA");
    }

}
