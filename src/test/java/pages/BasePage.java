package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnAElement(By locator){
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
       return getElement(locator).getText();
    }

    public void getDropDown(WebElement locator){
        Select select = new Select(locator);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(select.getFirstSelectedOption().getText(), "Price (high to low)");
    }



    /************************
     * Get Current Page URL *
     ************************
     */

    public String currentPageUrl() {
        return getDriver().getCurrentUrl();
    }

    /**************************
     * Get Current Page Title *
     **************************
     */

    public String getTitle() {
        return getDriver().getTitle();
    }

    /************************************************************
     * Write in a input field *
     *
     * @param element This is the target element where to write *
     * @param value   what to write *
     ************************************************************
     */

    public void sendTextOnElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    /****************************************************************************
     * Perform Hover on an element *
     *
     * @param element This is the target element where to perform hover action *
     ****************************************************************************
     */

    public void hover(WebElement element) {
        Actions action = new Actions(getDriver());
        action.clickAndHold(element).build().perform();
    }

    /********************************************************************
     * Handle shadow Dome Related Task *
     *
     * @param host    is the root element shadow dome *
     * @param element is the targeted element within the shadow dome *
     ********************************************************************
     */

    public void shadowDomePopup(WebElement host, By element) {
        // Finding the ShadowRoot in a WebElement
        SearchContext context = host.getShadowRoot();
        // finding the targeted element
        context.findElement(element).click();
    }

    /************************************************
     * Handle Select Tag Related Element Task *
     *
     * @param element locator of Select tag *
     * @param value   attribute value of option tag *
     ************************************************
     */

    public void selectItemByValue(WebElement element, String value) {
        Select selectItems = new Select(element);
        selectItems.selectByValue(value);
    }

    public void selectItemByVisibleText(WebElement element, String value) {
        Select selectItems = new Select(element);
        selectItems.selectByVisibleText(value);
    }

    public void selectItemByIndex(WebElement element, int index) {
        Select selectItems = new Select(element);
        selectItems.selectByIndex(index);
    }

    /********************************************
     * Get selected Item's Text *
     ********************************************
     */

    public String selectedItemText(WebElement element) {
        Select selectItems = new Select(element);
        return selectItems.getFirstSelectedOption().getText();
    }

    /************************************************************
     * Get Items select status True if selected or false *
     * **********************************************************
     */

    public boolean itemSelectedStatus(List<WebElement> elements, String value) {
        for (WebElement element : elements) {
            if (element.getAttribute("value").equals(value)) {
                return element.isSelected();
            }
        }
        return false;
    }

    /*************************************
     * Handle List elements Related Task *
     *************************************
     */

    // Perform any action on the nth number of elements from an elements list
    public void clickOnNthNumberButton(List<WebElement> elements, int position) {
        elements.get(position - 1).click();
    }

    // Perform click action on an element where visible Text matches from an element
    // list
    public void listItem(List<WebElement> elements, String visibleText) {
        for (WebElement element : elements) {
            if (element.getText().equals(visibleText)) {
                element.click();
                break;
            }
        }
    }

    /**********************************
     * Handle JavaScript Related Task *
     **********************************
     */

    // click on a hidden element by using JavascriptExecutor
    public void clickOnAButtonJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(script + ".click();");
    }

    // Set any DOM element Border color using JavascriptExecutor
    public void highlighter(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", element);
    }

    /************************************************
     * Scroll to an element *
     *
     * @param element This is the target element *
     ************************************************
     */

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /************************************************
     * Scroll UP and DOWN *
     ************************************************
     */

    // scroll up a page
    public void scrollPageUp() {
        Actions action = new Actions(getDriver());
        // action.sendKeys(Keys.PAGE_UP).build().perform();
        action.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();

    }

    // scroll down a page
    public void scrollPageDown() {
        Actions action = new Actions(getDriver());
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        // action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    /************************************************************************
     * Scroll Within an element *
     *
     * @param cssLocator is the target element's cssLocator/query selector *
     * @param offsetX    is the scroll position relative to x axis *
     * @param offsetY    is the scroll position relative to Y axis *
     ************************************************************************
     */

    public void scrollInsideElement(String cssLocator, int offsetX, int offsetY) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.querySelector('" + cssLocator + "').scrollBy(" + offsetX + "," + offsetY + ");");
    }

    /****************************
     * Handle Wait Related Task *
     ****************************
     */

    WebDriverWait wait;

    // wait for default set seconds
    public void timeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // wait for customize given seconds
    public void timeOut(int durationMS) {
        try {
            Thread.sleep(durationMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Wait for an alert present and return with an alert
    public Alert waitForAlert() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    // Wait for an element to be present
    public void waitForElement(By element) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitUntilElementVisible(WebElement element) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /***********************************************
     * Wait to completely load the current web page*
     * *********************************************
     */

    public void waitForPageLoad() {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState;").equals("complete"));
    }

    /*****************************
     * Handle Alert Related Task *
     *****************************
     */

    // Accept alert whenever it present
    public void alertAccept() {
        Alert alert = waitForAlert();
        alert.accept();
    }

    // Accept alert with giving text whenever it present
    public void alertAccept(String value) {
        Alert alert = waitForAlert();
        alert.sendKeys(value);
        alert.accept();
    }

    // Decline alert whenever it presents
    public void alertDismiss() {
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    /****************************
     * Faker Related Task *
     ****************************
     */

    static Faker faker = new Faker(new Locale("en-US"));

    public String emailGenerate() {
        return faker.bothify("????##@mail.com");
    }

    public String firstNameGenerate() {
        return faker.name().firstName();
    }

    public String lastNameGenerate() {
        return faker.name().lastName();
    }

    public String phoneNumberGenerate() {
        return faker.numerify("###-###-####");
    }

    public String zipCodeGenerate() {
        return faker.numerify("####");
    }

    public String passwordGenerate() {
        return faker.animal().name();
    }

    /************************************************************************************
     * Perform Double Click on an element * *
     *
     * @param element This is the target element where to perform double click
     *                action *
     ************************************************************************************
     */

    public void doubleClick(WebElement element) {
        Actions action = new Actions(getDriver());
        action.doubleClick(element).build().perform();
    }

    /****************************
     * Window Handling *
     ****************************
     */

    public List<String> windowHandling() {
        // Get all window handles and hold them in a list.
        Set<String> windowHandles = getDriver().getWindowHandles(); // driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);

        // Write to total window handle number to the console.
        @SuppressWarnings("unused")
        int size = windowHandlesList.size();
        return windowHandlesList;
    }

    public void pageRefresh() {
        getDriver().navigate().refresh();
    }

    public void newTabOpen() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        System.out.println("Open a new Tab");
    }

    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)(getDriver())).getScreenshotAs(OutputType.BYTES)));
    }
}
