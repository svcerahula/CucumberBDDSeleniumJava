package StepDefinitions;

import PageObjectRepository.YoutubeSearchPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;

import static Utilities.PropertiesFileReader.props;
import static Utilities.WebDriverManger.initializeDriver;

public class YoutubeAppStepDefintions {
    WebDriver driver =null;
    YoutubeSearchPage searchPage;

    @Before
    public void setup() throws IOException {
        driver = initializeDriver();
        searchPage = PageFactory.initElements(driver,YoutubeSearchPage.class);
    }

    @Given("^open chrome browser and enter url$")
    public void open_chrome_browser_and_enter_url() throws Throwable {
        driver.get(props.getProperty("baseUrl"));
    }

    @When("^enter search criteria as \"([^\"]*)\"$")
    public void enter_search_criteria_as(String searchString) throws Throwable {
        searchPage.enterTextInSearch(searchString);
    }

    @Then("^click on search button$")
    public void click_on_search_button() throws Throwable {
        searchPage.clickOnSearchButton();
    }

    @And("^Search results page should have title as \"([^\"]*)\"$")
    public void search_results_related_to_Selenium_should_be_available(String expectedTitleString) throws Throwable {
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitleString)) {
            System.out.println("actual title : "+ actualTitle);
        } else {
            Assert.fail("Search failed");
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
