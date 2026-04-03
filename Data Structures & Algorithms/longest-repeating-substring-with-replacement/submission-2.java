class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;
        int maxFreq = 0;

        for(int r = 0; r < s.length(); r++){
            char key = s.charAt(r);
            count.put(key, count.getOrDefault(key, 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(key));

            while((r - l + 1 - maxFreq) > k){
                Character keyL = s.charAt(l);
                count.put(keyL, count.get(keyL) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
