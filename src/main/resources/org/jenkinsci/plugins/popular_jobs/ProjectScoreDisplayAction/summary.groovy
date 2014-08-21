import org.jenkinsci.plugins.popular_jobs.PopularDataStore
def t= namespace("/lib/hudson")
System.out.println("Summary!!!")
t.summary{
        _("Score")
        span(PopularDataStore.getScore(my.myJob))
}
