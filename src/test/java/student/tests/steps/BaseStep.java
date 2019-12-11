package student.tests.steps;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import io.cucumber.testng.CucumberFeatureWrapper;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.GoogleSearchPage;
import pages.YoutubePage;
import util.WebDriverFacade;

@CucumberOptions(plugin = {"pretty", "json:target/report/cucumber2.json"}, features = {
    "src/test/resources/features"}, glue = {"student.tests.steps"})
public class BaseStep {

    protected GoogleSearchPage googleSearchPage;

    protected YoutubePage youtubePage;

    protected CalendarPage calendarPage;

    private TestNGCucumberRunner testNGCucumberRunner;

    public BaseStep(){
        this.googleSearchPage = new GoogleSearchPage(WebDriverFacade.getInstance());
        this.youtubePage = new YoutubePage(WebDriverFacade.getInstance());
        this.calendarPage = new CalendarPage(WebDriverFacade.getInstance());
    }



    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @BeforeSuite
    public static void setup() {
        System.out.println("Ran once the before all the tests");
    }

    @AfterSuite
    public static void cleanup() {
        WebDriverFacade.getInstance().quit();
    }
}
