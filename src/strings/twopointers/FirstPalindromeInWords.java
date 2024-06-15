package strings.twopointers;

public class FirstPalindromeInWords{

    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }
    private boolean isPalindrome(String word){
        int startIndex = 0;
        int endIndex = word.length()-1;
        char[] wordCharArray= word.toCharArray();
        while(startIndex <= endIndex){
            if(wordCharArray[startIndex]!=wordCharArray[endIndex]){
                return false;
            }
            startIndex++;
            endIndex--;

        }
        return true;

    }


}
