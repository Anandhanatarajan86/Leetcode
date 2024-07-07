package strings.hashing;

import java.util.*;

public class FirstNonRepeatingCharAtStream {
    public String firstNonRep(String str) {
        //Write your code here
        char[] wordCharArray = str.toCharArray();
        Set<Character> seen = new HashSet<>();
        char firstNonRepeatingChar = '0';
        StringBuilder resBuilder = new StringBuilder();
        for(int charIndex = 0; charIndex <wordCharArray.length;charIndex++){
            char  firstNonRepeatingCharTillNow= findFirstNonRepearingCharTillNow(str,charIndex);
            resBuilder.append(firstNonRepeatingCharTillNow);
        }
        System.out.println(resBuilder.toString());
        return  resBuilder.toString();
    }

    private char findFirstNonRepearingCharTillNow(String current, int range) {
        if(range==0){
            return current.charAt(0);
        }
        Map<Character,Integer> charFrequencyMap = new LinkedHashMap<>();
        int startIndex = 0;
        while(startIndex <=range){
            char temp = current.charAt(startIndex);
            charFrequencyMap.put(temp,charFrequencyMap.getOrDefault(temp,0)+1);
            startIndex++;
        }
        for(Map.Entry<Character,Integer> entry: charFrequencyMap.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
    return  'X';
    }

    public  static void main(String[] args){
        FirstNonRepeatingCharAtStream firstNonRepeatingCharAtStream = new FirstNonRepeatingCharAtStream();
        firstNonRepeatingCharAtStream.firstNonRep("assadfgdfga");
    }
}
