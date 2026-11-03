class Solution {
    public int maxArea(int[] h) {
        int max = 0;

        int i = 0;
        int j = h.length - 1;

        while (i < j) {
            int height = Math.min(h[i], h[j]);
            int width = j - i;

            max = Math.max(max, height * width);

            if (h[i] < h[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
