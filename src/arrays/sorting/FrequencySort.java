package arrays.sorting;

import java.util.*;

class FrequencySort {
    public String frequencySort(String s) {
        // Create a frequency map to count the occurrences of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a list of characters
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }

        // Sort the list based on frequency
        characters.sort((a, b) -> {
            int frequencyCompare = frequencyMap.get(b) - frequencyMap.get(a);
            if (frequencyCompare == 0) {
                return a - b; // Maintain lexicographical order if frequencies are the same
            }
            return frequencyCompare;
        });

        // Build the result string
        StringBuilder result = new StringBuilder(characters.size());
        for (char c : characters) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FrequencySort solution = new FrequencySort();
        System.out.println(solution.frequencySort("tree")); // Expected: "eert" or "eetr"
        System.out.println(solution.frequencySort("cccaaa")); // Expected: "cccaaa" or "aaaccc"
        System.out.println(solution.frequencySort("Aabb")); // Expected: "bbAa" or "bbaA"
    }
}
