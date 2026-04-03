class Solution {
    public boolean isPalindrome(String s) {
       int n = s.length();
       int l = 0;
       int r = n - 1;

       while(l <= r){
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));
            if(!Character.isLetterOrDigit(left))
                l++;
            else if(!Character.isLetterOrDigit(right))
                r--;
            else{
                if(left == right){
                    l++;
                    r--;
                }else{
                    return false;
                }
            }
       }

       return true;
    }

}
