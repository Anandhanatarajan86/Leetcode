package stack;

import java.util.Stack;

public class RemoveAdjacentAndEqualElements {
    public String removeDuplicates(String s) {
        Stack<Character> charStack = new Stack<>();
        for (char temp : s.toCharArray()) {
            if (!charStack.isEmpty() && charStack.peek() == temp) {
                charStack.pop();  // pop the top element if it's the same as the current character
            } else {
                charStack.push(temp);  // push the current character onto the stack
            }
        }

        StringBuilder resBuilder = new StringBuilder();
        while (!charStack.isEmpty()) {
            resBuilder.append(charStack.pop());  // append characters from stack to result
        }

        return resBuilder.reverse().toString();  // reverse the result to get the final string
    }
}
