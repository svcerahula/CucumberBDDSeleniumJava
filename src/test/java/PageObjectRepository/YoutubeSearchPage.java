package PageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YoutubeSearchPage {

    public By searchBakkappaTextXpath
            = By.xpath("//div[@id=\"text-container\"]/yt-formatted-string[contains(text(),\"Bakkappa N\")]");
    @FindBy(xpath="//input[@id=\"search\"]")
    WebElement searchTextBox;

    @FindBy(id="search-icon-legacy")
    WebElement searchButton;

    public void enterTextInSearch(String searchString) {
        searchTextBox.sendKeys(searchString);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }
}
