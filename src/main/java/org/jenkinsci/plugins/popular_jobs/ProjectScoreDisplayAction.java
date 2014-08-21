package org.jenkinsci.plugins.popular_jobs;

import hudson.model.Action;
import hudson.model.Job;

/**
 * Created with IntelliJ IDEA.
 * User: 23052130
 * Date: 2014-08-21
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
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
