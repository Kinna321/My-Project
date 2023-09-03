package pompackage;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;
import utility.TimeUtils;

public class Pomaddress extends BaseAmazonClass{
	PomHomePage Home;
    Pomsignin Sign;
    PomYouraccount Youracc;

	@FindBy(id="ya-myab-plus-address-icon")
	WebElement newaddress;
	@FindBy(id="address-ui-widgets-countryCode")
	WebElement Country;
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	WebElement Fullname;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	WebElement Phnumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	WebElement stradd;
	@FindBy(id="address-ui-widgets-enterAddressLine2")
	WebElement aprtnoadd;
	@FindBy(id="address-ui-widgets-enterAddressCity")
	WebElement city;
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
	WebElement province;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	WebElement postalcode;
	@FindBy(id="address-ui-widgets-use-as-my-default")
	WebElement chkboxdefadd;
	@FindBy(css="#address-ui-widgets-enterAddressFormContainer > div.a-row.a-expander-container.a-expander-inline-container.address-ui-widgets-desktop-delivery-instructions-expander > a > span > span")
	WebElement delopt;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
	WebElement subadd;
	
	
	public Pomaddress() {
		PageFactory.initElements(driver, this);
		Home=new PomHomePage();
		Sign=new Pomsignin();
		Youracc=new PomYouraccount();
	}
	public void action() {
		Youracc.action();
		Home.clicksignin();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
		Youracc.clickyouraddr();
	}
	public void clickadd() {
		newaddress.click();
	}
	public String checkcounrty() {
		return Country.getText();
	}
	public String verify() {
		return driver.getTitle();
	}
	public void addname(String Name) {
		Fullname.sendKeys(Name);
	}
	public void addphnnum(String num) {
		Phnumber.sendKeys(num);
	}
	public void addstradd(String line1) {
		stradd.sendKeys(line1);
	}
	public void addaprtno(String line2) {
		aprtnoadd.sendKeys(line2);
	}
	public void addcity(String city1) {
		city.sendKeys(city1);
	}
	public void addprovince() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	Select pro=new Select(province);
	pro.selectByIndex(11);
	}
	public void addpostcode(String code) {
		postalcode.sendKeys(code);
	}
	public void clickdefaultadd() {
		chkboxdefadd.click();
	}
	public void adddelopt() {
		delopt.click();
	}
	public void addnew() {
		subadd.click();
	}
}
