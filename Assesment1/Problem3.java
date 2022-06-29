package Assesment1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Problem3 {
	
	
public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        
        
        //Step:1) Launch the url and Login
        driver.navigate().to("https://login.salesforce.com");  
        System.out.println(driver)  ;
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

        //2. Click on the toggle menu button from the left corner
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
        WebElement element = null;
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='tooltip'][contains(text(),'App Launcher')]")));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		
        //3. Click View All and click Party Consent from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement partyConButton =driver.findElement(By.xpath("//p[text()='Party Consent']"));
		jse.executeScript("arguments[0].scrollIntoView(true);", partyConButton);
		partyConButton.click();

        //5. Search Name as 'Salesforce Automation by *Your Name*'
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Anju"+Keys.ENTER);
		
		//6.Click on the Dropdown icon and Select Delete
		//driver.findElement(By.xpath("//div[@class='uiMenu']//a[@role='button']//span[text()='Show more actions']")).click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@role='button']//span[text()='Show Actions']")));
       	jse.executeScript("arguments[0].click()", element);
		//driver.findElement(By.xpath("//a[@role='button']//span[text()='Show Actions']")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		
		//7.Click on the Delete option in the displayed popup window.
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		Thread.sleep(3000);
        element=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		System.out.println("Deleted Message: " +element.getText());
		
		Thread.sleep(2000);
		element=driver.findElement(By.xpath("//div[contains(@class,'emptyContentInner')]//span"));
		System.out.println(element.getText());
		

  }//main
}
