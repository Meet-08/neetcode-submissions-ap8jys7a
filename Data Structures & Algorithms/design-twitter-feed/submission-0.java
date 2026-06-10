class Twitter {
    int count;
    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        this.count = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {count, tweetId});
        count++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (Integer followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                int index = tweetMap.get(followeeId).size() - 1;
                int[] entry = tweetMap.get(followeeId).getLast(); // [ c, tId ]
                maxHeap.offer(new int[] {entry[0], entry[1], followeeId, index - 1});
            }
        }

        while (maxHeap.size() > 0 && res.size() < 10) {
            int[] tweet = maxHeap.poll(); // [ c,  tId, fId, i]
            res.add(tweet[1]);

            if (tweet[3] >= 0) {
                int[] entry = tweetMap.get(tweet[2]).get(tweet[3]);
                maxHeap.offer(new int[] {entry[0], entry[1], tweet[2], tweet[3] - 1});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
