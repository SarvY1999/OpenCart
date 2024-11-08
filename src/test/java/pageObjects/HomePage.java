package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver); // initialising Base Class Constructor
    }

    // Locators
    By lnkMyAccount = By.cssSelector("li.dropdown span.hidden-sm");
    By lnkRegister = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']");
    By lnkLogin = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']");
    By lnkShoppingCart = By.xpath("//a[@title='Shopping Cart']");

    // Action Method
    public void clickMyAccount(){
        driver.findElement(lnkMyAccount).click();
    }

    public void clickRegister(){
        driver.findElement(lnkRegister).click();
    }

    public void clickLogin(){
        driver.findElement(lnkLogin).click();
    }

    public void clickShoppingCart(){
        driver.findElement(lnkShoppingCart).click();
    }
}
