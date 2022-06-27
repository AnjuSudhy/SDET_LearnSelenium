package Assesment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Problem1 {
	
	/*
	 * Create Dashboard
***********************
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Dashboards from App Launcher
4. Click on the New Dashboard option
5. Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.
6. Click on Save and Verify Dashboard name.

	 */

public static void main(String[] args) {  
	    
    	System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Step:1) Launch the url and Login
        driver.navigate().to("https://login.salesforce.com");  
        System.out.println(driver)  ;
        driver.manage().window().maximize();
        
        //USERNAME:  //input[@id="username"]
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
        //PASSWORD:  //input[@id="password"]
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
        //input[@id="Login"]
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        
        //Step:2) Click on the toggle menu button from the left corner 
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = null;
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='tooltip'][contains(text(),'App Launcher')]")));
        //element.click();
        //WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
		
        
        //*[@role='tooltip'][contains(text(),'App Launcher')]
        //driver.findElement(By.xpath("//*[@role='tooltip'][contains(text(),'App Launcher')]")).click();
        
        //Step:3) Click View All and click Dashboards from App Launcher
        //button[@aria-label='View All Applications'][contains(text(),'View All')]
        driver.findElement(By.xpath("//button[@aria-label='View All Applications'][contains(text(),'View All')]")).click();
        
        
        //*[@class='searchBar']//input[@type='search']
        driver.findElement(By.xpath("//*[@class='searchBar']//input[@type='search']")).sendKeys("Dashboard");
        //span/p/mark[contains(text(),'Dashboard')]
        driver.findElement(By.xpath("//span/p/mark[contains(text(),'Dashboard')]")).click();
        
        //Step: 4) Click on the New Dashboard option
        //*[@id='brandBand_2']//div[@title='New Dashboard']
        driver.findElement(By.xpath("//*[@id='brandBand_2']//div[@title='New Dashboard']")).click();
        
        //iframe[@title='dashboard']
        WebElement frameEle = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
        driver.switchTo().frame(frameEle);
        
        //wait
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dashboardNameInput']")));
        element.click();
        //*[@id='dashboardNameInput']
        driver.findElement(By.xpath("//*[@id='dashboardNameInput']")).sendKeys("Salesforce Automation by Anju");
        //*[@id="dashboardDescriptionInput"]
        driver.findElement(By.xpath("//*[@id=\"dashboardDescriptionInput\"]")).sendKeys("Salesforce Automation by Anju");
        //button[@id="submitBtn"][contains(text(),'Create')]
        driver.findElement(By.xpath("//button[@id=\"submitBtn\"][contains(text(),'Create')]")).click();
        
        
        //Step:6) Click on Save and Verify Dashboard name.
        //span[contains(text(),'Salesforce Automation by Anju')]
        driver.switchTo().parentFrame(); 
        //element = wait.until(ExpectedConditions.textToBePresentInElement((WebElement) By.xpath("//span[contains(text(),'Salesforce Automation by Anju')]"),"Salesforce Automation by Anju"));
        element=driver.findElement(By.xpath(" //span[contains(text(),'Salesforce Automation by Anju')]"));
        System.out.println(element.getText());
        
        driver.close();  
        
        
      //*[@id="brandBand_2"]//a[@title='Salesforce Automation by Anju']
}//MAin
}
