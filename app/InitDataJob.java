import models.Section;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;


@OnApplicationStart
public class InitDataJob extends Job {

    
    @Override
    public void doJob() throws Exception {
        if ( Section.count() == 0 ) {
            Fixtures.loadModels("init-data.yml");
        }
    }
}
