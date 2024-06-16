package strings.counting;

import java.util.*;

public class AllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndicesList = new ArrayList<>();
        //Edge cases
        if (s.isEmpty() || p.isEmpty()) {
            return anagramIndicesList;
        }
        int requiredSubArrayLength = p.length();
        int endIndex = 0;
        int startIndex = 0;
        //Store pattern in HashMap
        int[] patternArray = new int[26];
        for (int pIndex = 0; pIndex < p.length(); pIndex++) {
            char pchar = p.charAt(pIndex);
            patternArray[pchar - 'a']++;
        }
        int[] srcCharArray = new int[26];
        while (endIndex < s.length()) {
            char schar = s.charAt(endIndex);
            srcCharArray[schar - 'a']++;
            int currentSubArrayLength = (endIndex - startIndex) + 1;
            //check the subarray is of required desired length
            if (currentSubArrayLength == requiredSubArrayLength) {
                if (ispermutation(patternArray, srcCharArray)) {
                    anagramIndicesList.add(startIndex);
                }

            }
            if (currentSubArrayLength > requiredSubArrayLength) {
                //shrink the window from the start
                char previousStartChar = s.charAt(startIndex++);
                srcCharArray[previousStartChar - 'a']--;
                if (ispermutation(patternArray, srcCharArray)) {
                    anagramIndicesList.add(startIndex);
                }
            }
            endIndex++;
        }
        return anagramIndicesList;
    }

    private boolean ispermutation(int[] patternArray, int[] srcArray) {
        return Arrays.equals(patternArray, srcArray);
    }

    public static void main(String[] args) {
        AllAnagramsInString finaAllAnagramsInString = new AllAnagramsInString();
        System.out.println(finaAllAnagramsInString.findAnagrams("cbaebabacd", "bca"));
        System.out.println(finaAllAnagramsInString.findAnagrams("abab", "ab"));
        System.out.println(finaAllAnagramsInString.findAnagrams("abab", "ab"));
    }

}
