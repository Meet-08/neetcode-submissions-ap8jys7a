class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] isUsed = new boolean[n];

        for(int i = 0; i < n; i++){
            if (isUsed[i]) continue;

            List<String> grps = new ArrayList<>();
            grps.add(strs[i]);

            for(int j = i + 1; j < n; j++){
                if(!isUsed[j] && isAnagram(strs[i], strs[j])){
                    isUsed[j] = true;
                    grps.add(strs[j]);
                }
            }

            ans.add(grps);
        }

        return ans;
    }

    private boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; 
            count[t.charAt(i) - 'a']--; 
        }

        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }
}
