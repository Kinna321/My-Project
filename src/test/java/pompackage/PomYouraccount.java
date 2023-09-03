package pompackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseAmazonClass;

public class PomYouraccount extends BaseAmazonClass {
	PomHomePage Home;
	Pomsignin Sign;
    
	
	@FindBy(id="nav-link-accountList")
	WebElement Accontlist;
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a")
	WebElement Yourorder;
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a")
	WebElement Youraddress;
	@FindBy(xpath="//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div")
	WebElement Loginsecurity;
	@FindBy(linkText="Your Payments")
    WebElement Yourpayment;
	@FindBy(xpath="//*[@id=\"nav_prefetch_yourorders\"]/span")
	WebElement Yourorder1;
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	WebElement msg;

    public PomYouraccount() {
	PageFactory.initElements(driver, this);
	Home=new PomHomePage();
	Sign=new Pomsignin();
    }
    public void clickyourorder() {
        Yourorder.click();	
    }
    public String msg() {
    	return msg.getText();
    }
    public void clickyouraddr() {
        Youraddress.click();	
    }
    public void clickloginsec() {
    	Loginsecurity.click();
    }
    public void clickyourpay() {
    	Yourpayment.click();
    }
    public String verify() {
    	return driver.getTitle();
    }
    public void action() {
    	Home.clicksignin();
    	Sign.enteremail(prop.getProperty("email"));
    	Sign.clickcontinue();
    	Sign.enterpassword(prop.getProperty("password"));
    	Sign.signinsubmit();
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));
    	
    }
    public boolean clickyurorde1() {
    	Yourorder1.click();
    	return true;
    }
}