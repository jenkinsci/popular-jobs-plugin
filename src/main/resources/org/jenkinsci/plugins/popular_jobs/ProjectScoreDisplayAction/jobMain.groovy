import org.jenkinsci.plugins.popular_jobs.PopularDataStore
def t= namespace("/lib/hudson")
span(style:"font-size: larger", _("Score", PopularDataStore.getScore(my.myJob)))