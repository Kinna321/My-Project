package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;
import utility.TimeUtils;

public class BaseAmazonClass {
	
	public static Properties prop=new Properties();
	public static WebDriver driver;

 public BaseAmazonClass(){
	try {
		FileInputStream file=new FileInputStream("C:\\Users\\kinna\\eclipse-workspace\\Amazon\\src\\test\\java\\environmentvariables\\config.properties");
	prop.load(file);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException a){
		a.printStackTrace();
	}
 }
	
 public static void initiate() {
	 String browsername=prop.getProperty("browser");
	 
	 if (browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		}
	 else if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver=new FirefoxDriver();
        }
	 driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	 driver.get(prop.getProperty("url"));
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-logo-sprites")));
}
}