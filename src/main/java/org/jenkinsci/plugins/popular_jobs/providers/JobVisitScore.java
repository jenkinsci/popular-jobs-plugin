package org.jenkinsci.plugins.popular_jobs.providers;

import hudson.Extension;
import hudson.model.Job;
import org.jenkinsci.plugins.popular_jobs.Messages;
import org.jenkinsci.plugins.popular_jobs.PopularExtension;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Scores based on a plain page visit.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
@Extension
public class JobVisitScore extends PopularExtension {
    @Override
    public int getScore(Job job, StaplerRequest request) {
        return 1;
    }

    @Override
    public String getDisplayName() {
        return Messages.JobVisitScore_DisplayName();
    }
}
