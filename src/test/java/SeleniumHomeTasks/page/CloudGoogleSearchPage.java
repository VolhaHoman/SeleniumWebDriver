package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudGoogleSearchPage {

    private final By searchInput = By.xpath("//input[@placeholder='Search']");

    private final WebDriver driver;

    public CloudGoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openGoogleCloudPage() {
        driver.get(CloudTestProperty.MAIN_PAGE_CLOUD);
    }

    public void searchInGoogleCloudPage() {
        WebElement searchItem = driver.findElement(searchInput);
        searchItem.click();
        searchItem.sendKeys(CloudTestProperty.STRING_TO_FIND);
        searchItem.sendKeys(Keys.ENTER);
    }
}
