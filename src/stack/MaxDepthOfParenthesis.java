package stack;

import java.util.Stack;

public class MaxDepthOfParenthesis {
    Stack<Character> stack = new Stack<>();
    int maxDepth = 0;

    public int maxDepth(String s) {
        char[] charArray = s.toCharArray();
        for (char temp : charArray) {
            if (temp == '(') {
                stack.push(temp);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (!stack.isEmpty() && temp == ')' && stack.peek() == '(') {
                stack.pop();
            }

        }
        return maxDepth;
    }
}
