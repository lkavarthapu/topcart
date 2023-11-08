package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		}
	//Elements
		@FindBy(name="firstname") 
		WebElement txtFirstname;
		@FindBy(name="lastname") 
		WebElement txtLastname;
		@FindBy(name="email") 
		WebElement txtEmail;
		@FindBy(name="password") 
		WebElement txtPassword;
		
		@FindBy(name = "agree")
		WebElement chkdPolicy;
		
		
		@FindBy(xpath="//button[normalize-space()='Continue']") 
		WebElement btnContinue;
		
		
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
		WebElement msgConfirmation;
		
		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);
		}
		public void setLastName(String lname) {
			txtLastname.sendKeys(lname);
		}
		public void setEmail(String email) {
			txtEmail.sendKeys(email);
		}
		public void setPassword(String pass) {
			txtPassword.sendKeys(pass);
		}
		
		public void setPrivacyPolicy(){
			try {
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", chkdPolicy);
				
				
				//chkdPolicy.click();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			

		}

		public void ClickContinue() {
			btnContinue.submit();
		}
		public String getConfirmationMsg() {
			try {
				  System.out.println(msgConfirmation.getText());
				return(msgConfirmation.getText());
			}catch (Exception e) {
				return(e.getMessage());
			}
		}
  
}
