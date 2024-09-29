package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC_loginTest extends BaseClass{
    @Test
    public void VerifyLogin(){
        logger.info("****Starting test****");
        HomePage hp = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);

        logger.info("****Clicking MyAccount****");
        hp.clickMyAccount();

        logger.info("****Click Login****");
        hp.clickLogin();

        logger.info("****Enter Email****");
        lp.setTxtEmail("ABC");

        logger.info("****Enter Password****");
        lp.setTxtPassword("Password");

        logger.info("****Click Login Button****");
        lp.clickBtnLogin();

    }
}
