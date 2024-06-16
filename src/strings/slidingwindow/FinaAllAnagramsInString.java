package strings.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinaAllAnagramsInString {

    List<Integer> anagramIndicesList = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        //Edge cases
        if(s.isEmpty()|| p.isEmpty()){
            return anagramIndicesList;
        }
        int requiredSubArrayLength = p.length();
        int endIndex = 0;
        int startIndex = 0;
        //Store pattern in HashMap
        Map<Character,Integer> pcharFrequencyMap  = new HashMap<>();
        for(int pIndex = 0; pIndex < p.length(); pIndex++){
            char pchar = p.charAt(pIndex);
            pcharFrequencyMap.put(pchar,pcharFrequencyMap.getOrDefault(pchar,0)+1);
        }
        Map<Character,Integer> scharFrequencyMap  = new HashMap<>();
        while(endIndex < s.length()){
            char schar = s.charAt(endIndex);
            scharFrequencyMap.put(schar,scharFrequencyMap.getOrDefault(schar,0)+1);
            int currentSubArrayLength = (endIndex - startIndex) + 1;
            //check the subarray is of required desired length
            if(currentSubArrayLength == requiredSubArrayLength){
                if(ispermutation(pcharFrequencyMap,scharFrequencyMap)){
                    anagramIndicesList.add(startIndex);
                }

            }
            if(currentSubArrayLength>requiredSubArrayLength){
                //shrink the window from the start
                char previousStartChar = s.charAt(startIndex++);
                scharFrequencyMap.put(previousStartChar,scharFrequencyMap.get(previousStartChar)-1);
                if(scharFrequencyMap.get(previousStartChar)==0){
                    scharFrequencyMap.remove(previousStartChar);
                }
                if(ispermutation(pcharFrequencyMap,scharFrequencyMap)){
                    anagramIndicesList.add(startIndex);
                }
            }
            endIndex++;
        }
        return anagramIndicesList;
    }

    private boolean ispermutation(Map<Character,Integer> patternMap, Map<Character,Integer> sourceMap){
        return patternMap.equals(sourceMap);
    }

}
