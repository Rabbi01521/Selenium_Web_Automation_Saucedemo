package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String product_page_title = "Swag Labs";
    public String product_page_url = "https://www.saucedemo.com/inventory.html";
    public By  back_pack_add_to_cart_btn = By.id("add-to-cart-sauce-labs-backpack");
    public By add_to_cart_sauce_labs_bike_light = By.id("add-to-cart-sauce-labs-bike-light");
    public By add_to_cart_sauce_labs_bolt_t_shirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    public By add_to_cart_sauce_labs_onesie = By.id("add-to-cart-sauce-labs-onesie");
    public By back_pack_remove_btn = By.id("remove-sauce-labs-backpack");
    public By remove_sauce_labs_bike_light = By.id("remove-sauce-labs-bike-light");
    public By remove_sauce_labs_onesie = By.id("remove-sauce-labs-onesie");
    public By remove_sauce_labs_bolt_t_shirt = By.id("remove-sauce-labs-bolt-t-shirt");
    public By react_burger_menu_btn = By.id("react-burger-menu-btn");
    public By shopping_cart_container = By.id("shopping_cart_container");
    public By logout_sidebar_link = By.id("logout_sidebar_link");
    public By about_sidebar_link = By.id("about_sidebar_link");
    public By react_burger_cross_btn = By.id("react-burger-cross-btn");
    public By product_sort_container = By.xpath("//select[@class=\"product_sort_container\"]");
    public By item_4_title_link = By.id("item_4_title_link");
    public By item_0_title_link = By.id("item_0_title_link");

}
