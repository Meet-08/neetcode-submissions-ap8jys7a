class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, l = 0, r = n - 1;

        while(i < r){
            if(nums[i] == 0){
                swap(nums, i, l);
                l++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
            }else{
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}