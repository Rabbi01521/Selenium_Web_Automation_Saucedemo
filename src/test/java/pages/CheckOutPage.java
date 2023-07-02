package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{

    public By cancel = By.id("cancel");
    public By finish = By.id("finish");
    public String checkoutPageTwo = "https://www.saucedemo.com/checkout-step-two.html";
    public String ThankYouPage = "https://www.saucedemo.com/checkout-complete.html";
    public By thankYouText = By.xpath("//h2[normalize-space()='Thank you for your order!']");
    public By homeBtn = By.id("back-to-products");
    public By continueBtn = By.id("continue");
    public By first_name = By.xpath("//input[@id='first-name']");
    public By last_name = By.id("last-name");
    public By postal_code = By.id("postal-code");

}
