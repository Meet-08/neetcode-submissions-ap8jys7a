class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if(freq.size() <= 2) continue;

            Map<Integer, Integer> newCount = new HashMap<>();

            for(var entry : freq.entrySet()){
                int val = entry.getValue();
                int key = entry.getKey();

                if(val > 1)
                    newCount.put(key, val - 1);
            }

            freq = newCount;
        }

        List<Integer> res = new ArrayList<>();
        for (int key : freq.keySet()) {
            int frequency = 0;
            for (int num : nums) {
                if (num == key) frequency++;
            }
            if (frequency > nums.length / 3) {
                res.add(key);
            }
        }

        return res;
    }
}