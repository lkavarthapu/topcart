package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_Account_Registration extends BaseClass {
	@Test(groups= {"Regression","Master"})
	  public void test_account_Registration()throws InterruptedException
	  {
		  
		  logger.debug("Application logs..................");
		  logger.info("Starting TC_001_account_Registration TEST.... ");
		  try 
		  {
		  HomePage hp =new HomePage(driver);
		  hp.clickMyAccount();
		  logger.info("registration link clicked.... ");
		  hp.clickRegister();
		  AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		  regpage.setFirstName(randomeString().toUpperCase());
		  regpage.setLastName(randomeString().toUpperCase());
		 regpage.setEmail(randomeString()+"@gmail.com");
		  regpage.setPassword(randomAlphaNumeric());
		  logger.info("public policy start.... ");
		  Thread.sleep(3000);
		   regpage.setPrivacyPolicy();
		  logger.info("public policy end.... ");
		  regpage.ClickContinue();
		  logger.info("clicked on continue.... ");
		  String confmsg = regpage.getConfirmationMsg();
		 logger.info("verifying message.... ");
		  Assert.assertEquals(confmsg,"Your Account Has Been Created!", "Test Failed no match");
		  } catch(Exception e) {
			        //  logger.error("Test Failed");
			  		  Assert.fail();
		  }
			  logger.info("Finished  TC_001_account_Registration TEST.... ");
	  }
		
}
