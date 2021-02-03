package SeleniumHomeTasks.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CloudGoogleCalculatorPage {

    private final String secondInnerFrame = "myFrame";
    private final By firstInnerFrame = By.xpath("//iframe[contains(@src,'/products/calculator')]");
    private final By computeEngineTab = By.xpath("//div[@title='" + CloudTestProperty.TAB_TO_SELECT + "']/parent::md-tab-item");
    private final By instances = By.xpath("//input[contains(@ng-model,'quantity')]");
    private final By fieldOs = By.xpath("//md-select[contains(@ng-model,'computeServer.os')]");
    private final By osToSelect = By.xpath("//div[@class='md-text' and contains(text(), '" + CloudTestProperty.OS + "')]/parent::md-option");
    private final By fieldMachineClass = By.xpath("//md-select[contains(@ng-model,'computeServer.class')]");
    private final By machineClassToSelect = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//div[@class = 'md-text' and contains(text(), '" +
            CloudTestProperty.MACHINE_CLASS +
            "')]//ancestor::md-option");
    private final By fieldMachineSeries = By.xpath("//md-select[contains(@ng-model,'computeServer.series')]");
    private final By machineSeriesSelect = By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.MACHINE_SERIES +
            "')]/parent::md-option");
    private final By fieldMachineType = By.xpath("//md-select[contains(@ng-model,'computeServer.instance')]");
    private final By machineTypeSelect = By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.MACHINE_TYPE +
            "')]/parent::md-option");
    private final By checkBoxGPU = By.xpath("//md-checkbox[contains(@ng-model,'computeServer.addGPUs')]");
    private final By typeGpu = By.xpath("//md-select[contains(@ng-model,'computeServer.gpuType')]");
    private final By typeGpuSelect = By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.GPU_TYPE +
            "')]/parent::md-option");
    private final By numberGpu = By.xpath("//md-select[contains(@ng-model,'computeServer.gpuCount')]");
    private final By numberGpuSelect = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.GPU_COUNT
            + "')]/parent::md-option");
    private final By fieldSsdType = By.xpath("//md-select[contains(@ng-model,'computeServer.ssd')]");
    private final By ssdTypeSelect = By.xpath("//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.SSD_TYPE +
            "')]/parent::md-option");
    private final By fieldDataCenter = By.xpath("//md-select[contains(@ng-model,'computeServer.location')]");
    private final By dataCenterSelect = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//div[@class='md-text ng-binding' and contains(text(), '" +
            CloudTestProperty.MACHINE_LOCATION
            + "')]/parent::md-option");
    private final By fieldCommittedUsage = By.xpath("//md-select[contains(@ng-model,'computeServer.cud')]");
    private final By committedUsageSelect = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//div[@class='md-text' and contains(text(), '" +
            CloudTestProperty.COMMITED_USAGE
            + "')]/parent::md-option");

    private final By submit = By.xpath("//button[@aria-label='Add to Estimate' and not(@disabled)]");

    private final By submitByEmail = By.xpath("//button[@aria-label='Email Estimate' and not(@disabled)]");
    private final By fieldEmail = By.xpath("//form[@name='emailForm']//input[@ng-model='emailQuote.user.email']");
    private final By submitSendEmail = By.xpath("//button[contains(text(),'Send Email') and not(@disabled)]");

    private final By vmClass = By.xpath("//div[contains(@src,'/cloudcart.ng')]//div[contains(text(),'VM class')]");
    private final By instanceType = By.xpath("//div[contains(@src,'/cloudcart.ng')]//div[contains(text(),'Instance type')]");
    private final By region = By.xpath("//div[contains(@src,'/cloudcart.ng')]//div[contains(text(),'Region')]");
    private final By localSsd = By.xpath("//div[contains(@src,'/cloudcart.ng')]//div[contains(text(),'local SSD')]");
    private final By commitmentTerm = By.xpath("//div[contains(@src,'/cloudcart.ng')]//div[contains(text(),'Commitment term')]");

    private final By cost = By.xpath("//*[@id='resultBlock']//md-card-content//h2[@class='md-title']/b");

    private final WebDriver driver;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeContextToFrame() {
        WebElement firstFrame = driver.findElement(firstInnerFrame);
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondInnerFrame);
    }

    public void selectCalcTab() {
        WebElement computeEngineTab = this.getElementWithWait(this.computeEngineTab);
        computeEngineTab.click();
    }

    public void fillForm() {
        // Change context to needed frame
        this.changeContextToFrame();
        // Select Compute engine tab
        this.selectCalcTab();

        // Instances
        this.fillInstances();

        // Operating System / Software
        this.selectOs();

        // Machine Class
        this.selectMachineClass();

        // Series
        this.selectMachineSeries();

        // Machine type
        this.selectMachineType();

        // Select GPU
        this.selectGpu();

        // SSD type
        this.selectSsdType();

        // DataCenter location
        this.selectMachineLocation();

        // CommittedUsage
        this.selectCommitedUsage();
    }

    private void fillInstances() {
        this.sendTextToField(instances, CloudTestProperty.INSTANCES_QT);
    }

    private void selectOs() {
        this.toClickSelect(this.fieldOs, this.osToSelect);
    }

    private void selectMachineClass() {
        this.toClickSelect(this.fieldMachineClass, this.machineClassToSelect);
    }

    private void selectMachineSeries() {
        this.toClickSelect(this.fieldMachineSeries, this.machineSeriesSelect);
    }

    private void selectMachineType() {
        this.toClickSelect(this.fieldMachineType, this.machineTypeSelect);
    }

    private void selectGpu() {
        // ClickCheckBox
        WebElement gpuCheckBox = this.getElementWithWait(this.checkBoxGPU);
        gpuCheckBox.click();

        // Select Count GPU
        this.toClickSelect(numberGpu, numberGpuSelect);

        // Select Type GPU
        this.toClickSelect(this.typeGpu, this.typeGpuSelect);
    }

    private void selectSsdType() {
        this.toClickSelect(this.fieldSsdType, this.ssdTypeSelect);
    }

    private void selectMachineLocation() {
        this.toClickSelect(this.fieldDataCenter, this.dataCenterSelect);
    }

    private void selectCommitedUsage() {
        this.toClickSelect(this.fieldCommittedUsage, this.committedUsageSelect);
    }

    public void clickAddToEstimate() {
        WebElement submitButtonElement = this.getElementWithWait(submit);
        submitButtonElement.click();
    }

    public String getCost() {
        return this.getElementWithWait(this.cost).getText();
    }

    public void checkCost() {
        String costActual = this.getCost();
        Assert.assertTrue(costActual.contains(CloudTestProperty.COST_CHECK),
                this.getMessage(costActual, CloudTestProperty.COST_CHECK));
    }

    public void sendEstimateToEmail(String email) {
        WebElement submitByEmail = this.getElementWithWait(this.submitByEmail);
        submitByEmail.click();
        WebElement fieldEmail = this.getElementWithVisibility(this.fieldEmail);
        fieldEmail.sendKeys(email);
        WebElement submitSendEmail = this.getElementWithWait(this.submitSendEmail);
        submitSendEmail.click();
    }

    public void checkResult() {
        // VM class
        String vmClassActual = this.getElementWithVisibility(this.vmClass).getText();
        Assert.assertTrue(vmClassActual.contains(CloudTestProperty.MACHINE_CLASS.toLowerCase()),
                this.getMessage(vmClassActual, CloudTestProperty.MACHINE_CLASS.toLowerCase()));

        // Instance type
        String instanceTypeActual = this.getElementWithVisibility(this.instanceType).getText();
        Assert.assertTrue(instanceTypeActual.contains(CloudTestProperty.MACHINE_TYPE),
                this.getMessage(instanceTypeActual, CloudTestProperty.MACHINE_TYPE));

        // Region
        String regionActual = this.getElementWithVisibility(this.region).getText();
        Assert.assertTrue(regionActual.contains(CloudTestProperty.MACHINE_LOCATION),
                this.getMessage(regionActual, CloudTestProperty.MACHINE_LOCATION));

        // Local SSD
        String localSsdActual = this.getElementWithVisibility(this.localSsd).getText();
        Assert.assertTrue(localSsdActual.contains(CloudTestProperty.SSD_TYPE),
                this.getMessage(localSsdActual, CloudTestProperty.SSD_TYPE));

        // Commitment term
        String commitmentTermActual = this.getElementWithVisibility(this.commitmentTerm).getText();
        Assert.assertTrue(commitmentTermActual.contains(CloudTestProperty.COMMITED_USAGE),
                this.getMessage(commitmentTermActual, CloudTestProperty.COMMITED_USAGE));
    }

    private String getMessage(String actual, String expected) {
        return "Actual: " + actual + "\n not contains: " + expected;
    }

    private WebElement getElementWithWait(By by) {
        return new WebDriverWait(driver, CloudTestProperty.GLOBAL_WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement getElementWithVisibility(By by) {
        return new WebDriverWait(driver, CloudTestProperty.GLOBAL_WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void toClickSelect(By click, By select) {
        // Click
        WebElement clickElement = this.getElementWithWait(click);
        clickElement.click();

        // Select
        WebElement selectElement = this.getElementWithWait(select);
        selectElement.click();
    }

    private void sendTextToField(By by, String text) {
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
    }
}
