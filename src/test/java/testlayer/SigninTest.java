package testlayer;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomHomePage;
import pompackage.Pomsignin;
import testdata.Excelsheet;
import utility.TimeUtils;

public class SigninTest extends BaseAmazonClass {
	PomHomePage Home;
	Pomsignin Sign;
	public SigninTest() {
		super();
	}
@BeforeMethod
	public void initsetup() {
	initiate();
	Home=new PomHomePage();
	Home.clicksignin();
	Sign=new Pomsignin();
	
}
@Test (priority=1)
    public void Title() {
	String actual=Home.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"Amazon Sign-In");
}
@DataProvider
public Object[][] Details(){
	Object result[][]=Excelsheet.readdata("Sheet1");
	return result;
}


@Test(priority=2, dataProvider="Details")
    public void typepassword(String email,String password) throws InterruptedException {
	Sign.enteremail(email);
	Sign.clickcontinue();
	Sign.enterpassword(password);
	Sign.signinsubmit();

	Thread.sleep(2000);
	if(Sign.msgs()) {
	Assert.assertEquals(true,Sign.msgs());
	}
	else {
		System.out.println("error msg");
	}
}
@AfterMethod
    public void close() {
	driver.close();
}
}
