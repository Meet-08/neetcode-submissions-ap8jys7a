class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            m1.put(sChar, m1.getOrDefault(sChar, 0));
            m2.put(tChar, m2.getOrDefault(tChar, 0));
        }

        for(var c: m1.keySet())
            if(m1.get(c) != m2.get(c))
                return false;

        return true;
    }
}
