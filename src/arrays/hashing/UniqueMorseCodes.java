package arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodes {
    String[] morseCodes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    Set<String> wordSet = new HashSet<>();
    int    uniqueMorse   = 0;
    public int uniqueMorseRepresentations(String[] words) {
        for(String word : words){
            StringBuilder strBuilder = new StringBuilder();
            char[]  wordCharArray = word.toCharArray();
            for(char temp : wordCharArray){
                strBuilder.append(morseCodes[temp-'a']);
            }
            if(!wordSet.contains(strBuilder.toString())){
                uniqueMorse++;
                wordSet.add(strBuilder.toString());
                strBuilder.setLength(0);
            }
        }
        return     uniqueMorse;
    }
}
