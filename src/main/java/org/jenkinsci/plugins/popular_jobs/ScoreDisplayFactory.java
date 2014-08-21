package org.jenkinsci.plugins.popular_jobs;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.TransientProjectActionFactory;

import java.util.Collection;
import java.util.Collections;

/**
 * Factory of {@link ProjectScoreDisplayAction}.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
@Extension
public class ScoreDisplayFactory extends TransientProjectActionFactory {
    @Override
    public Collection<? extends Action> createFor(AbstractProject target) {
        System.out.println("Factory called");
        return Collections.singleton(new ProjectScoreDisplayAction(target));
    }
}
