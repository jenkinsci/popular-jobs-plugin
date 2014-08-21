package org.jenkinsci.plugins.popular_jobs;

import hudson.model.Job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 23052130
 * Date: 2014-08-21
 * Time: 11:46
 * To change this template use File | Settings | File Templates.
 */
public class PopularDataStore {
    //temporary measure
    private static Map<Job, Map<PopularExtension, Score>> data = new HashMap<Job, Map<PopularExtension, Score>>();
    
    public static void store(Job job, int score, PopularExtension provider) {
        Map<PopularExtension, Score> map = data.get(job);
        if (map == null) {
            map = new HashMap<PopularExtension, Score>();
            data.put(job, map);
        }
        map.put(provider, new Score(job, score, provider));
    }

    public static int getScore(Job j) {
        int s = 0;
        Map<PopularExtension, Score> map = data.get(j);
        if (map != null) {
            for(Score d: map.values()) {
                s += d.getScore();
            }
        }
        return s;
    }
    
    public static class Score {
        private final Date timestamp;
        private Job job;
        private int score; 
        private PopularExtension provider;

        public Score(Job job, int score, PopularExtension provider) {
            this.job = job;
            this.score = score;
            this.provider = provider;
            this.timestamp = new Date();
        }

        public Job getJob() {
            return job;
        }

        public int getScore() {
            return score;
        }

        public PopularExtension getProvider() {
            return provider;
        }

        public Date getTimestamp() {
            return timestamp;
        }
    }
}
