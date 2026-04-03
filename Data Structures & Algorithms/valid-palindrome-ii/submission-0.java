class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                var skipL = new StringBuilder(s.substring(l + 1, r + 1));
                var skipR = new StringBuilder(s.substring(l, r));

                return (
                    skipL.toString().equals(skipL.reverse().toString()) ||  
                    skipR.toString().equals(skipR.reverse().toString())
                );
            }
            l++;
            r--;
        }

        return true;
    }
}