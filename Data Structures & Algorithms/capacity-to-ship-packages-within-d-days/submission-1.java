class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;

        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        int res = 0;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (canShip(weights, days, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return res;
    }

    public boolean canShip(int[] weights, int days, int cap) {
        int require = 1;
        int curW = 0;
        for (int w : weights) {
            if (curW + w > cap) {
                require++;
                curW = 0;
            }

            curW += w;
        }

        return require <= days;
    }
}