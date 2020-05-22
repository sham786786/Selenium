import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownStatic {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(10000L);
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		
		Select adult=new Select(driver.findElement(By.cssSelector("select[id*='ctl00_mainContent_ddl_Adult']")));
		//adult.selectByIndex(1);
		//adult.selectByValue("2");
		adult.selectByVisibleText("3");
		Select child=new Select(driver.findElement(By.cssSelector("select[id*='ctl00_mainContent_ddl_Child']")));
		//adult.selectByIndex(1);
		//adult.selectByValue("2");
		child.selectByVisibleText("3");
		Select infant=new Select(driver.findElement(By.cssSelector("select[id*='ctl00_mainContent_ddl_Infant']")));
		//adult.selectByIndex(1);
		//adult.selectByValue("2");
		infant.selectByVisibleText("3");

	}

}
