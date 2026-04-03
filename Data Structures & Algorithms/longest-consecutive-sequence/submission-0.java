class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int num : nums)
            s.add(num);

        int longest = 0;
        for(int num : s){
            int next = num + 1;
            int localMax = 1;

            while(s.contains(next)){
                localMax++;
                next++;
            }

            longest = Math.max(longest, localMax);
        }

        return longest;
    }
}
