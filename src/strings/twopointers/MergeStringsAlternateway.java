package strings.twopointers;

public class MergeStringsAlternateway {
    int len1 = 0;
    int len2  = 0;
    int wordOneIndex = 0;
    int wordTwoIndex = 0;
    StringBuilder res = new StringBuilder();

    public String mergeAlternately(String word1, String word2) {

        //edge case when one of the word is null /empty
        if(word1 == null || word1.isEmpty())
            return word2;
        if(word2 == null || word2.isEmpty())
            return word1;
        //initializes length
        len1 = word1.length();
        len2 = word2.length();

        while(wordOneIndex < len1 && wordTwoIndex < len2){
            char first = word1.charAt(wordOneIndex++);
            char second = word2.charAt(wordTwoIndex++);
            res.append(first);
            res.append(second);


        }
        //check the individual words for remaining chars

        while(wordOneIndex < len1){
            res.append(word1.charAt(wordOneIndex++));
        }
        //check the remaining chars for word2
        while(wordTwoIndex < len2){
            res.append(word2.charAt(wordTwoIndex++));
        }
        return res.toString().trim();
    }

}
