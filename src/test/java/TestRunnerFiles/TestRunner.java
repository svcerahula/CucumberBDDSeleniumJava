package TestRunnerFiles;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",glue="StepDefinitions",tags="@UITesting",
  plugin={ "pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},monochrome=true)
public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void initSetup() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void featureRun(CucumberFeatureWrapper cucumberfeature) {
        testNGCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDown() {
        testNGCucumberRunner.finish();
    }
}
