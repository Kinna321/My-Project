package pompackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class Pomsearch extends BaseAmazonClass{
	PomHomePage Home;
    @FindBy(id="nav-search-submit-button")
    WebElement Searchbutton;
    @FindBy(id="nav-flyout-searchAjax")
    WebElement searchcontainer;
    @FindBy(id="s-result-sort-select")
    WebElement sortby;
    @FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')] ")
    WebElement prodinfo;
    
   
    @FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')] ")
    List<WebElement> productItemList;
	@FindBy(xpath="//a[contains(@class,'a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal')")
	List<WebElement> filtering;
	@FindBy(xpath="//span[@class='a-list-item']//child::a[1]")
    List<WebElement> filtername;
	@FindBy(xpath="//a[contains(@class,'s-pagination-item s-pagination-next s-pagination-button s-pagination-separator')]")
	WebElement nextpage;
	
	public Pomsearch() {
    	PageFactory.initElements(driver, this);
    	Home=new PomHomePage();
    }
	public void clicksearch() {
		Searchbutton.click();
	}
	
	public void sorting() {
		Select obj=new Select(sortby);
		  for (int i=0;i<=3;i++) {
		  obj.selectByIndex(i);
		    }
		  System.out.println(sortby.getText());
	} 
		  
	public void resultlist() {
		List<WebElement> linklist = productItemList;
		System.out.println("Size of links and images...."+linklist.size());
		
		for(int i=0;i<linklist.size();i++){
		   if(linklist.get(i).getAttribute("href")!=null) {
					 linklist.get(i);  
		   }}
		System.out.println("list of active link.."+linklist.size());
		for(int j=0;j<linklist.size();j++) {
			System.out.println(linklist.get(j).getText());
		}
	
	}
	String filname;int i;
	public void selectFilter() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> filters=filtername;
		for (int i=0;i<filters.size();i++) {
			filname=filters.get(i).getText();
			//WebElement abc =filters.get(i);
		
			System.out.println(filname);
			if(i==16) {
				WebElement abc=filters.get(i);
				abc.click();
				Thread.sleep(2000);
				List<WebElement> fin=productItemList;
				Thread.sleep(2000);
				System.out.println(fin.size());
		}}
		
	    }
	
	public void nextpage() throws InterruptedException {
		List<WebElement> linklist = productItemList;
		nextpage.click();
		Thread.sleep(2000);
		List<WebElement> nextlinklist = productItemList;
		for(int i=0;i<linklist.size();i++) {
			for(int j=0;j<linklist.size();j++) {
				if(linklist.get(i).getAttribute("href")==nextlinklist.get(j).getAttribute("href")) {
					System.out.println("duplicate item");
				}
				else {
					System.out.println("no duplicate item");
				}
			}
		}
	}
	 public String verify() {
	    	return driver.getTitle();
	 }
	 public String info() {
		 return prodinfo.getText();
	 }
	 
}
