package com.qualitystream.tutorial;



import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
	By usernameLocator =  By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.name("confirmPassword");
	By registerBtnLocator = By.name("register");
	By singInUsertxBoxLocator = By.name("userName");
	By singInPasswordtxBoxLocator = By.name("password");
	By singInBtnLocator = By.name("login");
	By successLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
	
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(3000);
		if(driver.findElement(registerPageLocator).isDisplayed())
		{
			driver.findElement(usernameLocator).sendKeys("qualityadmin");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			driver.findElement(registerBtnLocator).click();
		}
		else {
			System.out.println("La pagina no fue encontrada");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
	    assertEquals("Note: Your user name is qualityadmin.",fonts.get(5).getText());
	    

		
			
	}
	
    @Test
    public void singIn() {
    	if(driver.findElement(singInUsertxBoxLocator).isDisplayed())
    	{
    		driver.findElement(singInUsertxBoxLocator).sendKeys("qualityadmin");
    		driver.findElement(singInPasswordtxBoxLocator).sendKeys("pass1");
    		driver.findElement(singInBtnLocator).click();
    	}
    	else
    	{
    		System.out.println("Page Not displayed, Unable to log in");
    	}
    	
    	if(driver.findElement(successLocator).isDisplayed())
    	{
    		System.out.println("Test Success");
    	}else {
    		System.out.println("Test Fail");
    	}
    }
}
