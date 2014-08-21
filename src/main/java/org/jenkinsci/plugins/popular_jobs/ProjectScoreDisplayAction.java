package org.jenkinsci.plugins.popular_jobs;

import hudson.model.Action;
import hudson.model.Job;

/**
 * Displays the project's score on the main page.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
public class ProjectScoreDisplayAction implements Action {
    private Job myJob;

    public ProjectScoreDisplayAction(Job myJob) {
        this.myJob = myJob;
    }

    public String getIconFileName() {
        return null;
    }

    public String getDisplayName() {
        return null;
    }

    public String getUrlName() {
        return null;
    }

    public Job getMyJob() {
        return myJob;
    }
}
