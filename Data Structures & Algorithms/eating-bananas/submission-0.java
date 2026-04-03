class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while(l <= r){
            int mid = l + (r - l) / 2;
            int hours = 0; 
            for(int p : piles){
                hours += Math.ceil((double)p / mid);
            }   

            if(hours <= h){
                res = Math.min(res, mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return res;
    }
}
