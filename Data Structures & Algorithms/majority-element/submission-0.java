class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        int i = 0;

        while(i < nums.length){
            if(nums[i] == candidate){
                count++;
            }else if(count == 0){
                candidate = nums[i];
            }else{
                count--;
            }

            i++;
        }
        return candidate;
    }
}