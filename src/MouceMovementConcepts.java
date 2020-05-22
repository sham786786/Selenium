import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouceMovementConcepts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();//Launch chrome
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		Actions act=new Actions(driver);
		WebElement login=driver.findElement(By.id("ctl00_HyperLinkLogin"));

		//act.moveToElement(login).build().perform();
		//act.moveToElement(login).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.moveToElement(login).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_LEFT).build().perform();	
		driver.findElement(By.linkText("Sign up")).click();
		driver.quit();
	


	}

}
