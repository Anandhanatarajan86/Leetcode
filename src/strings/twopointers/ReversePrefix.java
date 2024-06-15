package strings.twopointers;

public class ReversePrefix {

    public String reversePrefix(String word, char ch) {
        StringBuilder resBuilder = new StringBuilder();
        //check if char ch exists in word
        if(word.indexOf(ch)==-1){
            return word;   //do nothing
        }
        int endIndex = word.indexOf(ch);
        String prefix = word.substring(0,endIndex+1);
        String suffix = word.substring(endIndex+1,word.length());
        return findReverse(prefix)+suffix;
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
