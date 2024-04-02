import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,6000)");
		SoftAssert a = new SoftAssert();
		//String link = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		//System.out.println(link);
		//Java methods to call the URLs
		List<WebElement> links = driver.findElements(By.cssSelector(".gf-li a"));
		for(WebElement link:links)
		{		
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int code = conn.getResponseCode();
			a.assertTrue(code<400, "The broken link is : "+url+" Response code is: "+code);
		}
		a.assertAll();
	}

}
