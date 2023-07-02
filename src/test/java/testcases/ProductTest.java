package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class ProductTest extends DriverSetup{
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


    @Test
    public void testFakeDataCreate(){
        System.out.println(productPage.emailGenerate());
        System.out.println(productPage.firstNameGenerate());
        System.out.println(productPage.lastNameGenerate());
    }



    @Test(priority = 1)
    public void checkProductPage(){
        navigateToProductPage();
        Assert.assertEquals(productPage.getTitle(), "Swag Labs");
        productPage.clickOnAElement(productPage.react_burger_menu_btn);
        productPage.timeOut();
        Assert.assertTrue(productPage.getElement(productPage.logout_sidebar_link).isDisplayed());
        productPage.takeScreenShot("Logout_Button");
        productPage.clickOnAElement(productPage.react_burger_cross_btn);
        productPage.timeOut();

        productPage.clickOnAElement(productPage.back_pack_add_to_cart_btn);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bike_light);
        productPage.takeScreenShot("product_add_to_cart");
        productPage.timeOut();

        productPage.clickOnAElement(productPage.shopping_cart_container);
        productPage.takeScreenShot("add_to_cart_page");
        Assert.assertEquals(getDriver().getCurrentUrl(), cartPage.cart_url);
    }
}
