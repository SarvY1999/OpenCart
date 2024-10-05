package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_loginTest extends BaseClass{
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void VerifyLogin(String email, String password, String expectedResult){
        logger.info("****Starting test****");
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        MyAccountPage myAc = new MyAccountPage(driver);

        logger.info("****Clicking MyAccount****");
        hp.clickMyAccount();

        logger.info("****Click Login****");
        hp.clickLogin();

        logger.info("****Enter Email****");
        lp.setTxtEmail(email);

        logger.info("****Enter Password****");
        lp.setTxtPassword(password);

        logger.info("****Click Login Button****");
        lp.clickBtnLogin();

        boolean isMyAccPageDisplayed = myAc.verifyLoginSuccessfull();

        /*
        Data is Valid - login Successful - test pass -logout
                       - Login failed - test fail

        Data is Invalid - login Successful - test fail -logout
                       - Login failed - test pass
         */

        if(expectedResult.equals("Valid")){
            if (isMyAccPageDisplayed){
                hp.clickMyAccount();
                myAc.logout();
                Assert.assertTrue(true);
            }else {
                Assert.assertTrue(false);
            }
        }else if(expectedResult.equals("Invalid")){
            if (isMyAccPageDisplayed){
                hp.clickMyAccount();
                myAc.logout();
                Assert.assertTrue(false);
            }else {
                Assert.assertTrue(true);
            }
        }
    }
}
