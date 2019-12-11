package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.WebDriverFacade;

import java.util.List;

public class YoutubePage extends AbstractPage {

    private static final String PAGE_URL = "https://youtube.com";

    public YoutubePage(WebDriverFacade facade) {
        super(PAGE_URL, facade);
    }

    public WebElement getSearch() {
        return facade.waitForElement(By.className("search"));
    }

    public WebElement getSearchButton() {
        return facade.waitForElement(By.id("search-icon-legacy"));
    }

    public List<WebElement> getSearchResults() {
        return facade.waitForElements(By.id("video-title"));
    }
}
