package org.jenkinsci.plugins.popular_jobs;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import hudson.model.Job;
import org.apache.commons.collections.MultiMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores the scores somewhere.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
public class PopularDataStore {
    //temporary measure
    private static Map<Job, Multimap<PopularProvider, Score>> data = new HashMap<Job, Multimap<PopularProvider, Score>>();
    
    public static void store(Job job, int score, PopularProvider provider) {
        Multimap<PopularProvider, Score> map = data.get(job);
        if (map == null) {
            map = LinkedHashMultimap.create();
            data.put(job, map);
        }
        map.put(provider, new Score(job, score, provider));
    }

    public static int getScore(Job j) {
        int s = 0;
        Multimap<PopularProvider, Score> map = data.get(j);
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
        private PopularProvider provider;

        public Score(Job job, int score, PopularProvider provider) {
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

        public PopularProvider getProvider() {
            return provider;
        }

        public Date getTimestamp() {
            return timestamp;
        }
    }
}
