package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomCreateAccount extends BaseAmazonClass{
	@FindBy(id="ap_customer_name")
	WebElement Username;
		@FindBy(id="ap_email")
		WebElement Email;
		@FindBy(id="ap_password")
		WebElement Password;
		@FindBy(id="ap_password_check")
		WebElement Passwordagain;
		@FindBy(id="continue")
		WebElement continuebtn;
		
		
		//initiate elements
		public PomCreateAccount() {
			PageFactory.initElements(driver, this);
		}
		public void typeusername(String name) {
			Actions action =new Actions(driver);
			action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
			driver.findElement(By.cssSelector("#nav-flyout-ya-newCust > a")).click();
			Username.sendKeys(name);
		}
		public void typeemail(String email) {
			Email.sendKeys(email);
		}
		public void typepassword(String pass) {
			Password.sendKeys(pass);
		}
		public void typepasswordagain(String passagain){
			Passwordagain.sendKeys(passagain);
		}
		public void clickcontinue() {
			continuebtn.click();
		}
		public String verify() {
			return driver.getTitle();
			
		}


}
