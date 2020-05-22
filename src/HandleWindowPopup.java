import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();// Launch chrome
		driver.get("http://www.popuptest.com/goodpopups.html");

		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all the cookies
		// dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Base window id: " + driver.getTitle());

		driver.findElement(By.linkText("Good PopUp #1")).click();

		// Set
		Set<String> winHandler = driver.getWindowHandles();
		// Iterate the windows
		Iterator<String> iterator = winHandler.iterator();
		String parentid = iterator.next();
		String childid = iterator.next();

		driver.switchTo().window(childid);
		System.out.println("Child windows id: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(parentid);
		System.out.println("Parent windows id: " + driver.getTitle());
		driver.quit();

	}

}
