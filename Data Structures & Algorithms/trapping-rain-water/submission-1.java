class Solution {
    public int trap(int[] h) {
        
        if (h == null || h.length == 0) {
            return 0;
        }

        int l = 0;
        int r = h.length - 1;

        int maxLeft = h[l];
        int maxRight = h[r];

        int res = 0;

        while(l < r){
            if(maxLeft < maxRight){
                l++;
                maxLeft = Math.max(maxLeft, h[l]);
                res += maxLeft - h[l];
            }else{
                r--;
                maxRight = Math.max(maxRight, h[r]);
                res += maxRight - h[r];
            }
        }

        return res;
    }
}
