package com.fanchen.clearmind.leetcode.map.medium;

import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
 * Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user herself.
 * Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {

    public static int timeStamp = 0;
    public Map<Integer, User> map;

    public class Tweet {
        public int id;
        public Tweet next;
        public int time;

        public Tweet(int id) {
            this.id = id;
            this.next = null;
            this.time = timeStamp++;
        }
    }

    public class User {
        public int id;
        public Tweet curTweet;
        public Set<Integer> following;

        public User(int id) {
            this.id = id;
            this.curTweet = null;
            following = new HashSet<>();
            follow(id);
        }

        public void follow(int id) {
            this.following.add(id);
        }

        public void unfollow(int id) {
            this.following.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = curTweet;
            curTweet = t;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap<Integer, User>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            User u = new User(userId);
            map.put(userId, u);
        }
        map.get(userId).post(tweetId);

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        if (!map.containsKey(userId)) return list;
        Set<Integer> followingUsers = map.get(userId).following;
        PriorityQueue<Tweet> q = new PriorityQueue<>(followingUsers.size(), (a, b) -> b.time - a.time);
        for (int user : followingUsers) {
            Tweet eachTweet = map.get(user).curTweet;
            if (eachTweet != null) q.add(eachTweet);
        }
        int counter = 0;
        while (!q.isEmpty() && counter < 10) {
            Tweet t = q.poll();
            list.add(t.id);
            counter++;
            if (t.next != null) q.add(t.next);
        }
        return list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            User u = new User(followerId);
            map.put(followerId,u);
        }
        if(!map.containsKey(followeeId)){
            User u = new User(followeeId);
            map.put(followeeId,u);
        }
        map.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)|| followeeId == followerId) return;
        map.get(followerId).unfollow(followeeId);
    }
}
