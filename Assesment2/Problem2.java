package Assesment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Edit Dashboard:
===========
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the Dashboards tab 
5. Search the Dashboard 'Salesforce Automation by *Your Name*'
6. Click on the Dropdown icon and Select Edit
7. Click on the Edit Dashboard Properties icon
8. Enter Description as 'SalesForce' and click on save.
9. Click on Done and  Click on save in the popup window displayed.
10. Verify the Description.

 */
public class Problem2 {

	
    public static void main(String[] args) throws InterruptedException {  
	    
    	System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        
        //Step:1) Launch the url and Login
        driver.navigate().to("https://login.salesforce.com");  
        System.out.println(driver)  ;
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        
        //Step:2) Click on the toggle menu button from the left corner 
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = null;
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='tooltip'][contains(text(),'App Launcher')]")));
       	JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		
        
        //Step:3) Click View All and click Dashboards from App Launcher
        driver.findElement(By.xpath("//button[@aria-label='View All Applications'][contains(text(),'View All')]")).click();
        driver.findElement(By.xpath("//*[@class='searchBar']//input[@type='search']")).sendKeys("Dashboard");
        driver.findElement(By.xpath("//span/p/mark[contains(text(),'Dashboard')]")).click();
        
        
        //Step:4,5) Search the Dashboard 'Salesforce Automation by *Your Name*'
        driver.findElement(By.xpath("//div[@role='banner']//input[@placeholder='Search recent dashboards...']")).sendKeys("Anju");
		Thread.sleep(5000);
		
		//Step:6) Click on the Dropdown icon and Select Edit
     	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody['lightning-datatable_table']//td[6]//span[contains(text(),'Show actions')]")));
       	jse.executeScript("arguments[0].click()", element);
		
		System.out.println("Clicked Show Actions!!")  ;
		driver.findElement(By.xpath("//table//span[@class='slds-truncate'][contains(text(),'Edit')]")).click();
		System.out.println("Clicked Edit !!")  ;
        
		
		//Step:7) Click on the Edit Dashboard Properties icon
		//switch to frame
        WebElement frameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
        driver.switchTo().frame(frameEle);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='main']//button[@title='Edit Dashboard Properties']")).click();
       
                
        //Step:8) Enter Description as 'SalesForce' and click on save.
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("Salesforce");
		
		//Step:9) Click on Done and  Click on save in the popup window displayed.
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();	
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		//Step:10) Verify the Description.
		driver.findElement(By.xpath("//footer/button[text()='Save']")).click();
        
   }//MAin
}
