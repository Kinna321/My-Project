package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomYouraccount;
import pompackage.PomYourorder;
import pompackage.Pomsignin;

public class YourorderTest extends BaseAmazonClass{
	Pomsignin Sign;
	PomYouraccount Youracc;
	PomYourorder Yourord;
	public YourorderTest() {
		super();
	}
@BeforeMethod
	public void initsetup() throws InterruptedException {
	initiate();
	Sign=new Pomsignin();
	Youracc=new PomYouraccount();	
	Yourord=new PomYourorder();
	Yourord.action();
}
@Test
    public void verify() {
	String actual=Yourord.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"Your Orders");
}
@Test
    public void pastorders() {
	Yourord.pastorders();
	//System.out.println(actual);
}
@Test 
    public void buyagn(){
	Yourord.buyagain();
}
@Test
    public void notytshipd() {
	Yourord.notyetshipped();
}
@Test
    public void cnlord() {
	Yourord.cancelledorders();
}
@AfterMethod
    public void close() {
    driver.close();
}	
	
	
}
	
	
