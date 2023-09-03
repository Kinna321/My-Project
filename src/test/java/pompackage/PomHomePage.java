package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomHomePage extends BaseAmazonClass {

	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement Signin;
	@FindBy(id="twotabsearchtextbox")
	WebElement Searchbox;
	@FindBy(id="nav-cart-count-container")
	WebElement Cart;

     //initiate element
    public PomHomePage() {
    	PageFactory.initElements(driver, this);
    }
    public void clicksignin() {
    	Signin.click();
    }
    public void typesearch(String search) {
    	Searchbox.sendKeys(search);
    }
    public void clickcart() {
    	Cart.click();
    }
    public String verify() {
    	return driver.getTitle();
    }
    }