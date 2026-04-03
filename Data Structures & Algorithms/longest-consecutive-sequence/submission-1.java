class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> store = new HashSet<>();

        for(int num : nums) store.add(num);

        int res = 0;

        for(int num : store){
            if(!store.contains(num - 1)){
                int curr = num + 1;
                int streak = 1;

                while(store.contains(curr)){
                    curr++;
                    streak++;
                }

                res = Math.max(res, streak);
            }    
        }

        return res;
    }
}
