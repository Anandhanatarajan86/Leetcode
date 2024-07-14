package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGraterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        // Build a map of the next greater elements for nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            map.put(current, stack.isEmpty() ? -1 : stack.peek());
            stack.push(current);
        }

        // Build the result for nums1 based on the map
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}
