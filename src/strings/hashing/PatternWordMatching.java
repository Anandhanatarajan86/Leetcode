package strings.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternWordMatching {
    List<String> patternMatchedWords = new ArrayList<>();

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        for (String word : words) {
            if (isPatternMatching(word, pattern)) {
                patternMatchedWords.add(word);
            }
        }
        return patternMatchedWords;
    }

    // helper method to find word and pattern are matched
    private boolean isPatternMatching(String word, String pattern) {
        char[] patternCharArray = pattern.toCharArray();
        char[] wordCharArray    = word.toCharArray();
        if (patternCharArray.length != wordCharArray.length) {
            return false;
        }
        Map<Character, Character> patternToWordMap = new HashMap<>();
        Map<Character, Character> WordToPatternMap = new HashMap<>();
        for (int charIndex = 0; charIndex < patternCharArray.length; charIndex++) {
            char patternChar = patternCharArray[charIndex];
            char wordChar = wordCharArray[charIndex];
            if(patternToWordMap.containsKey(patternChar) && patternToWordMap.get(patternChar)!=wordChar){
                return false;
            }
            if(WordToPatternMap.containsKey(wordChar) && WordToPatternMap.get(wordChar)!=patternChar){
                return false;
            }
            //fill both maps in birectional manner
            patternToWordMap.put(patternChar,wordChar);
            WordToPatternMap.put(wordChar,patternChar);

        }
        return true;
    }

}
