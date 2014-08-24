package org.jenkinsci.plugins.popular_jobs;

import hudson.ExtensionPoint;
import hudson.model.Job;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.Ancestor;
import org.kohsuke.stapler.StaplerRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The visitor score provider.
 *
 * @author &lt;robert.sandell@gmail.com&gt;
 */
public abstract class PopularExtension implements ExtensionPoint, PopularProvider {

    public abstract int getScore(Job job, StaplerRequest request);

    public static List<PopularExtension> all() {
        return Jenkins.getInstance().getExtensionList(PopularExtension.class);
    }

    public boolean matchesPathAfter(Class<?> ancestorClass, StaplerRequest request, Pattern needle) {
        Ancestor ancestor = request.findAncestor(ancestorClass);
        if (ancestor != null) {
            String requestUri = request.getRequestURI();
            String ancestorPath = ancestor.getUrl();
            if (requestUri != null && requestUri.startsWith(ancestorPath)) {
                String path = requestUri.substring(ancestorPath.length());
                return needle.matcher(path).matches();
            }
        }
        return false;
    }

    public boolean referrerMatches(StaplerRequest request, Pattern needle) {
        Ancestor ancestor = request.findAncestor(Job.class);
        String referrer = request.getReferer();
        if (ancestor != null && referrer != null) {
            try {
                String requestUri = new URI(referrer).getPath();
                String ancestorPath = ancestor.getUrl();
                if (requestUri != null && requestUri.startsWith(ancestorPath)) {
                    String path = requestUri.substring(ancestorPath.length());
                    return needle.matcher(path).matches();
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
