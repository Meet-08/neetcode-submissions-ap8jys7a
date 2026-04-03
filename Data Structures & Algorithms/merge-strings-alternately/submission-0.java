class Solution {
    public String mergeAlternately(String word1, String word2) {
        var res = new StringBuilder();

        int s1 = 0;
        int s2 = 0;
        int m = word1.length();
        int n = word2.length();

        while(s1 < m && s2 < n){
            res.append(word1.charAt(s1));
            res.append(word2.charAt(s2));

            s1++;
            s2++;
        }

        while(s1 < m){
            res.append(word1.charAt(s1));
            s1++;
        }

        while(s2 < n){
            res.append(word2.charAt(s2));
            s2++;
        }

        return res.toString();
    }
}