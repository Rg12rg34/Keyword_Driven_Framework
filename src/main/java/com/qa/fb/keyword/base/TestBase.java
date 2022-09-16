package com.qa.fb.keyword.base;

import com.qa.fb.keyword.util.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public Properties prop;

//	public WebDriver init_driver(String browserName){
//
//		if(browserName.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//			if(prop.getProperty("headless").equalsIgnoreCase("yes")){
//				//headless mode
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless");
//				driver = new ChromeDriver(options);
//			}else{
//				driver = new ChromeDriver();
//			}
//		}
//
//		return driver;
//
//	}

    public WebDriver init_driver(String browserName)  {
        if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","C:/Users/Rahul/OneDrive/Desktop/selenium/geckodriver.exe");
            //driver = new FirefoxDriver();
            if(prop.getProperty("headless").equals("yes")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver= new FirefoxDriver(options);
            }else {
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(utility.PAGE_LOAD_TIME, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(utility.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

    public Properties init_Properties(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:/Users/Rahul/IdeaProjects/Keyword_Driven_Framework/src/main/java/com/qa/fb/keyword/config/Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
