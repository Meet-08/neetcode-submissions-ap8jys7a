class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int total = 0;
        int res = nums.length + 1;

        for(int r = 0; r < nums.length; r++){
            total += nums[r];

            while(total >= target){
                total -= nums[l];
                res = Math.min(res, r - l + 1);
                l++;
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }
}