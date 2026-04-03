class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        var prefix = strs[0];
       
        for(int i = 1; i < strs.length; i++){
            var cur = strs[i];
            while(!cur.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
            }


            if(prefix.equals("")) return "";
        }

        return prefix;
    }
}