package strings.counting;

import java.util.List;

public class MultiThreadedExampleSynchronized {
    public static void main(String[] args) {
        AllAnagramsInStringWithThreadSafety finder = new AllAnagramsInStringWithThreadSafety();

        Runnable task1 = () -> {
            List<Integer> result1 = finder.findAnagrams("cbaebabacd", "bca");
            System.out.println("Task 1 Result: " + result1);
        };

        Runnable task2 = () -> {
            List<Integer> result2 = finder.findAnagrams("abab", "ab");
            System.out.println("Task 2 Result: " + result2);
        };
        //Actual Result
        //        Task 1 Result: [0, 0, 6, 1, 2]
        //        Task 2 Result: [0, 0, 6, 1, 2]

        //Expected Result
        // Task 1 Result [0,6][0,1,2]
        // Task 2 Result [0,6] [0,1,2]
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
