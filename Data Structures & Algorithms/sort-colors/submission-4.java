class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int k = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, k);
                i++;
                k++;
            } else {
                swap(nums, i, j);
                j--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}