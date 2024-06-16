package stack;

import java.util.Stack;

public class WarmerTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToWait;
        Stack<Integer> temperatureStack = new Stack<>();
        daysToWait = new int[temperatures.length];
        for (int index = temperatures.length - 1; index >= 0; index--) {
            int currentTemperature = temperatures[index];
            // check if the stack is empty or not
            if (temperatureStack.isEmpty()) {
                daysToWait[index] = 0;// no warmer temperature seen
            }
            // pop all elements from stack as long as stack contains lesser temperature than
            // current
            while (!temperatureStack.isEmpty() && temperatures[temperatureStack.peek()] <= currentTemperature) {
                temperatureStack.pop();
            }
            // seen some warmer temperature
            if (!temperatureStack.isEmpty()) {
                int nextWarmerIndex = temperatureStack.peek();
                daysToWait[index] = nextWarmerIndex - index;
            }

            temperatureStack.push(index);// this could be potential warmer for subsequent element;

        }
        return daysToWait;
    }
}
