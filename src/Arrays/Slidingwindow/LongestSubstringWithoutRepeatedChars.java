package Arrays.Slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatedChars {
    static final int NO_OF_CHARS = 256;
    int res = 0;
    Map<Character,Integer> charIndexMap = new HashMap<>();
    int longestUniqueSubsttr(String str) {
        char[] tempArray = str.toCharArray();
        int startIndex = 0; int endIndex = 0;
        while(endIndex < tempArray.length){
            char temp = tempArray[endIndex];
            if(!charIndexMap.containsKey(temp)){
                //calculate curr window len
                int winLen = (endIndex -startIndex) + 1;
                res        = Math.max(res,winLen);
            }
            //if the charcter is seen, check the last index where that character occured
            else {
                startIndex = Math.max(startIndex, charIndexMap.get(temp)+1);
                //now constraint sataisfy
                int winLen = (endIndex -startIndex) + 1;
                res        = Math.max(res,winLen);

            }
            charIndexMap.put(temp,endIndex);
            endIndex++;
        }
        System.out.println(res);
return  res;
    }


    public  static  void  main(String[] args){
        LongestSubstringWithoutRepeatedChars longestSubstringWithoutRepeatedChars = new LongestSubstringWithoutRepeatedChars();
        longestSubstringWithoutRepeatedChars.longestUniqueSubsttr("Heycoachsuper30");
    }
}
