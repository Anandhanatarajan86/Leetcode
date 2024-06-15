package strings.twopointers;

public class DiPermutation {
    int[]  res;
    public int[] diStringMatch(String s) {
        int size = s.length();
        res = new int[size+1];
        int left = 0;
        int right = size;
        for(int resIndex = 0; resIndex < size;resIndex++){
            res[resIndex] = (s.charAt(resIndex)=='I')?left++:right--;

        }
        res[size] = left;
        return res;
    }
}
