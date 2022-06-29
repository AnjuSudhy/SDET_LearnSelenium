package Assesment1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Problem1 {
	
	public static void main(String[] args) {  
	    
    	System.setProperty("webdriver.chrome.driver", "C:\\Backup\\2)Work\\Deck\\SDET_Training\\Selenium_practise\\INSTALLERS\\ChromeDriver\\chromedriver.exe");    
        WebDriver driver=new ChromeDriver();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        //Step:1) Launch the url https://www.redbus.in/
        driver.navigate().to("https://www.redbus.in/");  
        System.out.println(driver)  ;
        driver.manage().window().maximize();  
        
        //Step:2) Enter From -Madiwala Bangalore
        driver.findElement(By.xpath("//*[@id=\"search\"]//*[@id=\"src\"]")).sendKeys("Madiwala, Bangalore");
        driver.findElement(By.xpath("//ul[contains(@class,'autoFill')]//*[@select-id=\"results[0]\"]"));
        String src=driver.findElement(By.xpath("//*[@id=\"search\"]//*[@id=\"src\"]")).getText();
        System.out.println(src)  ;
        
        //Step:3) Enter To Koyambedu Chennai
        driver.findElement(By.xpath("//*[@id=\"search\"]//*[@id=\"dest\"]")).sendKeys("Koyambedu, Chennai");
        driver.findElement(By.xpath("//ul[contains(@class,'autoFill')]/li[1]"));
        String dest=driver.findElement(By.xpath("//*[@id='search']//*[@id='dest']")).getText();
        System.out.println(dest)  ;
        
        //Step:4) Select the Date 10-Jun-2022  //*[@id="search"]//*[@id="onward_cal"]
        driver.findElement(By.xpath("//*[@id='search']//*[@id='onward_cal']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table//td[@class='current day']")).click();
        
        //Step:5) Click Search buses
        driver.findElement(By.xpath("//*[@id='search']//*[@id='search_btn']")).click();
        System.out.println("Searching Bus");
        //Step:6) Click After 6pm under Departure time ------ //input[@id="dtAfter 6 pm"]
        
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement depTimeFilter = null;
		//depTimeFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dtAfter 6 pm']")));
		depTimeFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='dtAfter 6 pm'][@class='custom-checkbox']")));
		depTimeFilter.click();
		System.out.println("Selected After 6 pm bus");
        //driver.findElement(By.xpath("//input[@id='dtAfter 6 pm']")).click();
        
        //Step:8) Select the Primo   -----//*[@id="filter-block"]//*[contains(text(),'Primo Bus')]
        driver.findElement(By.xpath("//*[@id='filter-block']//*[contains(text(),'Primo Bus')]")).click();
        System.out.println("Selected Primo bus");
        
        //Step:9) Get the number of buses found ---//*[contains(@class,'f-bold busFound')]
        WebElement text =driver.findElement(By.xpath("//*[contains(@class,'f-bold busFound')]"));
        System.out.println("Number of Buses : "+text.getText());
        
        //Step:10) Get the Bus fare and sort them in ascending order
        driver.findElement(By.xpath("//a[text()='Fare']")).click();
        System.out.println("Fare of Buses : ");
        List<WebElement> busFares = driver.findElements(By.xpath("//ul[@class='bus-items']//div[@class='seat-fare ']//span"));
		for(WebElement bus_fare: busFares) {
			System.out.println(bus_fare.getText());
		}
		
        //Step:11) Close the application
        driver.close();  
             
  
    } //main 

}
