package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class Pompayment extends BaseAmazonClass{
	PomHomePage Home;
    Pomsignin Sign;
    PomYouraccount Youracc;
	
	
	@FindBy(linkText="Add a payment method")//maple-banner-modal-trigger//*[@id="pp-S3iOyq-10"]#pp-S3iOyq-10
	WebElement addpayment;
	@FindBy(xpath="//*[@id=\"pp-4JDg3w-26\"]/span/input")
	WebElement creordeb;
	@FindBy(id="pp-0JcC8m-16")
	WebElement cardno;
	@FindBy(id="pp-0JcC8m-18")
	WebElement nameoncard;
	@FindBy(xpath="//*[@id=\"pp-0JcC8m-22\"]/span/span")
	WebElement selexpdate;
	@FindBy(xpath="//*[@id=\"pp-0JcC8m-23\"]/span/span")
	WebElement selexpyear;
	@FindBy(xpath="//*[@id=\"pp-0JcC8m-26\"]/span/input")
	WebElement subdetail;
	
	
	public Pompayment() {
		PageFactory.initElements(driver, this);
		Home=new PomHomePage();
		Sign=new Pomsignin();
		Youracc=new PomYouraccount();
	}
    public void action() {
    	Youracc.action();
		Home.clicksignin();
		Youracc.clickyourpay();
    }
    public void clickaddpaymet() {
    	addpayment.click();
    }
    public void clickcredordeb() {
    	creordeb.click();
    }
    public void addcardno(String cardnum) {
    	cardno.sendKeys(cardnum);
    }
    public void addnameoncard(String cardname) {
    	nameoncard.sendKeys(cardname);
    }
    public void expdate() {
    	Select a=new Select(selexpdate);
    	a.selectByVisibleText("05");
    }
    public void expyear() {
    	Select a=new Select(selexpyear);
    	    	a.selectByVisibleText("24");
    	    }
    public void submitdetail() {
    	subdetail.click();
    }
    public String verify() {
		return driver.getTitle();
	}
}
