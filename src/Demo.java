import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

public class Demo {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		WebElement login = driver.findElement(By.xpath("//ul[@class='rd-navbar-nav']/a"));
		login.click();
		Thread.sleep(5000L);
		driver.findElement(By.name("email")).sendKeys("ms.shameer@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Shameer@123");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		// driver.findElement(By.xpath("//div[@class='ui stacked
		// segment']/div[3]")).click();
		Thread.sleep(5000L);
		String title1 = driver.getTitle();
		System.out.println(title1);
		// Cogmento CRM
		Assert.assertEquals("Cogmento CRM", title1);
		// driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		/*
		 * List<WebElement> list= driver.findElements(By.tagName("a")); for(int
		 * i=0;i<list.size();i++) { System.out.println(list.get(i).getText()); }
		 */

		driver.findElement(By.xpath("//div[@id='main-nav']/a[3]")).click();
		Thread.sleep(5000L);
		WebElement contacttext = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[1]"));
		contacttext.getText();
		System.out.println(contacttext);
		// Assert.assertEquals("Cogmento CRM", contacttext);
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();
		WebElement newcontact = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div"));
		newcontact.getText();
		System.out.println(newcontact);
		// Assert.assertEquals("Cogmento CRM", newcontact);
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("shahid");
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("mulla");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@name='category']")).click();
		driver.findElement(By.xpath("//div[@name='category']/div[2]/div[3]")).click();
		driver.findElement(By.linkText("Customer")).click();
		//List<WebElement> categoryList=driver.findElements(By.xpath("//div[@name='category']/div[2]"));
		//System.out.println("category list: " +categoryList.size());
		
		/*
		 * List<WebElement>
		 * category=driver.findElements(By.xpath("//div[@name='category']/div[2]")); int
		 * catlist=category.size(); System.out.println("Category " +catlist); for (int
		 * i=0; i<category.size(); i++) { String categoryList =
		 * category.get(i).getText(); if(categoryList.equalsIgnoreCase("Customer")) {
		 * driver.findElement(By.xpath("//div[@name='category']/div[2]")).click();
		 * break; }
		 * 
		 * }
		 */
		// Select category=new
		// Select(driver.findElement(By.cssSelector("div[name='category']")));
		// category.selectByValue("Customer");
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
		String nametitle=driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[1]")).getText();
		//System.out.println(nametitle);
		WebElement newcontactcreated = driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div"));
		newcontactcreated.getText();
		System.out.println("Contacts name: " + newcontactcreated);
		// Assert.assertEquals("Cogmento CRM", newcontactcreated);

		Thread.sleep(5000L);
		driver.findElement(By.xpath("//div[@id='main-nav']/a[3]")).click();

		Thread.sleep(5000L);
		WebElement table = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table"));
		System.out.println(table);

		int rowcount = table.findElements(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr"))
				.size();
		System.out.println(rowcount);

		String contname = table
				.findElement(By.xpath("//*[@id='ui']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
		System.out.println(contname);
		Assert.assertEquals("shahid mulla", contname);

	}

}
