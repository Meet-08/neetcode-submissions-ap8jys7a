class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = h[0];
        maxRight[n - 1] = h[n - 1];

        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], h[i]);
        }

        for(int i = n - 2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i + 1], h[i]);
        }

        int res = 0;

        for(int i = 0; i < n; i++){
            int min = Math.min(maxLeft[i], maxRight[i]);
            res += Math.max(0, min - h[i]);
        }

        return res;
    }
}
