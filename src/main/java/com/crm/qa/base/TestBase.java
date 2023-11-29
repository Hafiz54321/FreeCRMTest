package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\rahma\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\"
					+ "qa\\config\\config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	public static void initialization() throws InterruptedException {
	String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahma\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}else if(browserName.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rahma\\eclipse-workspace\\chromedriver-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(7000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
	}
}