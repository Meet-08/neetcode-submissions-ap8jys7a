class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for(int r = 0; r < s.length(); r++){
            char curr = s.charAt(r);
            while(charSet.contains(curr)){
                charSet.remove(s.charAt(l++));
            }

            charSet.add(curr);
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
