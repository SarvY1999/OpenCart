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
        String randString = randomStringGeneration();
        logger.info("***Providing Details***");
        rp.setTxtFirstName(p.getProperty("Fname"));
        rp.setTxtLastName(p.getProperty("Lname"));
        rp.setTxtEmail(p.getProperty("Email")+randString+"@gmail.com");
        rp.setTxtTelephone(p.getProperty("Telephone"));
        rp.setTxtPassword(p.getProperty("Password"));
        rp.setTxtCnfPassword(p.getProperty("Password"));
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
