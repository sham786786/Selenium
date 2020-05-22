import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();//Launch chrome
		driver.get("http://jqueryui.com/droppable/");
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.findElements(By.tagName("iFrame")).size());//only 1 frame
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		
		 WebElement source=driver.findElement(By.id("draggable")); 
	     WebElement target=driver.findElement(By.id("droppable")); 
	     //action.dragAndDrop(source,target).build().perform();
		 
		action.clickAndHold(source)
		.moveToElement(target)
		.release()
		.build()
		.perform();
		
	}

}
