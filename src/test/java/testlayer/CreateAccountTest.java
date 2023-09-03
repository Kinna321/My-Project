package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomCreateAccount;
import testdata.Excelsheet;

public class CreateAccountTest extends BaseAmazonClass{
	PomCreateAccount Log;
	public CreateAccountTest() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		
		Log=new PomCreateAccount();
	}
@Test(priority=1)
public void Title() {
	String actual=Log.verify();
	System.out.println(actual);
	Assert.assertEquals(actual,"Amazon.com. Spend less. Smile more.");
}

@DataProvider
public Object[][] Details(){
	Object result[][]=Excelsheet.readdata("Sheet3");
	return result;
}
@Test(priority=2, dataProvider="Details")
public void Login(String name,String email,String password,String passwordagain) throws InterruptedException {
	
Log.typeusername(name);
Thread.sleep(500);
Log.typeemail(email);
Thread.sleep(500);
Log.typepassword(password);
Thread.sleep(500);
Log.typepasswordagain(passwordagain);
//Thread.sleep(500);
//Log.clickcontinue();
}

@AfterMethod
public void close() {
	driver.close();

}
}