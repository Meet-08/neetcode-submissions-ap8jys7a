class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // 2. Use a single frequency array (for lowercase English letters)
        // This is much faster than using two HashMaps
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // Increment for string s
            count[t.charAt(i) - 'a']--; // Decrement for string t
        }

        // 3. If it's an anagram, every index should be back to 0
        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }
}