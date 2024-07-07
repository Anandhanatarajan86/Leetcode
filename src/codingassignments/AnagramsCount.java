package codingassignments;

import java.util.HashMap;
import java.util.Map;

public class AnagramsCount {
    public int countAnagrams(String target, String src) {
     int targetSubStrlength = src.length();
     int anagramCounts      = 0;
     //store src char and it's frequencies
        Map<Character,Integer> srcMap = new HashMap<>();
        Map<Character,Integer> targetMap = new HashMap<>();
        for(char srcChar : src.toCharArray()){
            srcMap.put(srcChar,srcMap.getOrDefault(srcChar,0)+1);
        }
        int endIndex = 0;
        int startIndex = 0;
        while(endIndex < target.length()){
            char targetChar = target.charAt(endIndex);
            targetMap.put(targetChar,targetMap.getOrDefault(targetChar,0)+1);
            int currSubStrLength = (endIndex - startIndex)+1;
            if(currSubStrLength == targetSubStrlength){
                if(isAnagram(srcMap,targetMap)){
                    anagramCounts++;
                }
            }
            else if(currSubStrLength > targetSubStrlength){
                char prevChar = target.charAt(startIndex++);
                targetMap.put(prevChar,targetMap.getOrDefault(prevChar,0)-1);
                if(targetMap.get(prevChar)==0){
                    targetMap.remove(prevChar);
                }
                int currSubStrLength1 = (endIndex - startIndex)+1;
                if(currSubStrLength1 == targetSubStrlength){
                    if(isAnagram(srcMap,targetMap)){
                        anagramCounts++;
                    }
                }
            }
            endIndex++;
        }
        System.out.println(anagramCounts);
        return  anagramCounts;
    }


    private  boolean isAnagram(Map<Character,Integer> srcMap, Map<Character,Integer> targetMap){
        return  srcMap.equals(targetMap);
    }

    public  static  void  main(String[] args){
        AnagramsCount anagramsCount = new AnagramsCount();
        anagramsCount.countAnagrams("fororfrdofr","for");
        AnagramsCount anagramsCount2 = new AnagramsCount();
        anagramsCount.countAnagrams("aabaabaa","aaba");
    }
}
