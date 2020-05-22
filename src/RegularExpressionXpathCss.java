import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionXpathCss {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com/");
		// xpath with regular expression
		driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("shameer"); //// *[@id="login1"]
		driver.findElement(By.xpath("//input[contains(@id,'passw')]")).sendKeys("787878");
		driver.findElement(By.xpath("//input[contains(@title,'Sign ')]")).click();

		// css with regular expression
		/*
		 * driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		 * driver.findElement(By.cssSelector("input[id*='login']")).sendKeys("shameer");
		 * ////*[@id="login1"]
		 * driver.findElement(By.cssSelector("input[id*='passw']")).sendKeys("787878");
		 * driver.findElement(By.cssSelector("input[title*='Sign ']")).click();
		 * System.out.println(driver.findElement(By.xpath(
		 * "//div[contains(@style,'float')]")).getText());
		 * 
		 * //identifying xpath from its parents
		 * 
		 * driver.get("http://google.com");
		 * driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).
		 * sendKeys("currys");
		 * driver.findElement(By.xpath("//div[@class='uFMOof']")).click();
		 */
	}

}
