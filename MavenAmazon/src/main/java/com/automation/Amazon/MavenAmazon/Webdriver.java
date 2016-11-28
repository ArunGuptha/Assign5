package com.automation.Amazon.MavenAmazon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.google.common.base.Function;


public class Webdriver {

	 private static WebDriver driver = null;
	 private static final String  URL = "https://www.facebook.com/";
	 public static WebDriver getDriver() {
			return driver;
		}

		public static void setDriver(WebDriver driver) {
			Webdriver.driver = driver;
		}

		@BeforeClass
	    public void intializeWebDriver() {
	        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	        driver = new ChromeDriver();

//	        System.setProperty("webdriver.gecko.driver", "/Users/mohammadmuntakim1/Downloads/geckodriver");
//	        driver = new FirefoxDriver();
	       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.get(URL);
	    }
		@AfterClass
	    public void tearDown() {
	        if(driver != null) {
	            driver.manage().deleteAllCookies();
	           // driver.manage().window().maximize();
	            driver.close();
	        }}

		public  void takeScreenShot() {
			try {
				File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
				String timeStamp = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss").format(Calendar.getInstance().getTime());
				FileUtils.copyFile(src, new File("./Screenshotstore/" + timeStamp + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}


