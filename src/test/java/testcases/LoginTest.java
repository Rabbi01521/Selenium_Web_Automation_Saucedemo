package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class LoginTest extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Test(priority = 1)
    public void testLoginWithValidCredentials(){
        getDriver().get(loginPage.login_page_url);
        String[] user = loginPage.getUserName().split("\n");
        String[] pass = loginPage.getPassword().split("\n");
        System.out.println( user[1] +" , "+ pass[1]);
        loginPage.writeOnElement(loginPage.username_input_field, user[1]);
        loginPage.writeOnElement(loginPage.password_input_field, pass[1]);
        loginPage.clickOnAElement(loginPage.login_button);
        loginPage.takeScreenShot("login_with_valid_Screenshot");
        Assert.assertEquals(getDriver().getCurrentUrl(), productPage.product_page_url);
    }

    @Test(priority = 0, dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithInvalidCredential(String username, String password){
        getDriver().get(loginPage.login_page_url);
        loginPage.writeOnElement(loginPage.username_input_field, username);
        loginPage.writeOnElement(loginPage.password_input_field, password);
        loginPage.clickOnAElement(loginPage.login_button);
        loginPage.takeScreenShot("login_with_invalid_Screenshot");
        Assert.assertEquals(loginPage.getElementText(loginPage.error_msg_locator), loginPage.error_msg);
    }

}
