class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        
        for(int w : weights){
            l = Math.max(l, w);
            r += w;
        }

        int res = r;

        while(l <= r){
            int cap = (l + r) / 2;

            if(canShip(weights, cap, days)){
                res = Math.min(res, cap);
                r = cap - 1;
            }else{
                l = cap + 1;
            }
        }

        return res;
    }

    private boolean canShip(int[] w, int cap, int days){
        int ships = 1;
        int currCap = cap;
        for(int n : w){
            if(currCap - n < 0){
                ships++;
                currCap = cap;
            }
            currCap -= n;
        }
        return ships <= days;
    }
}