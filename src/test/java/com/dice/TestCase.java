package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/ivka/Documents/selenium dependencies/drivers/chromedriver");
		// WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://dice.com");
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys("SDET");
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("Washington,DC");
		driver.findElement(By.id("findTechJobs")).click();

		 String count = driver.findElement(By.id("posiCountMobileId")).getText();
		 System.out.println(count);
		// int i = Integer.parseInt(count);
		// if (i > 0) {
		// System.out.println("This search returned " + i + "in Washington,DC");

		// }else
		// System.out.println("This search returned " + i + "in Washington,DC");

		String title = driver.getTitle();
		System.out.println(title);

		String expected = "24 SDET jobs in Washington,DC | Dice.com";
		if (title.equals(expected)) {
			System.out.println("SECCESS");

		} else
			System.out.println("FAIL");
		// throw new RuntimeException();
		driver.quit();
	}

}
