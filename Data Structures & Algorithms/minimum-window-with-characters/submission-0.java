class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int[] res = { -1, -1 };
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) &&
              window.get(c).equals(countT.get(c))){

                have++;
            }

            while(have == need){
                if((r - l + 1) < resLen){
                    res[0] = l;
                    res[1] = r;

                    resLen = r - l + 1;
                }

                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);

                if (countT.containsKey(left) &&
                    window.get(left) < countT.get(left)){

                    have--;
                }
                l++;
            }
        }

        if(resLen == Integer.MAX_VALUE) return "";

        return s.substring(res[0], res[1] + 1);
    }
}
