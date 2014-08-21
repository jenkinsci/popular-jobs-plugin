package org.jenkinsci.plugins.popular_jobs.providers;

import hudson.Extension;
import hudson.model.Job;
import org.jenkinsci.plugins.popular_jobs.Messages;
import org.jenkinsci.plugins.popular_jobs.PopularExtension;
import org.kohsuke.stapler.StaplerRequest;

/**
 * Created with IntelliJ IDEA.
 * User: 23052130
 * Date: 2014-08-21
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
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
