package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasteBinResultPage {

    private final By title = By.xpath("//h1[text()='how to gain dominance among developers']");
    private final By textArea = By.xpath("//textarea[@class='textarea']");

    public PasteBinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;

    private String getTextFrom(By by) {
        WebElement title = new WebDriverWait(driver, 20)
                .until(webDriver ->
                        webDriver.findElement(by));

        return title.getText();
    }

    public String getTitleText() {
        return this.getTextFrom(title);
    }

    public String getTextArea() {
        return getTextFrom(textArea);
    }

    public boolean isSyntax(String syntax) {
        List<WebElement> elements = driver.findElements(By.xpath("//a[text()='" + syntax + "']"));
        return elements.size() > 0;
    }

}
