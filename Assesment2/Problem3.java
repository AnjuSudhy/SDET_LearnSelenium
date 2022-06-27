package Assesment2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Problem3 {
	
	public static void main(String[] args) throws IOException,InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//1.Load the URL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		//2.search as oneplus 9 pro 
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro"+Keys.ENTER);
		
		//3.Get the price of the first product
		String price=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price is : "+ price);
		
		//4. Click the ratings and print the percentage of 5 star customer ratings for the first displayed product
		driver.findElement(By.xpath("//div[@data-index='2']//div[@class='a-section'][1]//i[contains(@class,'a-icon')]")).click();
		
		//driver.findElement(By.xpath("//div[@data-index='2']//div[@class='a-section'][1]//i/span[@class='a-icon-alt']")).click();
		Thread.sleep(3000);
		String rating=driver.findElement(By.xpath("//div[@class='a-popover-content']//tr[1]/td[3]//a")).getText();
		System.out.println("Rating is : "+ rating);
		
		//5. Click the first text link of the first image
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//h2[contains(@class,'a-size-mini')])[1]/a")).click();
		driver.findElement(By.xpath("//div[@data-index='2']//h2[contains(@class,'a-size-mini')][1]/a")).click();
		
		//6. Take a screen shot of the product displayed
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();
		//String currentTab = iterator.next();
		driver.switchTo().window(iterator.next());
		System.out.println("Opened new Tab");
		
		//File screenshot = driver.findElement(By.id("leftCol")).getScreenshotAs(OutputType.FILE);
		File screenshot = driver.findElement(By.xpath("//*[@id='imgTagWrapperId']")).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshot/s1.png");
		FileUtils.copyFile(screenshot, destination);
		
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText());

		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]/../..")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]/../..")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']/div/div")).getText());
		
	}

}
