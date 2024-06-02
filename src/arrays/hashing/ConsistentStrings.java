package arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class ConsistentStrings {
    Set<Character> allowedSet = new HashSet<>();
    Set<Character>  wordSet   = new HashSet<>();
    int             consistenStrings = 0;
    public int countConsistentStrings(String allowed, String[] words) {
        //construct allowed set
        char[] allowedChars = allowed.toCharArray();
        for(char temp: allowedChars){
            allowedSet.add(temp);
        }
        for(String word : words){
            char[] wordCharArray = word.toCharArray();
            wordSet.clear();
            if(isWordConsistent(wordCharArray)){
                consistenStrings++;
            }
        }
        System.out.println(consistenStrings);
        return     consistenStrings;
    }


    private boolean isWordConsistent(char[] wordCharArray){
        for(char temp : wordCharArray){
            if(!allowedSet.contains(temp)){
                return false;
            }
        }
        return true;
    }
    public  static  void  main(String[] args){
       String[] words =
               {"a","b","c","ab","ac","bc","abc"};
        ConsistentStrings consistentStrings = new ConsistentStrings();
        consistentStrings.countConsistentStrings("abc",words);
    }
}
