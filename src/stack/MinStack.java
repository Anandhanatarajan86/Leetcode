package stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> normalStack = null;
    Stack<Integer> minStack = null;;

    public MinStack() {
        normalStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // this value should always should be pushed to normalStack
        normalStack.push(val);
        // Check whether this val should be pushed to min Stack based upon condition
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val <= minStack.peek()) {// this could be potential minValue so far so add to min Stack
            minStack.push(val);
        }
    }

    public void pop() {
        // remove from normal Stack always
        int popValue = normalStack.pop();
        // Depends on condition remove from minStack
        if (!minStack.isEmpty() && minStack.peek() == popValue) { // we do not have pop if the popped value is not equal
            // to minstack peek value
            minStack.pop();
        }
    }

    public int top() {
        return normalStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
