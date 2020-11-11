package com.in28minutes.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstSeleniumJUnitTest {

	WebDriver driver;

	@Before
	public void before() throws MalformedURLException {
		// Execute the Code

		// Download the Web Driver Executable
		// Set the path to Web Driver Executable
		//WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "D:\\OTR\\UiTestProject\\SeleniumGenerate\\chromedriver.exe");
//		driver = new ChromeDriver();

		DesiredCapabilities capability = DesiredCapabilities.chrome();
		//capability.setCapability("enableVNC", true);//{{.EnableVNC}});
		//capability.setCapability("enableVideo", true);//{{.EnableVideo}});
		boolean vncViewEnable = true; // парсим
		boolean videoRecEnable = false; // парсим
		capability.setCapability("enableVNC", true);
		capability.setCapability("enableVideo", false);
		String sauceUrl = "http://selenoid.host:4444/wd/hub";
		URL url = new URL(sauceUrl);
		driver = new RemoteWebDriver(url, capability);
//		String sessionId = ((RemoteWebDriver)driver).getSessionId().toString();
//		String text = String.format("TestId=3924001&ReportId=4924001&Data=%s&Step=SetSelenoidId",sessionId);
//		String infoUrl = String.format("http://silicabk.host:30339/qapi/setStatus?%s",text);
//		driver.get(infoUrl);
		//System.out.println(text);
	}

	@Test
	public void testGoogleDotCom() throws InterruptedException {
		driver.get("http://eb-tse-demo-ufos.otr.ru:8889/sufdclient/index.zul");
		By user = By.xpath("//input[@id='user']");
		By password = By.xpath("//input[@id='psw']");
		By buttonOk = By.xpath("//input[@id='okButton']");

		String secretPassword = "Sazonov.OI"; // парсим
		String secretLogin = "Oracle33"; // парсим
		driver.findElement(user).sendKeys(secretPassword);
		driver.findElement(password).sendKeys(secretLogin);
		driver.findElement(buttonOk).click();
		//Thread.sleep(4000);
		/**
		 * Нажать по ВебЭлементу span с переданным текстом
		 * */
		//*
		Thread.sleep(4000);
		String textTab = "Управление расходами (казначейское сопровождение)";
		By locator = By.xpath("//span[contains(.,'" + textTab + "')]");
		int seconds = 10;
		new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
		Thread.sleep(4000);
		textTab = "Справочники";
		locator = By.xpath("//span[contains(.,'" + textTab + "')]");
		new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
		Thread.sleep(4000);
		textTab = "Шаблон листа согласования";
		locator = By.xpath("//span[contains(.,'" + textTab + "')]");
		new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).click();
		Thread.sleep(4000);
		// Check the output
		// WebDriver - Title is Google
		//assertEquals(expectedTitle, actualTitle);

	}

	@Test
	@Ignore
	public void testSomeErrorScenarioCom() {

		driver.get("com");

		String actualTitle = driver.getTitle();

		String expectedTitle = "Facebook – log in or sign up";

		// Check the output
		assertEquals(expectedTitle, actualTitle);

	}

	@After
	public void after() {
		System.out.println("I'm, Executed");
		driver.quit();
	}

}

// org.openqa.selenium.WebDriverException:
// unknown error: unhandled inspector error:
// {"code":-32000,"message":"Cannot navigate to invalid URL"}
