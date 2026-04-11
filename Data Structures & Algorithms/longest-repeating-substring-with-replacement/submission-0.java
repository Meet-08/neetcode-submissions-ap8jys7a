class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;
        int l = 0;


        for(int r = 0; r < s.length(); r++){
            char key = s.charAt(r);
            count.put(key, count.getOrDefault(key, 0) + 1);

            while((r - l + 1) - Collections.max(count.values()) > k){
                char keyL = s.charAt(l);
                count.put(keyL, count.getOrDefault(key) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
