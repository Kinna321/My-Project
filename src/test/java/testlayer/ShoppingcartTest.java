package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomHomePage;
import pompackage.PomShoppingcart;
import pompackage.Pomsearch;

public class ShoppingcartTest extends BaseAmazonClass {

	PomHomePage Home;
	Pomsearch search;
	PomShoppingcart shopcart;
	public ShoppingcartTest() {
		super();
	}
@BeforeMethod
	public void initsetup() throws InterruptedException{
	initiate();
	Home=new PomHomePage();
	Home.typesearch("t shirt");
	search=new Pomsearch();
	search.clicksearch();
	shopcart=new PomShoppingcart();
	Thread.sleep(5000);
	shopcart.chooseitem();
	Thread.sleep(5000);
	shopcart.selectsize();
	Thread.sleep(2000);
	shopcart.addtocart();
	driver.navigate().back();
	driver.navigate().back();
	Thread.sleep(10000);
	shopcart.chooseitem2();
	Thread.sleep(2000);
	shopcart.selectsize();
	Thread.sleep(2000);
	shopcart.addtocart();
	Home.clickcart();
	
	}	
@Test
    public void checkselect() throws InterruptedException {
	Thread.sleep(1000);
	shopcart.selectitem();
}
@Test
    public void removeitem() {
	shopcart.remove();
}
@AfterMethod
   public void close() {
   driver.close();
}
}
