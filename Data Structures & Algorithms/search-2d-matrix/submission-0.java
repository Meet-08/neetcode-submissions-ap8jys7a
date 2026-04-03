class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int cols = matrix[0].length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][cols]){
                return searchArray(matrix[mid], target);
            }

            if(matrix[mid][0] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return false;
    }

    private boolean searchArray(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) return true;

            if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return false;
    }
}
