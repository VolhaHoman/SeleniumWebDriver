package SeleniumHomeTasks.tests;

import SeleniumHomeTasks.page.PasteBinMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICanWin {

    private final String postForm = "Hello from WebDriver";
    private final String postName = "helloweb";
    private final String expire = "10 Minutes";

    @Test
    public void getICanWin() {

        WebDriver driver = new ChromeDriver();

        PasteBinMainPage mainPage = new PasteBinMainPage(driver);

        mainPage.openMainPage();
        mainPage.fillTextInPostForm(postForm);
        mainPage.clickSelectExpireButton(expire);
        mainPage.fillTextInPostName(postName);
        mainPage.clickSubmitButton();

        driver.quit();
    }
}
