package pompackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class PomYourorder extends BaseAmazonClass{
     PomHomePage Home;
     Pomsignin Sign;
     PomYouraccount Youracc;
	
	@FindBy(id="a-autoid-1-announce")
	WebElement filterlist;
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div/div[3]/ul/li[2]/a")
	WebElement Buyagain;
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div/div[3]/ul/li[3]/a")
	WebElement Notyetshipped;
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div/div[3]/ul/li[4]/a")
	WebElement Cancelledorders;
	
	public PomYourorder() {
		PageFactory.initElements(driver, this);
		Home=new PomHomePage();
		Sign=new Pomsignin();
		Youracc=new PomYouraccount();	

	
	    }
	public void action() throws InterruptedException  {
		Youracc.action();
		Home.clicksignin();
		Thread.sleep(500);
		Youracc.clickyourorder();
		//
	}
	public Object[] pastorders() {
		/*
		 * Select a=new Select(filterlist); //String a1;//=a.selectByVisibleText(a1);
		 * int i; for(i=0;i<=2;i++){ if(int i==0) {
		 * 
		 * } a.selectByIndex(i); String a1=filterlist.getText() ;
		 * System.out.println(a1); }
		 */
	//	return a1;
		Select a=new Select(filterlist);
		List<WebElement> options = a.getOptions(); 
		return options.toArray();
	}
	
	public void buyagain() {
		Buyagain.click();
		}
	public void notyetshipped() {
		Notyetshipped.click();
	    }
	public void cancelledorders() {
		Cancelledorders.click();
	}
	public String verify() {
    	return driver.getTitle();
    }
}
