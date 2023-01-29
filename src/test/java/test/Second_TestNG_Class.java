package test;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Second_TestNG_Class {
	public static WebDriver driver;
  @Test
  public void function() {
	  
	  String url = "http://adactinhotelapp.com";
		driver.get(url);
		
		//Find the user name element
		WebElement uName = driver.findElement(By.id("username"));  
		//Enter user name
		uName.sendKeys("santosh13");
				
		//find the password element and enter the password directly
		driver.findElement(By.id("password")).sendKeys("Snoopy1234");
		
		//Click on the login button link by tag and class and 'value' attribute
		driver.findElement(By.cssSelector("input.login_button[value=Login]")).click();

		//Drop down  to select LOCATION
		new Select(driver.findElement(By.className("search_combobox"))).selectByValue("Sydney");
		
      //Drop down to select HOTELS
		new Select(driver.findElement(By.cssSelector("#hotels.search_combobox"))).selectByValue("Hotel Sunshine");

		//Drop down to select ROOMTYPE
		new Select(driver.findElement(By.cssSelector("select[name=room_type]"))).selectByValue("Double");
		
		//Drop down to select Number of Rooms
		 new Select(driver.findElement(By.id("room_nos"))).selectByValue("2");
		 
		 //Date picker-Enter checkin date
		 WebElement checkinDate = driver.findElement(By.id("datepick_in"));
		 checkinDate.clear();
		 checkinDate.sendKeys("24/12/2022");
		 
		 //Date picker-Enter checkout date
		 WebElement checkoutDate = driver.findElement(By.id("datepick_out"));
		 checkoutDate.clear();
		 checkoutDate.sendKeys("27/12/2022");
       
		 //Select Adults per room
		 new Select(driver.findElement(By.id("adult_room"))).selectByValue("2");
		 
		 //Select Child per room
		 new Select(driver.findElement(By.id("child_room"))).selectByValue("1");
		 
		//Click on Search
		driver.findElement(By.id("Submit")).click();
		
		//Radio button on next page to choose the option to book
		driver.findElement(By.id("radiobutton_0")).click();
		
		//Click on 'Continue' option
		driver.findElement(By.id("continue")).click();
		
		//On the next page enter the personal details
		//First name
		driver.findElement(By.id("first_name")).sendKeys("Thamarakshan");

		//Last name
		driver.findElement(By.id("last_name")).sendKeys("Pillai");
		
		//Address
		driver.findElement(By.id("address")).sendKeys("Palarivattom, Kochi");
		
		//Credit Card Number
		driver.findElement(By.id("cc_num")).sendKeys("1111222233334444");
		
		//Credit Card Type
		 new Select(driver.findElement(By.id("cc_type"))).selectByValue("VISA");
		 
		 //Expiry Month
		 new Select(driver.findElement(By.id("cc_exp_month"))).selectByValue("2");

		 //Expiry Year
		 new Select(driver.findElement(By.id("cc_exp_year"))).selectByValue("2022");

		//CVV number
		 driver.findElement(By.id("cc_cvv")).sendKeys("123");

		 //Click on Book Now
		 driver.findElement(By.id("book_now")).click();

		 /*try {
	            Thread.sleep(5000); //Wait till the booking is complete
	            }
	            catch (Exception e) {
	                
	            }*/
		 
		 //Better option than thread
		 //Wait
		 
		 //Implicit wait
		//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 //Wait for a max of 5 seconds but if element is found before that, it will proceed with execution
		 //other options for implicitlyWait- pageLoadTimeout(),scriptTimeout()
		 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		 
		//Fluent wait
       Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(30)) //wait for 30 sec max
               .pollingEvery(Duration.ofSeconds(2)) //checks element every 2 sec
               .ignoring(NoSuchElementException.class); //ignore no such element exception if element not found during polling



      WebElement itButton = fluentWait.until(ExpectedConditions.visibilityOfElementLocated
               (By.id("my_itinerary")));
      
        itButton.click();
		 
		 //On the next page click on 'My itinerary' button to see the bookings
		 //driver.findElement(By.id("my_itinerary")).click();

       //Explicit wait
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 
		 WebElement logout_button = 
				 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout.reg_button")));
		        //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout.reg_button"))
			 
		 //Click on logout
		 logout_button.click();
         
       /* try {
	            Thread.sleep(3000); //Wait to logout from the page
	            }
	            catch (Exception e) {
	                
	            }*/
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
		driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
