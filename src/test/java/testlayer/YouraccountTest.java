package testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomYouraccount;
import pompackage.Pomsignin;

public class YouraccountTest extends BaseAmazonClass  {
	Pomsignin Sign;
	PomYouraccount Youracc;
	public YouraccountTest() {
		super();
	}
@BeforeMethod
	public void initsetup() {
	initiate();
	Sign=new Pomsignin();
	Youracc=new PomYouraccount();	
	Youracc.action();
}
@Test
    public void Title() throws InterruptedException {
	Thread.sleep(2000);
	String actual=Youracc.msg();
	System.out.println(actual);
	
}
@Test
    public void mousefun() {
	Actions action1=new Actions(driver);
	action1.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	boolean a=Youracc.clickyurorde1();
	Assert.assertEquals(true, a);
}
@AfterMethod
    public void close() {
	driver.close();
}
}
