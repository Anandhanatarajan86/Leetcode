package Arrays.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInventories {
    List<String> mergedList = new ArrayList<>();

    public List<String> solve(List<String> inventory1, List<String> inventory2) {
        Collections.sort(inventory1);//sort them if they are not already sorted
        Collections.sort(inventory2);
        int invOneRange = inventory1.size();
        int invTwoRange = inventory2.size();
        int invOneIndex = 0;
        int invTwoIndex = 0;
        int resIndex = 0;
        while (invOneIndex < invOneRange && invTwoIndex < invTwoRange) {
            //check the words from two list
            if (inventory1.get(invOneIndex).compareTo(inventory2.get(invTwoIndex)) < 0) {
                mergedList.add(inventory1.get(invOneIndex++));
            } else {
                mergedList.add(inventory2.get(invTwoIndex++));
            }

        }

        while (invOneIndex < invOneRange) {
            mergedList.add(inventory1.get(invOneIndex++));
        }

        while (invTwoIndex < invTwoRange) {
            mergedList.add(inventory2.get(invTwoIndex++));
        }
        return mergedList;
    }
}
