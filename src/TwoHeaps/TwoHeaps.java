package TwoHeaps;

import java.util.PriorityQueue;

public class TwoHeaps {
    PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

    public int longestSubarray(int[] nums, int limit) {
        int endIndex = 0;
        int maxSubArrayLength = 0;
        int startIndex = 0;
        while (endIndex < nums.length) {
            // add the current element to both maxHeap and MinHeap
            minHeap.offer(new int[]{nums[endIndex], endIndex});// O(logN) TC
            maxHeap.offer(new int[]{nums[endIndex], endIndex});// O(logN) TC
            // check if constraint is violated or not
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                // if constraint is violated this means either max or Min Element has to be
                // removed from the current Window
                // We can shift start index to max of these max, min Element indices + 1 to
                // ensure constraint gets satisfied
                startIndex = Math.min(minHeap.peek()[1], maxHeap.peek()[1]) + 1;
                // clean up the current window remove elements from the current window which
                // does not satisfy constraint as per above
                while (maxHeap.peek()[1] < startIndex) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < startIndex) {
                    minHeap.poll();
                }

            }
            // update the result since current window is satisfied with constraint
            int currentWindowLen = endIndex - startIndex + 1;
            maxSubArrayLength = Math.max(maxSubArrayLength, currentWindowLen);
            // increment the endIndex
            endIndex++;
        }
        return maxSubArrayLength;
    }

}
