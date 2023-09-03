package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class PomShoppingcart extends BaseAmazonClass  {
	PomHomePage Home;
	
	
	@FindBy(xpath="//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
	WebElement proceedtocheckout;
	@FindBy(xpath="//*[@id=\"a-autoid-1-announce\"]")
	WebElement qty;
	@FindBy(id="sc-subtotal-label-buybox")
	WebElement price;
	@FindBy(xpath="//*[@id=\"sc-active-b3d9e209-a108-4576-bf44-8d25c82f1e20\"]/div[4]/div/div[3]/div[1]/span[2]/span/input")
	WebElement delete;
	@FindBy(xpath="////span[contains(@id,'sc-active-37d07622-680d-4ceb-913c-8d85945a0778')]")
	WebElement prodescri;
	@FindBy(xpath="//*[@id=\"sc-active-eeea7e79-9856-4e5a-be1d-d9e5f4c88617\"]/div[4]/div/div[1]/label/i")
	WebElement checkbox;
	@FindBy(id="native_dropdown_selected_size_name")
	WebElement size;
	@FindBy(id="add-to-cart-button")
	WebElement add2cart;
	@FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')] ")
    WebElement item1;
	@FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')] ")
    WebElement item2;
	
	
	public PomShoppingcart() {
    	PageFactory.initElements(driver, this);
    	Home=new PomHomePage();
    }
	public void checkout() {
		proceedtocheckout.click();
	}
	public void quantity() {
		qty.click();
	}
	public String subtotal() {
		return price.getText();
	}
	public void remove() {
		delete.click();
	}
	public String proinfo() {
		return prodescri.getText();
	}
	public void selectitem() {
		checkbox.click();
	}
	public String verify() {
    	return driver.getTitle();
    }
    public void selectsize() {
    	Select obj=new Select(size);
    	obj.selectByIndex(1);
    }
    public void addtocart() {
    	add2cart.click();
    }
    public void chooseitem() {
    	item1.click();
    }
    public void chooseitem2() {
    	item2.click();
    }
}
