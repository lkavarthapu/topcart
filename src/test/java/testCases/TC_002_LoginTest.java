package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void test_login() {
	  try {
		logger.info("*****Starting TC_002_LoginTest*****");
	  HomePage hp = new HomePage(driver);
	  hp.clickMyAccount();
	  logger.info("Clicked on my account");
	  hp.clickLogin();
	  logger.info("Clicked on login link");
	  LoginPage lp = new LoginPage(driver);
	  logger.info("Providing login details");
	  lp.setEmail(rb.getString("email")); // Valid email getting from config.properties 
	  lp.setPassword(rb.getString("password")); // Valid password getting from config.properties
	  lp.clickLogin();
	  logger.info("Clicked on login button");
	  MyAccountPage macc = new MyAccountPage(driver);
	  boolean targetPage = macc.isAccountPageExists();
	  Assert.assertEquals(targetPage,true,"Invalid Data ");
	  }
	  catch(Exception e) {
		  Assert.fail();
	  }
		logger.info("*****Finish TC_002_LoginTest*****");
	}
}
