package com.example.KatalonAut;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Test3 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\chromed\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void test3() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");

		driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[3]/a/span")).click();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
		driver.findElement(
				By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div/div/i"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div/div/div[2]/div/div[2]/div/div[3]/div[4]/div"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/div/div/i"))
				.click();
		driver.findElement(By.xpath(
				"//div[@id='app']div//div[2]/div[2]/div/div/div[2]/form/div/div/div[2]/div/div[2]/div/div[2]/div/div[3]/div[13]/div"))
				.click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
