package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	//https://demo.opencart.com/
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	

@FindBy(id="input-firstname")
WebElement firstname;

@FindBy(id="input-lastname")
WebElement lastname;

@FindBy(id="input-email")
WebElement txtemail;

@FindBy(id="input-telephone")
WebElement txtTelephone;

@FindBy(id="input-password")
WebElement password;

@FindBy(id="input-confirm")
WebElement confirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnClick;

@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname)
{
	firstname.sendKeys(fname);
}

public void setLastName(String lname)
{
	lastname.sendKeys(lname);
}

public void setEmail(String email)
{
	txtemail.sendKeys(email);
}

public void setTelephone(String telephone)
{
	txtTelephone.sendKeys(telephone);	
}

public void setPassword(String pwd)
{
	password.sendKeys(pwd);
}

public void setConfirmPasswd(String cnfpwd)
{

	confirmpassword.sendKeys(cnfpwd);
}

public void setPrivacyPolicy()
{
	chkPolicy.click();
}

public void clickContinue()
{
	//btnClick.click();
	Actions act=new Actions(driver);
	act.moveToElement(btnClick).click().build().perform();
	
}

public String getConfirmationMsg()
{

	try
	{
		return msgConfirmation.getText();
	}
	catch(Exception e)
	{
		return (e.getMessage());
	}
}



}
