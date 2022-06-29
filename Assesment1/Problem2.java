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

public class Problem2 {
	

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
		
		//5. Click on New Party Consent
		driver.findElement(By.xpath("//div[text()='New']")).click();

		
		//6. Enter Name as 'Salesforce Automation by *Your Name*'
		WebElement temp = null;
		temp =	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@class='label inputLabel uiLabel-left form-element__label uiLabel'][1]/../input[1]"))));
		temp.sendKeys("Salesforce Automation by Anju");
		
		
		//7.Select the Individuals from the 'Party' field -
		driver.findElement(By.xpath("//input[@title='Search Individuals']")).click();
		
		//8.Create New Individual
		driver.findElement(By.xpath("//span[@title='New Individual']")).click();

		//9.Enter first and last name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Anju");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("S");
		
		//10. Click save and verify the toaster message
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")).click();
		//driver.findElement(By.xpath("//button[@title='Save']/span[contains(text(),'Save')]")).click();
		Thread.sleep(2000);
        element=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		System.out.println("First: " +element.getText());

		//11.Select Business Brand
		driver.findElement(By.xpath("//input[@title='Search Business Brands']")).click();
		
		//12.Create new Business Brand
		driver.findElement(By.xpath("//span[@title='New Business Brand']")).click();
        Thread.sleep(2000);
		
        //13.Enter the Name
        //xpath  //div[h2[text()='New Business Brand']]/following-sibling::div//label[span[text()='Name']]/following-sibling::input
		driver.findElement(By.xpath("//div[h2[text()='New Business Brand']]/following-sibling::div//label[span[text()='Name']]/following-sibling::input")).sendKeys("New_BusinessName");
        
        //14.Enter Orgid
        driver.findElement(By.xpath("//div[h2[text()='New Business Brand']]/following-sibling::div//label[span[text()='Org Id']]/following-sibling::input")).sendKeys("New_Orgid");
		
        //15.Click save and verify the Toaster message
        driver.findElement(By.xpath("//div[@class='modal-footer slds-modal__footer']//span[text()='Save']")).click();
        Thread.sleep(2000);
        element=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		System.out.println("Second: " +element.getText());
		
		
		//16.Click the consent captured contact point type as Email
		//WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
        //WebElement element = null;
        //element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='uiMenu']//a[text()='--None--']")));
        //JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath("//div[@class='uiMenu']//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Email']")).click();
		
		//17.Click save and verify Party Consent Name"
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
        element=driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]"));
		System.out.println("Third: " +element.getText());
		
		driver.close();  
	}

	

}
