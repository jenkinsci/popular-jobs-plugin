package org.jenkinsci.plugins.popular_jobs.providers;

import hudson.Extension;
import hudson.model.Build;
import hudson.model.Job;
import org.jenkinsci.plugins.popular_jobs.Messages;
import org.jenkinsci.plugins.popular_jobs.PopularExtension;
import org.kohsuke.stapler.StaplerRequest;

import java.util.regex.Pattern;

@Extension
public class ConfigureBuildScore extends PopularExtension {

    private static final Pattern NEEDLE = Pattern.compile("/configure");

    @Override
    public int getScore(Job job, StaplerRequest request) {
        if (referrerMatches(request, NEEDLE)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String getDisplayName() {
        return Messages.ConsoleVisitScore_DisplayName();
    }
}
