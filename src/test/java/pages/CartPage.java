package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{

    public String cart_url = "https://www.saucedemo.com/cart.html";
    public String checkoutUrl = "https://www.saucedemo.com/checkout-step-one.html";
    public By add_to_cart_sauce_labs_onesie = By.id("add-to-cart-sauce-labs-onesie");
    public By remove_sauce_labs_bike_light = By.id("remove-sauce-labs-bike-light");
    public  By item_4_title_link = By.id("item_4_title_link");
    public  By product_price_bike_light = By.xpath("//div[normalize-space()='$29.99']");
    public By remove_sauce_labs_backpack = By.id("remove-sauce-labs-backpack");
    public By remove_sauce_labs_onesie = By.id("remove-sauce-labs-onesie");
    public By remove_sauce_labs_bolt_t_shirt = By.id("remove-sauce-labs-bolt-t-shirt");
    public  By continue_shopping = By.id("continue-shopping");
    public By checkout = By.id("checkout");

}
