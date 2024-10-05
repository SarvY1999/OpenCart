package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By lnkLogout = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']");
    By headingMyAccount = By.xpath("//div[@id='content']//h2[text()='My Account']");
    By btnContinue = By.cssSelector("a.btn-primary");

    //Action Methods
    public void logout(){
        driver.findElement(lnkLogout).click();
        driver.findElement(btnContinue).click();
    }

    public boolean verifyLoginSuccessfull(){
        try{
            boolean isVisible = driver.findElement(headingMyAccount).isDisplayed();
            return isVisible;
        }catch (Exception e){
            return false;
        }

    }

}
