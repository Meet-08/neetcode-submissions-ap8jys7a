class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int n : nums)
            s.add(n);

        for(int i = 1; i <= nums.length; i++){
            if(!s.contains(i)) return i;
        }

        return nums.length;
    }
}