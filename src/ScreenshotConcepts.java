import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotConcepts {

	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();//Launch chrome
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();//maximize window
		driver.manage().deleteAllCookies();//delete all the cookies
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//go to https://commons.apache.org/proper/commons-io/ -->binaries/zip and download the jar file and then add them in external jar
		//Add throws declaration
		FileUtils.copyFile(src,new File("C:\\Users\\basha440226\\Downloads\\selenium\\screenshot.png"));
	}

}
