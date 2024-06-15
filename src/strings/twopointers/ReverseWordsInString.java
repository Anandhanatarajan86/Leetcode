package strings.twopointers;

public class ReverseWordsInString {
    StringBuilder resBuilder = new StringBuilder();
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for(String word : words){
            resBuilder.append(findReverse(word));
            resBuilder.append(" ");
        }
        return resBuilder.toString().trim();
    }

    private String findReverse(String word){
        char[] letterArray = word.toCharArray();
        StringBuilder reverseBuilder = new StringBuilder();
        int startIndex = 0;
        int endIndex   = letterArray.length-1;
        while(startIndex <= endIndex){
            char temp = letterArray[startIndex];
            letterArray[startIndex] = letterArray[endIndex];
            letterArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        return new String(letterArray);
    }
}
