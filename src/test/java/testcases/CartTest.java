package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class CartTest extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    public void navigateToProductPage(){
        getDriver().get(loginPage.login_page_url);
        String[] user = loginPage.getUserName().split("\n");
        String[] pass = loginPage.getPassword().split("\n");
        System.out.println( user[1] +" , "+ pass[1]);
        loginPage.writeOnElement(loginPage.username_input_field, user[1]);
        loginPage.writeOnElement(loginPage.password_input_field, pass[1]);
        loginPage.clickOnAElement(loginPage.login_button);
    }

    public  void navigateToCartPage(){
        productPage.clickOnAElement(productPage.back_pack_add_to_cart_btn);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bike_light);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_onesie);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bolt_t_shirt);
        productPage.clickOnAElement(productPage.shopping_cart_container);
    }


    @Test
    public void checkCartPage(){
        navigateToProductPage();
        cartPage.timeOut();
        navigateToCartPage();
        cartPage.timeOut();
        cartPage.scrollPageDown();
        cartPage.timeOut();
        cartPage.clickOnAElement(cartPage.remove_sauce_labs_bolt_t_shirt);
        cartPage.timeOut();
//        cartPage.clickOnAElement(cartPage.remove_sauce_labs_bike_light);
        cartPage.timeOut();
        cartPage.clickOnAElement(cartPage.continue_shopping);
        cartPage.timeOut();
        cartPage.scrollPageDown();
//        cartPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bike_light);
        cartPage.scrollPageUp();
        cartPage.timeOut();
        cartPage.clickOnAElement(productPage.shopping_cart_container);
        cartPage.timeOut();
        cartPage.clickOnAElement(cartPage.checkout);
        cartPage.timeOut();
        Assert.assertEquals(getDriver().getCurrentUrl(), cartPage.checkoutUrl);
        cartPage.timeOut();
    }
}
