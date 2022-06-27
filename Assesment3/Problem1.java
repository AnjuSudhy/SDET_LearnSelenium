package Assesment3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Problem1 {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger')]//*[name()='svg']")).click();
		driver.findElement(By.xpath("//span[text()='New Task']")).click();
		driver.findElement(By.xpath("//label[text()='Subject']/following::div[1]//input")).sendKeys("Bootcamp");
		driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
		driver.findElement(By.xpath("//div[@class='listContent']/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//span[text()='Status']/../..//a[text()='Not Started']")).click();
		driver.findElement(By.xpath("//a[@title='Waiting on someone else']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'bottomBarRight')]//span[text()='Save']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement temp = null;		
		temp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println(temp.getText());		
	}

}
