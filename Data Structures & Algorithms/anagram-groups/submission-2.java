class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            m.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        for (String l : m.keySet()) {
            res.add(m.get(l));
        }

        return res;
    }
}