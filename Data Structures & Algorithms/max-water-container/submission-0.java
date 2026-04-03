class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int res = 0;

        while(l < r){
            int width = r -  l;
            int height = Math.min(heights[l], heights[r]);

            res = Math.max(res, width * height);

            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }
        }

        return res;
    }
}
