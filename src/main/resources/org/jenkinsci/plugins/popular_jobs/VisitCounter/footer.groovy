import hudson.model.Job
import org.jenkinsci.plugins.popular_jobs.PopularDataStore
import org.jenkinsci.plugins.popular_jobs.PopularExtension
import org.kohsuke.stapler.Ancestor
import org.kohsuke.stapler.Stapler

Ancestor jobAncestor = Stapler.getCurrentRequest().findAncestor(Job.class)
if (jobAncestor != null) {
    PopularExtension.all().each {
        int score = it.getScore(jobAncestor.object, Stapler.getCurrentRequest())
        if (score != 0) {
            PopularDataStore.store(jobAncestor.object, score, it)
        }
    }
}
