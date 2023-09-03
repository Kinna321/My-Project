package testlayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomYouraccount;
import pompackage.Pompayment;
import pompackage.Pomsignin;
import utility.TimeUtils;

public class PaymethodTest extends BaseAmazonClass {
	Pomsignin Sign;
	PomYouraccount Youracc;
	Pompayment paymethod;
	
	public PaymethodTest() {
		super();
	}
@BeforeMethod
	public void initsetup(){
	initiate();
	Sign=new Pomsignin();
	Youracc=new PomYouraccount();	
	paymethod=new Pompayment();
	paymethod.action();
}
@Test
    public void verify() {
	String actual=paymethod.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"Your Payments");
}
@Test
    public void adddetail() throws InterruptedException {
	Thread.sleep(5000);///driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	paymethod.clickaddpaymet();
	paymethod.clickcredordeb();
	paymethod.addcardno("5123456789012346");
	paymethod.addnameoncard("abcd");
	paymethod.expdate();
	paymethod.expyear();
	paymethod.submitdetail();
}
@AfterMethod
    public void close() {
    driver.close();
}
}
