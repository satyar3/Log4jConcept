package com.qa.log4j.concept;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


class Log4JConcept {
	
	//What is log ?
	//A- Capturing the activities of the application in each and every step
	
	//Type of logs: info, error, fatal, warn

	//How to generate logs : useing log4j API
	//How it works ? it reads log4j configuration from log4j.properties file
	//Where to create - create inside the resources folder
	
	WebDriver driver;
	Logger log = Logger.getLogger(Log4JConcept.class);
	
	@BeforeMethod
	public void setUp()
	{
		log.info("***************Set up processed started");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		 options.setExperimentalOption("useAutomationExtension", false);
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 log.info("***************Set up processed ended");
		 
		 driver.get("https://www.google.com");
		 log.info("***************Chrome launched");
	}
	
	@Test
	public void log4jTest()
	{
		System.out.println(driver.getTitle());
		log.info("Title fetched");
		
		log.info("***************Now tesing the log methods");

		log.warn("warning message");
		log.error("error message");
		log.fatal("fatal message");
		log.debug("debug message");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
