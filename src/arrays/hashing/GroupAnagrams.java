package arrays.hashing;

import java.util.*;

public class GroupAnagrams {
    Map<String, List<String>> anagramMap = new HashMap<>();
    List<List<String>> anagramResList = new ArrayList<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        //Write your code here
        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            List<String> existingMatchingAnagramList = anagramMap.get(key);
            existingMatchingAnagramList.add(word);
            anagramMap.put(key, existingMatchingAnagramList);

        }
        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            List<String> anagramList = entry.getValue();
            Collections.sort(anagramList);
            anagramResList.add(anagramList);

        }
        // Sort the list of anagram groups using a lambda function
        anagramResList.sort((o1, o2) -> {
            String s1 = String.join("", o1);
            String s2 = String.join("", o2);
            return s1.compareTo(s2);
        });
       // System.out.println(anagramResList);
        return anagramResList;

    }
    public  static  void  main(String[] args){
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams.groupAnagrams(words);
    }
}