package SeleniumHomeTasks.tests;

import SeleniumHomeTasks.page.CloudGoogleCalculatorPage;
import SeleniumHomeTasks.page.CloudGoogleSearchPage;
import SeleniumHomeTasks.page.CloudGoogleSearchResultPage;
import SeleniumHomeTasks.page.EmailPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class HardCore {

    @Test
    public void getHardCore() {

        ChromeDriver driver = new ChromeDriver();

        CloudGoogleSearchPage startPage = new CloudGoogleSearchPage(driver);
        startPage.openGoogleCloudPage();
        startPage.searchInGoogleCloudPage();

        CloudGoogleSearchResultPage searchResultPage = new CloudGoogleSearchResultPage(driver);
        searchResultPage.searchInGoogleCloudPage();

        CloudGoogleCalculatorPage calculatorPage = new CloudGoogleCalculatorPage(driver);

        calculatorPage.fillForm();

        calculatorPage.clickAddToEstimate();

        String actualCost = calculatorPage.getCost();

        driver.executeScript("window.open('');");

        List<String> tabs = new LinkedList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        EmailPage emailPage = new EmailPage(driver);

        emailPage.openEmailPage();

        String emailAddress = emailPage.getEmailAddress();

        driver.switchTo().window(tabs.get(0));

        calculatorPage.changeContextToFrame();

        calculatorPage.sendEstimateToEmail(emailAddress);

        driver.switchTo().window(tabs.get(1));

        emailPage.waitAndClickMessage();

        emailPage.checkUsdEstimate(actualCost);

        driver.quit();
    }
}
