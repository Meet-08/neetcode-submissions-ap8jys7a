class Solution {
    public int trap(int[] h) {
        int maxL = h[0];
        int maxR = h[h.length - 1];
        int res = 0;

        int i = 0;
        int j = h.length - 1;

        while (i < j) {
            if (maxL < maxR) {
                i++;
                maxL = Math.max(maxL, h[i]);
                res += maxL - h[i];
            } else {
                j--;
                maxR = Math.max(maxR, h[j]);
                res += maxR - h[j];
            }
        }

        return res;
    }
}
