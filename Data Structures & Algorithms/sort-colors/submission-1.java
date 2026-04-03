class Solution {
    public void sortColors(int[] nums) {
        var bucket = new int[3];

        for(int n : nums) bucket[n]++;

        int i = 0, idx = 0;

        while(i < bucket.length){
            if(bucket[i] == 0) {
                i++;
                continue;
            }
            nums[idx++] = i;
            bucket[i]--;
        }
    }
}