package SeleniumHomeTasks.tests;

import SeleniumHomeTasks.page.CloudGoogleCalculatorPage;
import SeleniumHomeTasks.page.CloudGoogleSearchPage;
import SeleniumHomeTasks.page.CloudGoogleSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HurtMePlenty {

    @Test
    public void getHurtMePlenty() {


        WebDriver driver = new ChromeDriver();

        CloudGoogleSearchPage startPage = new CloudGoogleSearchPage(driver);
        startPage.openGoogleCloudPage();
        startPage.searchInGoogleCloudPage();

        CloudGoogleSearchResultPage searchResultPage = new CloudGoogleSearchResultPage(driver);
        searchResultPage.searchInGoogleCloudPage();

        CloudGoogleCalculatorPage calculatorPage = new CloudGoogleCalculatorPage(driver);

        calculatorPage.fillForm();

        calculatorPage.clickAddToEstimate();

        calculatorPage.checkResult();

        calculatorPage.checkCost();

        driver.quit();
    }
}
