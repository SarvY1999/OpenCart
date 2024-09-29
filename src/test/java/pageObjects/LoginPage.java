package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By txtEmail = By.cssSelector("input#input-email");
    By txtPassword = By.cssSelector("input#input-password");
    By btnLogin = By.cssSelector("input[value='Login']");

    // methods
    public void setTxtEmail(String txt){
       driver.findElement(txtEmail).sendKeys(txt);
    }

    public void setTxtPassword(String password){
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void clickBtnLogin(){
        driver.findElement(btnLogin).click();
    }
}
