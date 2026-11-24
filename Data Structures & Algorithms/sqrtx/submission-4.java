class Solution {
    public int mySqrt(int x) {
        int res = 0;

        int i = 0;
        int j = x;

        while (i <= j) {
            int m = i + (j - i) / 2;
            long sq = (long)m * m;
            if (sq == x)
                return m;

            if (sq < x) {
                res = m;
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return res;
    }
}