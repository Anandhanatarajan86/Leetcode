package strings.counting;

public class DifferenceCharacter {
    int[] charCountArray = new int[26];

    public char findTheDifference(String s, String t) {
        if(s.isEmpty()){
            return t.charAt(0);
        }
        char[] srcCharArray = s.toCharArray();
        for(char temp: srcCharArray){
            charCountArray[temp-'a']++;
        }

        char[] targetCharArray = t.toCharArray();
        for(char temp: targetCharArray){
            charCountArray[temp-'a']--;
        }
        for(int index = 0; index < 26; index++){
            if(charCountArray[index]==1 || charCountArray[index]==-1){
                return  (char)('a' + index);
            }
        }
        return ' ';
    }
}
