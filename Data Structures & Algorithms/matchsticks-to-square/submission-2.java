class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;

        int target = sum / 4;

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        return backtrack(matchsticks, new int[4], 0, target);
    }

    private boolean backtrack(int[] matchsticks, int[] sides, int i, int sum) {
        if (i == matchsticks.length)
            return true;

        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchsticks[i] <= sum) {
                sides[j] += matchsticks[i];
                if (backtrack(matchsticks, sides, i + 1, sum))
                    return true;
                sides[j] -= matchsticks[i];
            }
        }

        return false;
    }
}