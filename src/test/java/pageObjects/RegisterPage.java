package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By txtFirstName = By.cssSelector("input#input-firstname");
    By txtLastName = By.cssSelector("input#input-lastname");
    By txtEmail = By.cssSelector("input#input-email");
    By txtTelephone = By.cssSelector("input#input-telephone");
    By txtPassword = By.cssSelector("input#input-password");
    By txtCnfPassword = By.cssSelector("input#input-confirm");
    By btnSubmit = By.cssSelector("input[type='submit']");
    By btnContinue = By.cssSelector("a.btn-primary");
    By chkBoxPrivacyPolicy = By.cssSelector("input[name='agree']");
    By msgAccCreation = By.cssSelector("div#content h1");

    //Action Methods

    public void setTxtFirstName(String txt){
        driver.findElement(txtFirstName).sendKeys(txt);
    }

    public void setTxtLastName(String txt){
        driver.findElement(txtLastName).sendKeys(txt);
    }

    public void setTxtEmail(String txt){
        driver.findElement(txtEmail).sendKeys(txt);
    }

    public void setTxtTelephone(String txt){
        driver.findElement(txtTelephone).sendKeys(txt);
    }

    public void setTxtPassword(String txt){
        driver.findElement(txtPassword).sendKeys(txt);
    }

    public void setTxtCnfPassword(String txt){
        driver.findElement(txtCnfPassword).sendKeys(txt);
    }

    public void setChkBoxPrivacyPolicy(){
        driver.findElement(chkBoxPrivacyPolicy).click();
    }

    public void clickBtnContinue(){
        driver.findElement(btnSubmit).click();
    }

    public String getSuccessMsg(){
        try {
            return driver.findElement(msgAccCreation).getText();
        }catch (Exception e){
            return (e.getMessage());
        }
    }


}
