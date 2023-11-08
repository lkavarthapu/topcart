package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
		public void test_loginDDT(String email, String pwd , String exp) {
			 logger.info("*****Starting TC_003_LoginDDT*****");
			try {
			 	 HomePage hp = new HomePage(driver);
			  hp.clickMyAccount();
			  logger.info("Clicked on my account");
			  hp.clickLogin();
			  logger.info("Clicked on login link");
			  LoginPage lp = new LoginPage(driver);
			  logger.info("Providing login details");
			  lp.setEmail(email); // Valid email getting from config.properties 
			  lp.setPassword(pwd); // Valid password getting from config.properties
			  lp.clickLogin();
			  logger.info("Clicked on login button");
			  MyAccountPage macc = new MyAccountPage(driver);
			  boolean targetPage = macc.isAccountPageExists();
	         if(exp.equals("Valid"))
	         {
			  if (targetPage ==true) {
	        	  macc.clickLogout();
	        	  Assert.assertTrue(true);
	          } else {
	        	  Assert.assertTrue(false);
	          }
	         }
	         if(exp.equals("inValid"))
	         {
			  if (targetPage ==true) {
	        	  macc.clickLogout();
	        	  Assert.assertTrue(false);
	          } else {
	        	  Assert.assertTrue(true);
	          }
	         }
			  
			}
			catch(Exception e) 
			{
				  Assert.fail();
			}
				logger.info("*****Finish TC_003_LoginDDT*****");
		}
}
