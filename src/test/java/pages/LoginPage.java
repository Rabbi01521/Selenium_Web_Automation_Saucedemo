package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public String login_page_url = "https://www.saucedemo.com";
    public String error_msg = "Epic sadface: Username and password do not match any user in this service";
    public By username_input_field = By.id("user-name");
    public By password_input_field = By.id("password");
    public By login_button = By.id("login-button");
    public By username = By.id("login_credentials");
    public By password = By.className("login_password");
    public By error_msg_locator = By.tagName("h3");



    public String getUserName(){
        return getElementText(username);
    }

    public String getPassword(){
        return getElementText(password);
    }


}
