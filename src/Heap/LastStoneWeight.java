package Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    PriorityQueue<Integer> stonePqueue = new PriorityQueue<>((a, b) -> b - a);

    public int lastStoneWeight(int[] stones) {
        //if there is only one stone left
        if (stones.length == 1) return stones[0];

        for (int stoneWeight : stones)
            stonePqueue.offer(stoneWeight);
        while (stonePqueue != null && stonePqueue.size() > 1) {
            int firstLargeStone = stonePqueue.poll();
            int secLargeStone = stonePqueue.poll();
            // System.out.println("pritning firstLargeStone**"+firstLargeStone);
            //System.out.println("pritning secLargeStone**"+secLargeStone);
            if (firstLargeStone != secLargeStone) {
                int remainingWeight = Math.abs(secLargeStone - firstLargeStone);
                stonePqueue.offer(remainingWeight);
            }


        }
        return stonePqueue != null && stonePqueue.size() > 0 ? stonePqueue.peek() : 0;

    }
}
