package SeleniumHomeTasks.tests;

import SeleniumHomeTasks.page.PasteBinMainPage;
import SeleniumHomeTasks.page.PasteBinResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BringItOn {

    private final String postForm = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private final String postName = "how to gain dominance among developers";
    private final String syntax = "Bash";
    private final String expire = "10 Minutes";

    @Test
    public void getBringItOn() {


        WebDriver driver = new ChromeDriver();

        PasteBinMainPage mainPage = new PasteBinMainPage(driver);
        mainPage.openMainPage();
        mainPage.fillTextInPostForm(postForm);
        mainPage.clickSelectExpireButton(expire);
        mainPage.fillTextInPostName(postName);
        mainPage.selectBash(syntax);
        mainPage.clickSubmitButton();

        PasteBinResultPage resultPage = new PasteBinResultPage(driver);
        Assert.assertEquals(resultPage.getTitleText(), postName);
        Assert.assertTrue(resultPage.isSyntax(syntax), "Highlighting not " + syntax);
        Assert.assertEquals(resultPage.getTextArea(), postForm);

        driver.quit();
    }
}
