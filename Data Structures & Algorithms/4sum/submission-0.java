class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            for(int j = i + 1; j < n; j++){
                if(j > 0 && nums[j] == nums[j - 1])
                    continue;


                int l = j + 1;
                int r = n - 1;

                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum == target){
                        res.add(List.of(
                            nums[i], nums[j], nums[l], nums[r]
                        ));

                        l++;

                        while(l < r && nums[l] == nums[l - 1])
                            l++;
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }   

        return res;     
    }
}