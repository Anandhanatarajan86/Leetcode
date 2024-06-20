package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LettercasePermutation {
    List<String> letterCasePermList = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        if (s == null || s.isEmpty()) {
            return letterCasePermList;
        }
        dfsHelper(s, 0, new StringBuilder());
        return letterCasePermList;
    }

    // helper method
    private void dfsHelper(String input, int currIndex, StringBuilder currentPerm) {
        // Base Case
        if (currIndex == input.length()) {
            letterCasePermList.add(new String(currentPerm.toString()));
            return;
        }
        char currentChar = input.charAt(currIndex);
        if (Character.isLetter(currentChar)) {
            //upper case
            currentPerm.append(Character.toUpperCase(currentChar));
            dfsHelper(input, 1 + currIndex, currentPerm);
            currentPerm.deleteCharAt(currentPerm.length() - 1);
            //lower case
            currentPerm.append(Character.toLowerCase(currentChar));
            dfsHelper(input, 1 + currIndex, currentPerm);
            currentPerm.deleteCharAt(currentPerm.length() - 1);

        } else if (Character.isDigit(currentChar)) {
            currentPerm.append(Character.toUpperCase(currentChar));
            dfsHelper(input, 1 + currIndex, currentPerm);
            currentPerm.deleteCharAt(currentPerm.length() - 1);
        }
    }
}
