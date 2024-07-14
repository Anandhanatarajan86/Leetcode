package stack;

import java.util.Stack;

public class BaseBallGame {
    Stack<Integer> scores = new Stack<>();

    public int calPoints(String[] operations) {
        for (String operation : operations) {
            if (operation.equals("C") && !scores.isEmpty()) {
                scores.pop();// Invalidate previous score
            }

            else if (operation.equals("D") && !scores.isEmpty()) {
                int doubleScore = 2 * scores.peek();
                scores.push(doubleScore);
            } else if (operation.equals("+")) {
                int topValue = (!scores.isEmpty() ? scores.pop() : 0);
                int newTopValue = (!scores.isEmpty() ? scores.peek() + topValue : 0);
                // int sumScore = firstValue + secondValue;
                scores.push(topValue);
                scores.push(newTopValue);
            } else {
                scores.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while (!scores.isEmpty()) {
            sum += scores.pop();
        }
        return sum;
    }
}
