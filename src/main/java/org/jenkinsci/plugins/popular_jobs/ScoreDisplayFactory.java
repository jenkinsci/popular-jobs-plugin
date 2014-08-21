package org.jenkinsci.plugins.popular_jobs;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.TransientProjectActionFactory;

import java.util.Collection;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: 23052130
 * Date: 2014-08-21
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */
@Extension
public class ScoreDisplayFactory extends TransientProjectActionFactory {
    @Override
    public Collection<? extends Action> createFor(AbstractProject target) {
        return Collections.singleton(new ProjectScoreDisplayAction(target));
    }
}
