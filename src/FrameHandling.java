import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();//Launch chrome
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable");
		//Switch frame to by index
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		//switch frame to by Webelement
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame'")));
		driver.findElement(By.cssSelector("div[id='draggable']")).click();
		//Actions used to key/mouce movements
		Actions a = new Actions(driver);
		WebElement source=driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement target=driver.findElement(By.cssSelector("div[id='droppable']"));
		Thread.sleep(3000);
		a.dragAndDrop(source, target).build().perform();
		//to come back normal window - out of frame
		driver.switchTo().defaultContent();

		}

	}
