package org.jenkinsci.plugins.popular_jobs;

import hudson.ExtensionPoint;

public interface PopularProvider {
    String getDisplayName();
}
