package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinMainPage {

    private final String MAIN_PAGE_URL = "https://pastebin.com/";

    private final By postForm = By.xpath("//*[@id='postform-text']");
    private final By postFormExpireCont = By.xpath("//*[@id='select2-postform-expiration-container']");
    private final By postFormName = By.xpath("//input[@id='postform-name']");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By syntaxHighlightingCont = By.xpath("//*[@id='select2-postform-format-container']");

    public PasteBinMainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private final WebDriver driver;

    public void openMainPage() {
        this.driver.get(MAIN_PAGE_URL);
    }

    public void fillTextInPostForm(String text) {
        this.fillText(postForm, text);
    }

    public void fillTextInPostName(String text) {
        this.fillText(postFormName, text);
    }

    private void fillText(By by, String text) {
        WebElement input = driver.findElement(by);
        input.sendKeys(text);
    }

    private void buttonClick(By by) {
        WebElement button = new WebDriverWait(driver, 20).until(ExpectedConditions
                .elementToBeClickable(by));
        button.click();
    }
    public void clickSelectExpireButton(String expireTime) {
        this.buttonClick(postFormExpireCont);
        this.buttonClick(By.xpath("//li[text()='" + expireTime + "']"));
    }

    public void clickSubmitButton() {
        this.buttonClick(submitButton);
    }

    public void selectBash(String syntaxHighlighting) {
            this.buttonClick(syntaxHighlightingCont);
            this.buttonClick(By.xpath("//li[text()='" + syntaxHighlighting + "']"));
    }
}
