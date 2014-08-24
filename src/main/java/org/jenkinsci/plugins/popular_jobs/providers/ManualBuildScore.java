package org.jenkinsci.plugins.popular_jobs.providers;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.Cause;
import hudson.model.Job;
import hudson.model.TaskListener;
import hudson.model.listeners.RunListener;
import org.jenkinsci.plugins.popular_jobs.Messages;
import org.jenkinsci.plugins.popular_jobs.PopularDataStore;
import org.jenkinsci.plugins.popular_jobs.PopularExtension;
import org.jenkinsci.plugins.popular_jobs.PopularProvider;
import org.kohsuke.stapler.StaplerRequest;

@Extension
public class ManualBuildScore extends RunListener<AbstractBuild<?, ?>> implements PopularProvider {

    @Override
    public String getDisplayName() {
        return Messages.ManualBuildScore_DisplayName();
    }

    @Override
    public void onStarted(AbstractBuild<?, ?> abstractBuild, TaskListener listener) {
        if (abstractBuild.getCause(Cause.UserCause.class) != null) {
            PopularDataStore.store(abstractBuild.getProject().getAllJobs().iterator().next(), 1, this);
        }
    }
}
