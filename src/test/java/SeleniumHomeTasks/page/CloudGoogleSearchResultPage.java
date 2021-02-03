package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleSearchResultPage {

    private final By searchResult = By.xpath("//a[@class='gs-title']/b[contains(text(), '" + CloudTestProperty.STRING_TO_FIND + "')]");

    private final WebDriver driver;

    public CloudGoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchInGoogleCloudPage() {
        WebElement searchResult = new WebDriverWait(driver, 20).until(ExpectedConditions
            .elementToBeClickable(this.searchResult));
        searchResult.click();
    }
}
