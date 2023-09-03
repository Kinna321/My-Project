package testlayer;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomYouraccount;
import pompackage.Pomaddress;
import pompackage.Pomsignin;
import testdata.Excelsheet;
import utility.TimeUtils;

public class AddaddressTest extends BaseAmazonClass {
	Pomsignin Sign;
	PomYouraccount Youracc;
	Pomaddress Youradd;
	public AddaddressTest() {
		super();
	}
@BeforeMethod
	public void initsetup(){
	initiate();
	Sign=new Pomsignin();
	Youracc=new PomYouraccount();	
	Youradd=new Pomaddress();
	Youradd.action();
}
@Test
    public void verify() {
	String actual=Youradd.verify();
	System.out.println(actual);

}
@Test
    public void addwindow() {
	Youradd.clickadd();
	String actual=Youradd.verify();
	System.out.println(actual);
}
@Test
    public void autoselectcountry() {
	Youradd.clickadd();
	String b=Youradd.checkcounrty();
	System.out.println(b);
}
@DataProvider
public Object[][] Details(){
	Object result[][]=Excelsheet.readdata("Sheet2");
	return result;
}
@Test(dataProvider="Details")
    public void typeadd(String name,String num,String add1,String add2,String apt,String city,String pcode) {
	Youradd.clickadd();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	Youradd.addname(name);
	Youradd.addphnnum(num);
	Youradd.addstradd(add1);
	Youradd.addaprtno(add2);
	Youradd.addcity(city);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	Youradd.addprovince();
	Youradd.addpostcode(pcode);
	Youradd.clickdefaultadd();
	Youradd.adddelopt();
	Youradd.addnew();	
}
@AfterMethod
    public void close() {
    driver.close();
}

}