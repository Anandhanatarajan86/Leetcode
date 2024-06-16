package strings.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInStringWithThreadSafety {
    List<Integer> anagramIndicesList = new ArrayList<>(); // Instance Variable
    public  synchronized List<Integer> findAnagrams(String s, String p) {
        anagramIndicesList.clear();

        // Edge cases
        if (s.isEmpty() || p.isEmpty()) {
            return anagramIndicesList;
        }

        int requiredSubArrayLength = p.length();
        int endIndex = 0;
        int startIndex = 0;

        // Store pattern in frequency array
        int[] patternFreqArray = buildFrequencyArray(p);

        int[] sourceFreqArray = new int[26];
        while (endIndex < s.length()) {
            char currentChar = s.charAt(endIndex);
            sourceFreqArray[currentChar - 'a']++;

            int currentWindowLength = (endIndex - startIndex) + 1;

            // Check if the window is of the required length
            if (currentWindowLength == requiredSubArrayLength) {
                if (isPermutation(patternFreqArray, sourceFreqArray)) {
                    anagramIndicesList.add(startIndex);
                }
            }

            // Shrink the window if it exceeds the required length
            if (currentWindowLength > requiredSubArrayLength) {
                char startChar = s.charAt(startIndex++);
                sourceFreqArray[startChar - 'a']--;
                if (isPermutation(patternFreqArray, sourceFreqArray)) {
                    anagramIndicesList.add(startIndex);
                }
            }

            endIndex++;
        }

        return anagramIndicesList;
    }

    private int[] buildFrequencyArray(String str) {
        int[] freqArray = new int[26];
        for (char c : str.toCharArray()) {
            freqArray[c - 'a']++;
        }
        return freqArray;
    }

    private boolean isPermutation(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        AllAnagramsInStringWithThreadSafety findAllAnagramsInString = new AllAnagramsInStringWithThreadSafety();
        System.out.println(findAllAnagramsInString.findAnagrams("cbaebabacd", "bca")); // Expected output: [0, 6]
        System.out.println(findAllAnagramsInString.findAnagrams("abab", "ab"));       // Expected output: [0, 1, 2]
        System.out.println(findAllAnagramsInString.findAnagrams("abab", "ab"));       // Expected output: [0, 1, 2]
    }
}
