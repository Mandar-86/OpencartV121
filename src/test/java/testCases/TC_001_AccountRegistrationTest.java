package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration()
	{
		
		logger.info("*******starting TC001_AccountRegistrationTest*****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.myAccountClick();
		
		logger.info("Clicked on myaccount link");
		
		hp.clickRegister();
		
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage ap=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer detail..");
		ap.setFirstName(randomeString().toUpperCase());
		ap.setLastName(randomeString().toUpperCase());
		ap.setEmail(randomeString()+"@gmail.com");
		ap.setTelephone(randomeNumber());
		
		String password=randomeAlphaNmeric();
		
		ap.setPassword(password);
		ap.setConfirmPasswd(password);
		ap.setPrivacyPolicy();
		ap.clickContinue();
		
		logger.info("Validating expected message");
		
		String confirmationMsg=ap.getConfirmationMsg();
		if(confirmationMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
	//	Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!!!");
		
		}
		
		catch(Exception e)
		{
			Assert.fail(); 
		}
		
		logger.info("*******Finished TC001_AccountRegistrationTest******* ");
		
	}
	
	
}
