package strings.slidingwindow;
import java.util.HashMap;
import java.util.Map;
public class SubstringsOfSizThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int goodSubStrings = 0;
        int endIndex = 0;
        int startIndex = 0;

        while (endIndex < s.length()) {
            // Add current character to frequency map
            char current = s.charAt(endIndex);
            charFrequencyMap.put(current, charFrequencyMap.getOrDefault(current, 0) + 1);

            // Maintain the window size of exactly 3 characters
            int length = endIndex - startIndex + 1;

            if (length == 3 ) {
                // Check if the current window is a good substring
                if(isSatisfying(charFrequencyMap)){
                    goodSubStrings++;
                }

            }

            if (length > 3) {
                char startChar = s.charAt(startIndex);
                charFrequencyMap.put(startChar, charFrequencyMap.get(startChar) - 1);
                if (charFrequencyMap.get(startChar) == 0) {
                    charFrequencyMap.remove(startChar);
                }
                startIndex++;
                // Check again if the current window is a good substring after shrinking
                if (endIndex - startIndex + 1 == 3 && isSatisfying(charFrequencyMap)) {
                    goodSubStrings++;
                }
            }


            endIndex++;
        }
        return goodSubStrings;
    }

    private boolean isSatisfying(Map<Character, Integer> charFrequencyMap) {
        // A good substring must have exactly 3 unique characters
        return charFrequencyMap.size() == 3;
    }

    public static void main(String[] args) {
        SubstringsOfSizThreeWithDistinctCharacters solution = new SubstringsOfSizThreeWithDistinctCharacters();
        System.out.println(solution.countGoodSubstrings("aababcabc")); // Expected output: 4
    }
}
