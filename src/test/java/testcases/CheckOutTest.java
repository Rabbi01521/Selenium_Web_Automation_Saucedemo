package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class CheckOutTest extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    public void navigateToProductPage(){
        getDriver().get(loginPage.login_page_url);
        String[] user = loginPage.getUserName().split("\n");
        String[] pass = loginPage.getPassword().split("\n");
        System.out.println( user[1] +" , "+ pass[1]);
        loginPage.writeOnElement(loginPage.username_input_field, user[1]);
        loginPage.writeOnElement(loginPage.password_input_field, pass[1]);
        loginPage.clickOnAElement(loginPage.login_button);
    }

    public void navigateToCartPage(){
        productPage.clickOnAElement(productPage.back_pack_add_to_cart_btn);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bike_light);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_onesie);
        productPage.clickOnAElement(productPage.add_to_cart_sauce_labs_bolt_t_shirt);
        productPage.clickOnAElement(productPage.shopping_cart_container);
    }

    public void navigateToCheckoutPage(){
        checkOutPage.timeOut();
        cartPage.clickOnAElement(cartPage.checkout);
    }

    @Test
    public void checkOutPageTest(){
        navigateToProductPage();
        checkOutPage.timeOut();
        navigateToCartPage();
        checkOutPage.timeOut();
        checkOutPage.scrollPageDown();
        navigateToCheckoutPage();
        checkOutPage.timeOut();
        String lastName = checkOutPage.lastNameGenerate();
        String zipCode = checkOutPage.zipCodeGenerate();
        System.out.println("FirstName" + checkOutPage.first_name);
        checkOutPage.writeOnElement(checkOutPage.first_name, checkOutPage.firstNameGenerate());
        checkOutPage.timeOut();
        checkOutPage.writeOnElement(checkOutPage.last_name, lastName);
        checkOutPage.timeOut();
        checkOutPage.writeOnElement(checkOutPage.postal_code, zipCode);
        checkOutPage.timeOut();
        checkOutPage.scrollPageDown();
        checkOutPage.timeOut();
        checkOutPage.clickOnAElement(checkOutPage.continueBtn);

        checkOutPage.timeOut();
        checkOutPage.scrollPageDown();

        checkOutPage.clickOnAElement(checkOutPage.finish);
        checkOutPage.timeOut();
        System.out.println();
        Assert.assertEquals(getDriver().getCurrentUrl(), checkOutPage.ThankYouPage);
        Assert.assertEquals(checkOutPage.getElementText(checkOutPage.thankYouText), "Thank you for your order!");
    }
}
