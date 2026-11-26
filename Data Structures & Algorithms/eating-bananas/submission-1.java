class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int p : piles) {
            max = Math.max(max, p);
        }

        int i = 1;
        int j = max;
        int res = 1;

        while (i <= j) {
            int m = i + (j - i) / 2;

            if (canEat(piles, h, m)) {
                res = m;
                j = m - 1;
            } else {
                i = m + 1;
            }
        }

        return res;
    }

    public boolean canEat(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; 
        }

        return hours <= h;
    }
}
