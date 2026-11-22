class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){
            int curH = (i == n) ? 0 : heights[i];

            while(!s.isEmpty() && curH < heights[s.peek()]){
                int top = s.pop();
                int left = s.isEmpty() ? -1 : s.peek();
                int width = i - left - 1; 

                maxArea = Math.max(maxArea, heights[top] * width);
            }

            s.push(i);
        }

        return maxArea;
    }
}
