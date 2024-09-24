package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;


public class TC_AccountRegistrationTest extends BaseClass{

    @Test
    public void verifyAccRegistration(){
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        RegisterPage rp = new RegisterPage(driver);
        rp.setTxtFirstName("John");
        rp.setTxtLastName("Doe");
        rp.setTxtEmail(""+randomStringGeneration()+"@gmail.com");
        rp.setTxtTelephone("1122334455");
        rp.setTxtPassword("john@123");
        rp.setTxtCnfPassword("john@123");
        rp.setChkBoxPrivacyPolicy();
        rp.clickBtnContinue();
        String cnfMsg = rp.getSuccessMsg();
        Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
    }
}
