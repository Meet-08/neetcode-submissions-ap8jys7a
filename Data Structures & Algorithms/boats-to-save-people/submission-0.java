class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;
        int res = 0;

        while(l <= r){
            int remain = limit - people[r];
            r--;
            res++;

            if(l <= r && remain >= people[l]){
                l++;
            }
        }

        return res;
    }
}