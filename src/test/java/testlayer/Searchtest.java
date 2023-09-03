package testlayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomHomePage;
import pompackage.Pomsearch;

public class Searchtest extends BaseAmazonClass {
	PomHomePage Home;
	Pomsearch search;

	public Searchtest() {
		super();
	}

@BeforeMethod
	public void initsetup() {
		initiate();
		Home = new PomHomePage();
		Home.typesearch(prop.getProperty("itemtosearch"));
		search = new Pomsearch();
		search.clicksearch();
	}

@Test
	public void Title() {
		String actual = search.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"Amazon.com : t-shirt for women");
	}

@Test
	public void getinfo() {
		String a = search.info();
		System.out.println(a);
	}

@Test
	public void sort()  {
		search.sorting();
	}

@Test
	public void printsearchitem() throws InterruptedException {		    
        Thread.sleep(2000);
		search.resultlist();    	
	}
@Test
public void filteration() throws InterruptedException {
	Thread.sleep(2000);
	search.selectFilter();
}
@Test
public void pagination() throws InterruptedException {
	search.nextpage();
}

@AfterMethod
	public void close() {
		driver.close();
	}
}
