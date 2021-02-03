package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmailPage {

    private final String ATTRIBUTE = "value";
    private final int TIMEOUT_TO_GET_EMAIL_ADDRESS = 100;
    private final int DEFAULT_TIMEOUT = 20;
    private final int TIMEOUT_TO_RECIEVE_MESSAGE = 600;
    private final String MAIN_PAGE_EMAIL = "https://10minutemail.com/";

    private final By emailField = By.xpath("//input[@id='mail_address']");
    private final By recievedMessage = By.xpath("//div[@class='mail_message']//span[contains(text()," +
            " 'Google Cloud Platform Price Estimate')]/ancestor::div[@class='message_top']");
    private final By resultEstimate = By.xpath("//table[@class='quote']//h3[contains(text(),'USD')]");

    private final WebDriver driver;

    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openEmailPage() {
        driver.get(MAIN_PAGE_EMAIL);
    }

    public String getEmailAddress() {
        WebElement emailText = driver.findElement(this.emailField);
        new WebDriverWait(driver, TIMEOUT_TO_GET_EMAIL_ADDRESS)
                .until(ExpectedConditions.attributeToBeNotEmpty(emailText, ATTRIBUTE));
        return emailText.getAttribute(ATTRIBUTE);
    }

    public void waitAndClickMessage() {
        WebElement message = new WebDriverWait(driver, TIMEOUT_TO_RECIEVE_MESSAGE)
                .until(ExpectedConditions.elementToBeClickable(this.recievedMessage));
        message.click();
    }

    public void checkUsdEstimate(String actual) {
        WebElement resultUsd = new WebDriverWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(this.resultEstimate));
        Assert.assertTrue(actual.contains(resultUsd.getText()));
    }
}
