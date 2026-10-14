class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (j >= 0 && nums[j] == val) j--;

        while (i <= j) {
            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                while (j >= 0 && nums[j] == val) j--;
            }
            i++;
        }

        return i;
    }
}