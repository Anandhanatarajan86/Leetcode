package arrays.binarysearch;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    Set<Integer> numsOneSet = new HashSet<>();
    Set<Integer> intersection = new HashSet<>();

    public int[] intersection(int[] nums1, int[] nums2) {
        for (int element : nums1) {
            numsOneSet.add(element);
        }
        for (int element : nums2) {
            if (numsOneSet.contains(element)) {
                intersection.add(element);
            }
        }
        int[] res = new int[intersection.size()];
        int resIndex = 0;
        for (int value : intersection) {
            res[resIndex++] = value;
        }
        return res;
    }
}
