package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class Pomsignin extends BaseAmazonClass {
	
	
	@FindBy(id="ap_email")
	WebElement Email;
	@FindBy(id="continue")
	WebElement Continue;
	@FindBy(id="ap_password")
	WebElement Password;
	@FindBy(id="signInSubmit")
	WebElement Signinsubmit;
	@FindBy(id="cvf-page-content")
	WebElement errormsg;
	@FindBy(partialLinkText="Hello")
	WebElement msg;
	
	public Pomsignin() {
		PageFactory.initElements(driver, this);


	}
	 
	public void enteremail(String email) {
		Email.sendKeys(email);
	}
    public void clickcontinue() {
    	Continue.click();
    }
    public void enterpassword(String password) {
    	Password.sendKeys(password);
    }
    public void signinsubmit() {
    	Signinsubmit.click();
    }
    
   
    public boolean msgs() {
     boolean a=msg.isDisplayed()|| errormsg.isDisplayed();
     return a;
    }
    }

