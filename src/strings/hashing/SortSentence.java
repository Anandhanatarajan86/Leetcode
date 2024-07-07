package strings.hashing;

import java.util.HashMap;
import java.util.Map;

public class SortSentence {
    Map<Integer,String> indexWordsMap = new HashMap<>();
    StringBuilder resBuilder          = new StringBuilder();
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        //get the index and word Mapping
        for(String word: words){
            int index = word.charAt(word.length()-1)-'0';
            // System.out.println("printing index"+index);
            String value = word.substring(0,word.length()-1);
            indexWordsMap.put(index,value);
        }

        for(int index = 1; index <= words.length; index++){
            String value = indexWordsMap.get(index);
            resBuilder.append(value);
            resBuilder.append(" ");
        }
        return resBuilder.toString().trim();
    }
}
