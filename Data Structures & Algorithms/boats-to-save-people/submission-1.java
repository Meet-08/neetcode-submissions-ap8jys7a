class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int res = 0;

        while (i <= j) {
            int remain = limit - people[j];
            j--;
            res++;

            if (i <= j && remain >= people[i]) {
                i++;
            }
        }

        return res;
    }
}