package org.jenkinsci.plugins.popular_jobs;

import hudson.ExtensionPoint;
import hudson.model.Job;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.StaplerRequest;

import java.util.List;

/**
 * The visitor score provider.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
public abstract class PopularExtension implements ExtensionPoint {

    public abstract int getScore(Job job, StaplerRequest request);

    public abstract String getDisplayName();

    public static List<PopularExtension> all() {
        return Jenkins.getInstance().getExtensionList(PopularExtension.class);
    }
}
