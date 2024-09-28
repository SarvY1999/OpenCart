package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;


public class TC_AccountRegistrationTest extends BaseClass{

    @Test
    public void verifyAccRegistration(){
        try{
        logger.info("***verifyAccRegistration***");
        HomePage hp = new HomePage(driver);

        logger.info("***Click My Account***");
        hp.clickMyAccount();

        logger.info("***Register***");
        hp.clickRegister();

        RegisterPage rp = new RegisterPage(driver);
        logger.info("***Providing Details***");
        rp.setTxtFirstName("John");
        rp.setTxtLastName("Doe");
        rp.setTxtEmail(""+randomStringGeneration()+"@gmail.com");
        rp.setTxtTelephone("1122334455");
        rp.setTxtPassword("john@123");
        rp.setTxtCnfPassword("john@123");
        rp.setChkBoxPrivacyPolicy();
        rp.clickBtnContinue();
        String cnfMsg = rp.getSuccessMsg();
        logger.info("***Assert Success message***");

        Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
        }catch (Exception e){

            logger.error("Test Failed");
//            logger.debug("Debug logs");
            Assert.fail();
        }

    }
}
