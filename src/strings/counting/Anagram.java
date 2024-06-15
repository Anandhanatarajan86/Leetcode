package strings.counting;

class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] countArray = new int[26];

        for (char src : s.toCharArray()) {
            countArray[src - 'a']++;
        }

        for (char target : t.toCharArray()) {
            countArray[target - 'a']--;
        }

        for (int charIndex = 0; charIndex < 26; charIndex++) {
            if (countArray[charIndex] != 0) {
                return false;
            }
        }

        return true;
    }
}
