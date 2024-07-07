package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKNodesInQueue {
    Stack<Integer> firstKElements = new Stack<>();
    public Queue<Integer> solve(Queue<Integer> q, int k) {
        //Write your code here
        Queue<Integer> reversed = new LinkedList<>();
        int count = 0;
        while(count < k){
            firstKElements.push(q.remove());
            count++;
        }
        while(!firstKElements.isEmpty()){
            reversed.add(firstKElements.pop());
        }
        while (!q.isEmpty()){
            reversed.add(q.poll());
        }
        return reversed;
    }
}
