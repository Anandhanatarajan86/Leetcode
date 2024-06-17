package strings.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxVowelsInSubstringOfSizeK {
    Set<Character> vowelSet = new HashSet<>();

    public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int endIndex = 0;
        int startIndex = 0;
        Map<Character, Integer> vowelsMap = new HashMap<>();
        int vowelsInCurrentSubString = 0;
        //add vowels to vowelSet
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        while (endIndex < s.length()) {
            char current = s.charAt(endIndex);
            if (vowelSet.contains(current)) {
                vowelsInCurrentSubString++;
            }
            //check the current substring length
            int currentSubStringLength = (endIndex - startIndex) + 1;
            if (currentSubStringLength == k) {
                maxVowels = Math.max(maxVowels, vowelsInCurrentSubString);

            }
            if (currentSubStringLength > k) {
                //shrink the window from start and check the current sub window has max vowels
                char prevChar = s.charAt(startIndex++);
                if (vowelSet.contains(prevChar)) {
                    vowelsInCurrentSubString--;
                }
                maxVowels = Math.max(maxVowels, vowelsInCurrentSubString);
            }
            endIndex++;
        }
        System.out.println(maxVowels);
        return maxVowels;
    }

    public static void main(String[] args){
        MaxVowelsInSubstringOfSizeK maxVowelsInSubstringOfSizeK = new MaxVowelsInSubstringOfSizeK();
        maxVowelsInSubstringOfSizeK.maxVowels("aeiou",2);
    }
}
